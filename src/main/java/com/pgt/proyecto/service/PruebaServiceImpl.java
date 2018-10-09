package com.pgt.proyecto.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pgt.proyecto.dao.PruebaDAO;
import com.pgt.proyecto.dto.ClasificacionDTO;
import com.pgt.proyecto.dto.PruebaDTO;
import com.pgt.proyecto.dto.ResultadoDTO;
import com.pgt.proyecto.mapper.PruebaMapper;
import com.pgt.proyecto.mapper.ResultadoMapper;
import com.pgt.proyecto.model.Prueba;
import com.pgt.proyecto.model.Puntuacion;
import com.pgt.proyecto.model.Resultado;
import com.pgt.proyecto.operation.Ranking;

@Service
public class PruebaServiceImpl implements PruebaService{

	@Autowired
	PruebaDAO dao;
	
	@Autowired
	PruebaMapper mapper;
	
	@Autowired
	Ranking ranking;
		
	@Autowired
	PuntuacionService puntuacionService;
	
	@Autowired
	ResultadoMapper resultadomapper;
	
	@Autowired
	ResultadoService resultadoservice;
	
	@Override
	public List<PruebaDTO> findAll(String name) {
		return name!= null ? mapper.mapToDTO(dao.findByName(name)) : mapper.mapToDTO(dao.findAll());
	}

	@Override
	public PruebaDTO findById(Integer id) {
		return mapper.mapToDTO(dao.findById(id).orElse(null));
	}

	@Override
	public PruebaDTO create(PruebaDTO mapToModel) {
		return mapper.mapToDTO(dao.save(mapper.mapToModel(mapToModel)));
	}

	@Override
	public void update(Integer id, PruebaDTO mapToModel) {
		Prueba p = mapper.mapToModel(mapToModel);
		p.setId(id);
		dao.saveAndFlush(p);		
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);		
	}
	
	@Override
	public ResultadoDTO create(ResultadoDTO mapToModel, Integer id) {
		Resultado r = resultadomapper.mapToModel(mapToModel);
		r.setPrueba(mapper.mapToModel(this.findById(id)));
		return resultadomapper.mapToDTO(resultadoservice.save(r));
	}

	@Override
	public void update(Integer id, Integer idResultado, ResultadoDTO mapToModel) {
		Resultado resultadoToUpdate = resultadomapper.mapToModel(resultadoservice.findById(idResultado));
		resultadoToUpdate.setSeconds(resultadomapper.mapToModel(mapToModel).getSeconds());
		resultadoToUpdate.setPrueba(mapper.mapToModel(this.findById(id)));
		resultadoservice.save(resultadoToUpdate);
	}
	
	@Override
	public Map<String,Integer> clasificacionPrueba(Integer id) {
		return opera(resultadoservice.findPrueba(mapper.mapToModel(this.findById(id))),puntuacionService.getPuntuacion(mapper.mapToModel(this.findById(id))),id);
	}
	
	public Map<String,Integer> opera(List<Resultado> result,List<Puntuacion> puntos,Integer id) {
		Map<String, Integer> res = new HashMap<>();
		for (int i=0;i<puntos.size();i++) {
			String nombre = result.get(i).getCorredor().getClub().getName();
			Integer puntu = puntos.get(i).getPuntos();
			if(res.get(nombre)==null) {
				res.put(nombre, puntu);
			}else {
				res.put(nombre, res.get(nombre)+puntu);
			}
		}
		ranking.escribefichero(res,mapper.mapToModel(this.findById(id)).getName());
		return res;
	}

	@Override
	public List<ClasificacionDTO> clasificacionCategoria(Integer id, Integer categoria) {
		return resultadomapper.mapToDTOC(resultadoservice.findCategoria(mapper.mapToModel(this.findById(id)), Calendar.getInstance().get(Calendar.YEAR) - categoria));
	}
}
