package com.mk.mnx.mdc.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mk.mnx.infr.model.BaseModel;

@Document(collection = "notas")
public class Nota  extends BaseModel{

	@Id
	private String id;
	
	@Indexed
	private String idPaciente;
	
	private String padecimiento;
	
	private SignosVitales signosVitales;
	
	private Somatometria somatometria;
	
	private ExploracionFisica exploracionFisica;
	
	private String diagnostico;
	
	private String tratamiento;
	
	private String notas;
	
	private DatosAuditoria datosAuditoria;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getPadecimiento() {
		return padecimiento;
	}

	public void setPadecimiento(String padecimiento) {
		this.padecimiento = padecimiento;
	}

	public SignosVitales getSignosVitales() {
		return signosVitales;
	}

	public void setSignosVitales(SignosVitales signosVitales) {
		this.signosVitales = signosVitales;
	}

	public Somatometria getSomatometria() {
		return somatometria;
	}

	public void setSomatometria(Somatometria somatometria) {
		this.somatometria = somatometria;
	}

	public ExploracionFisica getExploracionFisica() {
		return exploracionFisica;
	}

	public void setExploracionFisica(ExploracionFisica exploracionFisica) {
		this.exploracionFisica = exploracionFisica;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public DatosAuditoria getDatosAuditoria() {
		return datosAuditoria;
	}

	public void setDatosAuditoria(DatosAuditoria datosAuditoria) {
		this.datosAuditoria = datosAuditoria;
	}

}
