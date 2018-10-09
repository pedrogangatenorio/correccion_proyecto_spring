package com.pgt.proyecto.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pgt.proyecto.dto.CorredorDTO;
import com.pgt.proyecto.service.CorredorService;

@RestController
@RequestMapping("/corredor")
public class CorredorController {

		@Autowired
		CorredorService corredorservice;
		
		@GetMapping
		public List<CorredorDTO> findAll(
				@RequestParam(defaultValue = "0", value = "page", required = false) Integer page,
				@RequestParam(defaultValue = "3", value = "size", required = false) Integer size,
				@RequestParam(value = "name", required = false) String name) {
			return corredorservice.findAllCorredor(PageRequest.of(page, size),name);
		}
		
		@GetMapping("/{idCorredor}")
		public ResponseEntity<CorredorDTO> findById(@PathVariable Integer idCorredor) {
		    return Optional
		            .ofNullable( corredorservice.findById(idCorredor) )
		            .map( user -> ResponseEntity.ok().body(user) )          
		            .orElseGet( () -> ResponseEntity.notFound().build() ); 
		}
		
		@DeleteMapping("/{idCorredor}")
		public void delete(@PathVariable Integer idCorredor) {
			corredorservice.delete(idCorredor);
		}
}
