package com.pgt.proyecto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pgt.proyecto.model.Prueba;

@Repository
public interface PruebaDAO extends JpaRepository<Prueba, Integer>{

	List<Prueba> findByName(String name);

}


