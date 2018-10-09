package com.pgt.proyecto.service;

import java.util.List;
import java.util.Map;

import com.pgt.proyecto.dto.ClasificacionDTO;
import com.pgt.proyecto.dto.PruebaDTO;
import com.pgt.proyecto.dto.ResultadoDTO;

public interface PruebaService {

	List<PruebaDTO> findAll(String name);

	PruebaDTO findById(Integer id);

	PruebaDTO create(PruebaDTO mapToModel);

	void update(Integer id, PruebaDTO mapToModel);

	void delete(Integer id);

	ResultadoDTO create(ResultadoDTO resultadoDTO, Integer id);

	void update(Integer id, Integer idResultado, ResultadoDTO resultadoToUpdate);

	Map<String, Integer> clasificacionPrueba(Integer id);

	List<ClasificacionDTO> clasificacionCategoria(Integer id, Integer categoria);
}
