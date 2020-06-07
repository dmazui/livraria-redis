package com.dimaz.livraria.domain.mappers;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dimaz.livraria.domain.dtos.LivroForm;
import com.dimaz.livraria.domain.models.Livro;

@Component
public class LivroToLivroForm implements Converter<Livro, LivroForm> {

	@Override
	public LivroForm convert(Livro livro) {
		LivroForm livroForm = new LivroForm();
		
		livroForm.setId(livro.getId());
		livroForm.setTitulo(livro.getTitulo());
		livroForm.setIsbn(livro.getIsbn());
		livroForm.setAutor(livro.getAutor());
		
		return livroForm;
	}
	
}
