package com.pgt.proyecto.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pgt.proyecto.dto.ClasificacionDTO;
import com.pgt.proyecto.dto.PruebaDTO;
import com.pgt.proyecto.dto.ResultadoDTO;
import com.pgt.proyecto.service.PruebaService;

@RestController
@RequestMapping("/prueba")
public class PruebaController {
	
	@Autowired
	PruebaService pruebaservice;
	
	@GetMapping
	public List<PruebaDTO> findAll(@RequestParam(value = "name", required = false) String name) {
		return pruebaservice.findAll(name);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PruebaDTO> findById(@PathVariable Integer id) {
	    return Optional
	            .ofNullable( pruebaservice.findById(id) )
	            .map( user -> ResponseEntity.ok().body(user) )          
	            .orElseGet( () -> ResponseEntity.notFound().build());  
	}

	@PostMapping
	public PruebaDTO create(@RequestBody PruebaDTO pruebaToCreate) {
		return pruebaservice.create(pruebaToCreate);
	}

	@PutMapping("/{id}")
	public void update(@RequestBody PruebaDTO pruebaToUpdate,@PathVariable Integer id) {
		pruebaservice.update(id, pruebaToUpdate);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		pruebaservice.delete(id);
	}
	
	@PostMapping("/{id}/resultado")
	public ResultadoDTO create(@PathVariable Integer id,@RequestBody ResultadoDTO resultadoDTO) {
		return pruebaservice.create(resultadoDTO, id);
	}
	
	@PutMapping("/{id}/resultado/{idResultado}")
	public void update(@RequestBody ResultadoDTO resultadoToUpdate,@PathVariable Integer id,
			@PathVariable Integer idResultado) {
		pruebaservice.update(id,idResultado, resultadoToUpdate);
	}
	
	@GetMapping("/{id}/resultado")
	public Map<String,Integer> clasificacionPrueba(@PathVariable Integer id){
		return pruebaservice.clasificacionPrueba(id);
	}
	
	@GetMapping("/{id}/categoria/{categoria}")
	public List<ClasificacionDTO> clasificacionCategoria(@PathVariable Integer id,@PathVariable Integer categoria){
		return pruebaservice.clasificacionCategoria(id,categoria);
	}
}
