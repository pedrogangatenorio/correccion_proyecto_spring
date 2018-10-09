package com.pgt.proyecto.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.pgt.proyecto.dto.CorredorDTO;
import com.pgt.proyecto.model.Corredor;

public interface CorredorService {

	List<CorredorDTO> findAllCorredor(Pageable of,String name);
	
	CorredorDTO findById(Integer id);

	void delete(Integer id);
	
	Corredor save(Corredor corredor);

}
