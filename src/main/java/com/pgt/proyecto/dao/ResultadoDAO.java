package com.pgt.proyecto.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pgt.proyecto.model.Prueba;
import com.pgt.proyecto.model.Resultado;

@Repository
public interface ResultadoDAO extends JpaRepository<Resultado, Integer>{
	
	@Query("FROM Resultado p WHERE p.prueba = :prueba ORDER BY seconds ASC")
	List<Resultado> findByPrueba(@Param("prueba") Prueba prueba);
	
	@Query("Select r from Resultado r JOIN r.corredor c where r.prueba like :id and c.year < :categoria ORDER BY r.seconds")
	List<Resultado> findByCategoria(@Param("id") Prueba id,@Param("categoria")  Integer categoria);
}
