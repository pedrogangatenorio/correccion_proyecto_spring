package com.pgt.proyecto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.pgt.proyecto.dto.CorredorDTO;
import com.pgt.proyecto.model.Corredor;

@Component
public class CorredorMapperImpl implements CorredorMapper{
	
	@Override
	public Corredor mapToModel(CorredorDTO dto) {
		final Corredor corredor = new Corredor();
		corredor.setIdCorredor(dto.getId());
		corredor.setName(dto.getName());
		corredor.setYear(dto.getYear());
		return corredor;
	}

	@Override
	public CorredorDTO mapToDTO(Corredor model) {
		CorredorDTO corredordto = null;
		if(model != null) {
			corredordto = new CorredorDTO();
			corredordto.setId(model.getIdCorredor());
			corredordto.setName(model.getName());
			corredordto.setYear(model.getYear());
		}
		return corredordto;
	}

	@Override
	public List<CorredorDTO> mapToDTO(List<Corredor> models) {
		return models.parallelStream().map(this::mapToDTO)
		.collect(Collectors.toList());
	}

}
