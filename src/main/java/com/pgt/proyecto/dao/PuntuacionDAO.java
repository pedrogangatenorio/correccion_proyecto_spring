package com.pgt.proyecto.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pgt.proyecto.model.Prueba;
import com.pgt.proyecto.model.Puntuacion;

@Repository
public interface PuntuacionDAO extends JpaRepository<Puntuacion, Integer>{

	@Query("FROM Puntuacion p WHERE p.prueba = :prueba ORDER BY posicion ASC")
	List<Puntuacion> findByPrueba(@Param("prueba") Prueba prueba);

}
