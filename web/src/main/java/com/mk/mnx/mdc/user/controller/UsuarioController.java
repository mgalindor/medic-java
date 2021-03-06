package com.mk.mnx.mdc.user.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mk.mnx.infr.controller.BaseRestController;
import com.mk.mnx.mdc.model.domain.DatosDoctor;
import com.mk.mnx.mdc.model.domain.Usuario;
import com.mk.mnx.mdc.model.states.EnuRole;
import com.mk.mnx.mdc.support.annotation.AccessValidation;
import com.mk.mnx.mdc.user.service.DoctorService;
import com.mk.mnx.mdc.user.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController extends BaseRestController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private DoctorService doctorService;

	@PostMapping("/createTemporalAdmin")
	public Usuario createTemporalAdmin(@RequestBody Usuario usuario) {
		return usuarioService.creaUsuario(usuario, getUser());
	}

	@PostMapping
	@AccessValidation(roles = { EnuRole.ADMIN })
	public Usuario creaUsuario(@RequestBody Usuario usuario) {
		return usuarioService.creaUsuario(usuario, getUser());
	}

	@PutMapping
	@AccessValidation(roles = { EnuRole.ADMIN })
	public Usuario actualizaUsuario(@RequestBody Usuario usuario) {
		return usuarioService.actualizaUsuario(usuario, getUser());
	}

	@GetMapping
	@AccessValidation(roles = { EnuRole.ADMIN })
	public List<Usuario> buscaUsuarios(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "active", required = false) Boolean active,
			@RequestParam(value = "sort", required = false) Sort.Direction sort,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "results", required = false) Integer results,
			@RequestParam(value = "cedula", required = false) String cedula,
			@RequestParam(value = "role", required = false) String role,
			@RequestParam(value = "docFilled", required = false) boolean docFilled ) {
		return usuarioService.buscarUsuarios(name, email, active, sort, page, results,cedula,role,docFilled);
	}

	@GetMapping("/total")
	@AccessValidation(roles = { EnuRole.ADMIN })
	public Map<String, Long> buscarTotalUsuarios(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "status", required = false) Boolean status,
			@RequestParam(value = "cedula", required = false) String cedula,
			@RequestParam(value = "role", required = false) String role,
			@RequestParam(value = "docFilled", required = false) boolean docFilled ) {
		long total = usuarioService.buscarTotalUsuarios(name, email, status,cedula,role,docFilled);
		return Collections.singletonMap("total", total);
	}

	@GetMapping("/{idUser}")
	@AccessValidation(roles = { EnuRole.ADMIN })
	public Usuario buscaUsuario(@PathVariable("idUser") String idUser) {
		return usuarioService.buscaUsuarioPorId(idUser);
	}

	@DeleteMapping
	@AccessValidation(roles = { EnuRole.ADMIN })
	public void borraUsuario(@RequestBody Usuario usuario) {
		usuarioService.borraUsuario(usuario, getUser());
	}

	@PostMapping("/{idUser}/doctor/")
	@AccessValidation(roles = { EnuRole.ADMIN })
	public DatosDoctor creaDoctor(@PathVariable("idUser") String idUser, @RequestBody DatosDoctor doctor) {
		return doctorService.crearDoctor(idUser, doctor, getUser());
	}

	@PutMapping("/{idUser}/doctor/")
	@AccessValidation(roles = { EnuRole.ADMIN, EnuRole.MEDICO })
	public DatosDoctor actualizaDatosDoctor(@PathVariable("idUser") String idUser, @RequestBody DatosDoctor doctor) {
		return doctorService.actualizarDoctor(idUser, doctor, getUser());
	}

	@GetMapping("/{idUser}/doctor/")
	@AccessValidation(roles = { EnuRole.ADMIN, EnuRole.MEDICO })
	public DatosDoctor buscaDoctor(@PathVariable("idUser") String idUser) {
		return doctorService.buscarDoctor(idUser);
	}

}
