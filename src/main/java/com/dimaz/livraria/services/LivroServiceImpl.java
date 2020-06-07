package com.dimaz.livraria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dimaz.livraria.domain.dtos.LivroForm;
import com.dimaz.livraria.domain.mappers.LivroFormToLivro;
import com.dimaz.livraria.domain.models.Livro;
import com.dimaz.livraria.repositories.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService{

    private LivroRepository repository;
    private LivroFormToLivro toLivro;

    @Autowired
    public LivroServiceImpl(LivroRepository repository, LivroFormToLivro toLivro) {
        this.repository = repository;
        this.toLivro = toLivro;
    }

    
	@Override
	public List<Livro> listAll() {
		List<Livro> livros = new ArrayList<>();
        repository.findAll().forEach(livros::add);
        return livros;
    }

	@Override
	public Livro getById(String id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Livro saveOrUpdate(Livro livro) {
		repository.save(livro);
		return livro;
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);		
	}

	@Override
	public Livro saveOrUpdateLivroForm(LivroForm livroForm) {
		Livro livroSalvo = saveOrUpdate(toLivro.convert(livroForm));
		System.out.println("Id livro salvo: " + livroSalvo.getId());
		return livroSalvo;
	}
}
