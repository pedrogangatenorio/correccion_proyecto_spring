package com.pgt.proyecto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pgt.proyecto.dao.ResultadoDAO;
import com.pgt.proyecto.dto.ResultadoDTO;
import com.pgt.proyecto.mapper.ResultadoMapper;
import com.pgt.proyecto.model.Prueba;
import com.pgt.proyecto.model.Resultado;

@Service
public class ResultadoServiceImpl implements ResultadoService{
	
	@Autowired
	ResultadoDAO dao;
	
	@Autowired
	ResultadoMapper resultadomapper;

	@Override
	public List<ResultadoDTO> findAllCorredor() {
		return resultadomapper.mapToDTO(dao.findAll());
	}

	@Override
	public ResultadoDTO findById(Integer id) {
		return resultadomapper.mapToDTO(dao.findById(id).orElse(null));
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);			
	}

	@Override
	public Resultado save(Resultado r) {
		return dao.save(r);
	}

	@Override
	public List<Resultado> findCategoria(Prueba mapToModel, int i) {
		return dao.findByCategoria(mapToModel, i);
	}

	@Override
	public List<Resultado> findPrueba(Prueba mapToModel) {
		return dao.findByPrueba(mapToModel);
	}
		
}
