package com.dimaz.livraria.domain.models;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("livros")
public class Livro {

	private String id;
	private String titulo;
	private String isbn;
	private String autor;
	
}
