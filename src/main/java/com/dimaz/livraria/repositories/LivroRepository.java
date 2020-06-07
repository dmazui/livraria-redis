package com.dimaz.livraria.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dimaz.livraria.domain.models.Livro;

public interface LivroRepository extends CrudRepository<Livro, String>{

}
