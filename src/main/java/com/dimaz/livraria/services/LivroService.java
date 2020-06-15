package com.dimaz.livraria.services;

import java.util.List;

import com.dimaz.livraria.domain.dtos.LivroDTO;
import com.dimaz.livraria.domain.models.Livro;

public interface LivroService {
    
	Livro save(LivroDTO livroDto);

	Livro findById(String livroId);

	List<Livro> findAll(LivroDTO filter);

	Livro deletById(String livroId);

}
