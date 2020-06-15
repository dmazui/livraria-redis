package com.dimaz.livraria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dimaz.livraria.domain.dtos.LivroDTO;
import com.dimaz.livraria.domain.models.Livro;
import com.dimaz.livraria.services.LivroService;

@RestController
@RequestMapping("/livro/v1")
public class LivroController {
	
	@Autowired
	private LivroService service;
	
	
	// insere
	@PostMapping("")
	public ResponseEntity<Livro> save(@Validated LivroDTO livroDto) throws Exception {
		return ResponseEntity.ok(service.save(livroDto));
	}
	
	// busca por id
	@GetMapping("{id}")
	public ResponseEntity<Livro> findById(@PathVariable("id") String livroId) throws Exception {
		return (service.findById(livroId) != null) ? ResponseEntity.ok(service.findById(livroId)) : ResponseEntity.notFound().build();
	}
	
	// busca lista
	@GetMapping
	public ResponseEntity<List<Livro>> findAll(@Validated LivroDTO filter) throws Exception {
		return ResponseEntity.ok(service.findAll(filter));
	}
	
	//delete
	//@DeleteMapping
	
	// edit
	//@PatchMapping
	
}
