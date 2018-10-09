package com.pgt.proyecto.service;

import java.util.List;
import com.pgt.proyecto.dto.ResultadoDTO;
import com.pgt.proyecto.model.Prueba;
import com.pgt.proyecto.model.Resultado;

public interface ResultadoService {

	List<ResultadoDTO> findAllCorredor();

	ResultadoDTO findById(Integer id);

	void delete(Integer id);

	Resultado save(Resultado r);

	List<Resultado> findCategoria(Prueba mapToModel, int i);

	List<Resultado> findPrueba(Prueba mapToModel);

}
