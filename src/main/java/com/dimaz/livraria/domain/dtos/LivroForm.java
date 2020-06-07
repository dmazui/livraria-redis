package com.dimaz.livraria.domain.dtos;

import lombok.Data;

@Data
public class LivroForm {
	
	private String id;
	private String titulo;
	private String isbn;
	private String autor;
	
}
