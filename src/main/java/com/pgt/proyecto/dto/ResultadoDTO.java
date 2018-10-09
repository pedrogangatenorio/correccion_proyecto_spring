package com.pgt.proyecto.dto;

public class ResultadoDTO {
	
	private Integer Id;
	private Integer IdRunner;
	private Integer seconds;
	
	public ResultadoDTO() {}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getIdRunner() {
		return IdRunner;
	}

	public void setIdRunner(Integer idRunner) {
		IdRunner = idRunner;
	}

	public Integer getSeconds() {
		return seconds;
	}

	public void setSeconds(Integer seconds) {
		this.seconds = seconds;
	}
	
	
}
