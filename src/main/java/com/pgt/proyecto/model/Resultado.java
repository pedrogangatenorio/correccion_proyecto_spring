package com.pgt.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Resultado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idResultado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Corredor corredor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Prueba prueba;
	
	private Integer seconds;
	
	public Resultado() {}
	
	public Integer getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(Integer idResultado) {
		this.idResultado = idResultado;
	}

	public Integer getSeconds() {
		return seconds;
	}

	public void setSeconds(Integer seconds) {
		this.seconds = seconds;
	}

	public Corredor getCorredor() {
		return corredor;
	}

	public void setCorredor(Corredor corredor) {
		this.corredor = corredor;
	}

	public Prueba getPrueba() {
		return prueba;
	}

	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}
}
