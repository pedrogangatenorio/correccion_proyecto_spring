package com.pgt.proyecto.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.pgt.proyecto.dto.ClubDTO;
import com.pgt.proyecto.model.Club;

@Component
public class ClubMapperImpl implements ClubMapper{
	
	@Override
	public Club mapToModel(ClubDTO dto) {
		final Club club = new Club();
		club.setName(dto.getName());
		club.setId(dto.getId());
		return club;
	}

	@Override
	public ClubDTO mapToDTO(Club model) {
		ClubDTO userdto = null;
		if(model != null) { 
			userdto = new ClubDTO();
			userdto.setId(model.getId());
			userdto.setName(model.getName());
		}
		return userdto;
	}

	@Override
	public List<ClubDTO> mapToDTO(List<Club> models) {
		return models.parallelStream().map(this::mapToDTO)
				.collect(Collectors.toList());
	}

}
