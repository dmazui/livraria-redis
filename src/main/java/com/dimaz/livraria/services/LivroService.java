package com.dimaz.livraria.services;

import java.util.List;

import com.dimaz.livraria.domain.dtos.LivroForm;
import com.dimaz.livraria.domain.models.Livro;

public interface LivroService {


    List<Livro> listAll();

    Livro getById(String id);

    Livro saveOrUpdate(Livro livro);

    void delete(String id);

    Livro saveOrUpdateLivroForm(LivroForm livroForm);

}
