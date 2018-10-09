package com.pgt.proyecto.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pgt.proyecto.model.Club;

@Repository
public interface ClubDAO extends JpaRepository<Club, Integer>{

	List<Club> findByName(String name);

}
