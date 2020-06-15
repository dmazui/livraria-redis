package com.dimaz.livraria.domain.mappers;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dimaz.livraria.domain.dtos.LivroDTO;
import com.dimaz.livraria.domain.models.Livro;

@Component
public class LivroToLivroDTO implements Converter<Livro, LivroDTO> {

	@Override
	public LivroDTO convert(Livro livro) {
		LivroDTO livroForm = new LivroDTO();
		
		livroForm.setId(livro.getId());
		livroForm.setTitulo(livro.getTitulo());
		livroForm.setIsbn(livro.getIsbn());
		livroForm.setAutor(livro.getAutor());
		
		return livroForm;
	}
	
}
