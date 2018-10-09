package com.pgt.proyecto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.pgt.proyecto.dto.PruebaDTO;
import com.pgt.proyecto.model.Prueba;

@Component
public class PruebaMapperImpl implements PruebaMapper{

	@Override
	public Prueba mapToModel(PruebaDTO dto) {
		final Prueba prueba = new Prueba();
		prueba.setId(dto.getId());
		prueba.setName(dto.getName());
		prueba.setDate(dto.getDate());
		return prueba;
	}

	@Override
	public PruebaDTO mapToDTO(Prueba model) {
		PruebaDTO pruebadto=null;
		if(model != null) {
			pruebadto = new PruebaDTO();
			pruebadto.setId(model.getId());
			pruebadto.setName(model.getName());
			pruebadto.setDate(model.getDate());
		}
		return pruebadto;
	}

	@Override
	public List<PruebaDTO> mapToDTO(List<Prueba> models) {
		return models.parallelStream().map(this::mapToDTO)
				.collect(Collectors.toList());
	}

}
