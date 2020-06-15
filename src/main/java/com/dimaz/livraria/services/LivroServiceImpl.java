package com.dimaz.livraria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dimaz.livraria.domain.dtos.LivroDTO;
import com.dimaz.livraria.domain.mappers.LivroDTOToLivro;
import com.dimaz.livraria.domain.models.Livro;
import com.dimaz.livraria.repositories.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService{
	
	@Autowired
    private LivroRepository repository;
	
	@Autowired
	private LivroDTOToLivro toLivro;

	@Override
	public Livro save(LivroDTO livroDto) {
		return repository.save(toLivro.convert(livroDto));
	}

	@Override
	public Livro findById(String livroId) {
		return findById(livroId);
	}

	@Override
	public List<Livro> findAll(LivroDTO filter) {
		
		return null;
	}

	@Override
	public Livro deletById(String livroId) {
		return null;
	}

    
	
}
