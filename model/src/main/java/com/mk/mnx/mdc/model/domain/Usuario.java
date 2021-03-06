package com.mk.mnx.mdc.model.domain;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mk.mnx.infr.model.BaseModel;
import com.mk.mnx.mdc.model.states.EnuRole;

@Document(collection = "usuarios")
public class Usuario extends BaseModel {

	@Id
	private String id;
	
	@Indexed(unique=true)
	private String nombre;
	
	private String password;
	
	private Boolean isConnected;
	
	private Set<EnuRole> roles;
	
	private DatosDoctor datosDoctor;
	
	private DatosAuditoria datosAuditoria;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsConnected() {
		return isConnected;
	}

	public void setIsConnected(Boolean isConnected) {
		this.isConnected = isConnected;
	}

	public Set<EnuRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<EnuRole> roles) {
		this.roles = roles;
	}

	public DatosDoctor getDatosDoctor() {
		return datosDoctor;
	}

	public void setDatosDoctor(DatosDoctor datosDoctor) {
		this.datosDoctor = datosDoctor;
	}

	public DatosAuditoria getDatosAuditoria() {
		return datosAuditoria;
	}

	public void setDatosAuditoria(DatosAuditoria datosAuditoria) {
		this.datosAuditoria = datosAuditoria;
	}

	
}
