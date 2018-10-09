package com.pgt.proyecto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.pgt.proyecto.dao.CorredorDAO;
import com.pgt.proyecto.dto.CorredorDTO;
import com.pgt.proyecto.mapper.ClubMapper;
import com.pgt.proyecto.mapper.CorredorMapper;
import com.pgt.proyecto.model.Corredor;

@Service
public class CorredorServiceImpl implements CorredorService{
	
	@Autowired
	CorredorDAO dao;
	
	@Autowired
	ClubService clubservice;
	
	@Autowired
	ClubMapper mapper;
	
	@Autowired
	CorredorMapper corredormapper;

	@Override
	public List<CorredorDTO> findAllCorredor(Pageable pagination,String name) {
		return name != null ? corredormapper.mapToDTO(dao.findByNameContaining(name, pagination).getContent()) : corredormapper.mapToDTO(dao.findAll());
	}

	@Override
	public CorredorDTO findById(Integer id) {
		return corredormapper.mapToDTO(dao.findById(id).orElse(null));
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);		
	}

	@Override
	public Corredor save(Corredor corredor) {
		return dao.save(corredor);
		
	}
}
