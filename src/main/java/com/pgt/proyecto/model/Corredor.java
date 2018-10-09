package com.pgt.proyecto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Corredor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCorredor;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "corredor")
	private List<Resultado> resultados = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Club club;
	
	private String name;
	
	private Integer year;
	
	public Corredor() {}
	
	public Corredor(Integer idCorredor,String name, Integer year) {
		this.idCorredor=idCorredor;
		this.name=name;
		this.year=year;
	}

	public Integer getIdCorredor() {
		return idCorredor;
	}

	public void setIdCorredor(Integer idCorredor) {
		this.idCorredor = idCorredor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}	
}
