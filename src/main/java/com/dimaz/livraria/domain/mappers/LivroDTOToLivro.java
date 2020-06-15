package com.dimaz.livraria.domain.mappers;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dimaz.livraria.domain.dtos.LivroDTO;
import com.dimaz.livraria.domain.models.Livro;

@Component
public class LivroDTOToLivro implements Converter<LivroDTO, Livro>{

	@Override
	public Livro convert(LivroDTO livroForm) {
		Livro livro = new Livro();

		if (livroForm.getId() != null) 
			livro.setId(livroForm.getId());
		
		livro.setTitulo(livroForm.getTitulo());
		livro.setIsbn(livroForm.getIsbn());
		livro.setAutor(livroForm.getAutor());

		return livro;
	}

}
