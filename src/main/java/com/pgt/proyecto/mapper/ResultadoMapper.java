package com.pgt.proyecto.mapper;

import java.util.List;

import com.pgt.proyecto.dto.ClasificacionDTO;
import com.pgt.proyecto.dto.ResultadoDTO;
import com.pgt.proyecto.model.Resultado;

public interface ResultadoMapper extends Mapper<Resultado,ResultadoDTO>{

	List<ClasificacionDTO> mapToDTOC(List<Resultado> models);
}
