package com.pgt.proyecto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pgt.proyecto.dao.ClubDAO;
import com.pgt.proyecto.dto.ClubDTO;
import com.pgt.proyecto.dto.CorredorDTO;
import com.pgt.proyecto.mapper.ClubMapper;
import com.pgt.proyecto.mapper.CorredorMapper;
import com.pgt.proyecto.model.Club;
import com.pgt.proyecto.model.Corredor;

@Service
public class ClubServiceImpl implements ClubService{

	@Autowired
	ClubDAO dao;
	
	@Autowired
	ClubMapper mapper;
	
	@Autowired
	CorredorMapper corredormapper;
	
	@Autowired
	CorredorService corredorservice;
	
	public List<ClubDTO> findAll(String name){
		return name!= null ? mapper.mapToDTO(dao.findByName(name)) : mapper.mapToDTO(dao.findAll());
	}

	@Override
	public ClubDTO findById(Integer id){
		return mapper.mapToDTO(dao.findById(id).orElse(null));
	}

	@Override
	public ClubDTO create(ClubDTO clubDTO) {
		return mapper.mapToDTO(dao.save(mapper.mapToModel(clubDTO)));
	}
	
	@Override
	public CorredorDTO create(CorredorDTO corredorToCreate, Integer id) {
		Corredor c = corredormapper.mapToModel(corredorToCreate);
		c.setClub(mapper.mapToModel(this.findById(id)));
		return corredormapper.mapToDTO(corredorservice.save(c));
	}

	@Override
	public void update(Integer id, ClubDTO clubDTO) {
		Club club = mapper.mapToModel(clubDTO);
		club.setId(id);
		dao.saveAndFlush(club);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}	

	@Override
	public void update(Integer id, Integer idCorredor, CorredorDTO corredor) {
		Corredor c = corredormapper.mapToModel(corredor);
		Corredor corredorToUpdate = corredormapper.mapToModel(corredorservice.findById(idCorredor));
		corredorToUpdate.setName(c.getName());
		corredorToUpdate.setYear(c.getYear());
		corredorToUpdate.setClub(mapper.mapToModel(this.findById(id)));
		corredorservice.save(corredorToUpdate);		
	}
}
