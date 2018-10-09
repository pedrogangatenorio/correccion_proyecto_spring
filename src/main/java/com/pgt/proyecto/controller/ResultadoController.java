package com.pgt.proyecto.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pgt.proyecto.dto.ResultadoDTO;
import com.pgt.proyecto.service.ResultadoService;

@RestController
@RequestMapping("/resultado")
public class ResultadoController {

	@Autowired
	ResultadoService resultadoservice;
	
	@GetMapping
	public List<ResultadoDTO> findAll() {
		return resultadoservice.findAllCorredor();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResultadoDTO> findById(@PathVariable Integer id) {
	    return Optional
	            .ofNullable( resultadoservice.findById(id) )
	            .map( user -> ResponseEntity.ok().body(user) )          
	            .orElseGet( () -> ResponseEntity.notFound().build() ); 
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		resultadoservice.delete(id);
	}
}
