package com.pgt.proyecto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pgt.proyecto.dao.PuntuacionDAO;
import com.pgt.proyecto.model.Prueba;
import com.pgt.proyecto.model.Puntuacion;

@Service
public class PuntuacionServiceImpl implements PuntuacionService{
	
	@Autowired
	PuntuacionDAO dao;

	@Override
	public List<Puntuacion> getPuntuacion(Prueba prueba) {
		return dao.findByPrueba(prueba);
	}



}
