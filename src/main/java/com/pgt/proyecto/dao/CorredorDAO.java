package com.pgt.proyecto.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pgt.proyecto.model.Corredor;

@Repository
public interface CorredorDAO extends JpaRepository<Corredor, Integer>{

	Page<Corredor> findByNameContaining(String name, Pageable pageable);

}
