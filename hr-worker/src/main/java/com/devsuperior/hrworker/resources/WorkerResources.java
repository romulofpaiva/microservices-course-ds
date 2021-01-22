package com.devsuperior.hrworker.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.dtos.WorkerDTO;
import com.devsuperior.hrworker.services.WorkerService;

@RestController
@RequestMapping(value="/workers")
public class WorkerResources {

	@Autowired
	private WorkerService service;
	
	@GetMapping
	public ResponseEntity<List<WorkerDTO>> findAll() {
		return ResponseEntity.ok( 
			service.findAll()
				.stream()
				.map( i -> i.asDTO() )
				.collect( Collectors.toList() ) );
 	}
	
	@GetMapping("/{id}")
	public ResponseEntity<WorkerDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok( service.findById( id ).asDTO() );
 	}
}
