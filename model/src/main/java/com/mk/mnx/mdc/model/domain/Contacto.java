package com.mk.mnx.mdc.model.domain;

import com.mk.mnx.infr.model.BaseModel;

public class Contacto extends BaseModel {

	private String nombre;
	
	private String apPaterno;
	
	private String apMaterno;
	
	private String email;
	
	private String tel;
	
	private String cel;
	
	private String nombreCompleto;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	public String creaNombreCompleto() {
		StringBuffer sb = new StringBuffer();
		sb.append(nombre != null ? nombre : "");
		sb.append(" ");
		sb.append(apPaterno != null ? apPaterno : "");
		sb.append(" ");
		sb.append(apMaterno != null ? apMaterno : "");
		return sb.toString();
	}
	
	
}
