package com.pgt.proyecto.mapper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pgt.proyecto.dto.ClasificacionDTO;
import com.pgt.proyecto.dto.ResultadoDTO;
import com.pgt.proyecto.model.Resultado;
import com.pgt.proyecto.service.CorredorService;

@Component
public class ResultadoMapperImpl implements ResultadoMapper{
	
	@Autowired
	CorredorService corredorservice;
	
	@Autowired
	CorredorMapper mapper;

	@Override
	public Resultado mapToModel(ResultadoDTO dto) {
		final Resultado resultado = new Resultado();
		resultado.setIdResultado(dto.getId());
		resultado.setSeconds(dto.getSeconds());
		resultado.setCorredor(mapper.mapToModel(corredorservice.findById(dto.getIdRunner())));
		return resultado;
	}

	@Override
	public ResultadoDTO mapToDTO(Resultado model) {
		ResultadoDTO resultadodto = null;
		if(model != null) {
			resultadodto = new ResultadoDTO();
			resultadodto.setId(model.getIdResultado());
			resultadodto.setSeconds(model.getSeconds());
			resultadodto.setIdRunner(model.getCorredor().getIdCorredor());
		}
		return resultadodto;
	}

	@Override
	public List<ResultadoDTO> mapToDTO(List<Resultado> models) {
		return models.parallelStream().map(this::mapToDTO)
		.collect(Collectors.toList());
	}
	
	@Override
	public List<ClasificacionDTO> mapToDTOC(List<Resultado> models){
		List<ClasificacionDTO>res = new ArrayList<>();
		for(Resultado r: models) {
			ClasificacionDTO c = new ClasificacionDTO();
			c.setId(r.getCorredor().getIdCorredor());
			c.setName(r.getCorredor().getName());
			c.setSeconds(r.getSeconds());
			c.setAge(Calendar.getInstance().get(Calendar.YEAR) - r.getCorredor().getYear());
			res.add(c);
		}
		return res;
	}
}
