package com.pgt.proyecto.service;

import java.util.List;
import com.pgt.proyecto.model.Prueba;
import com.pgt.proyecto.model.Puntuacion;

public interface PuntuacionService {

	List<Puntuacion> getPuntuacion(Prueba prueba);

}
