package com.dimaz.livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dimaz.livraria.domain.dtos.LivroForm;
import com.dimaz.livraria.domain.mappers.LivroToLivroForm;
import com.dimaz.livraria.domain.models.Livro;
import com.dimaz.livraria.services.LivroService;

@Controller
@RequestMapping("/")
public class LivroController {
	
	@Autowired
	private LivroService service;
	
	@Autowired
	private LivroToLivroForm livroToLivroForm;
    	
	@RequestMapping("/")
	public String redirToList() {
		return "redirect:/livro/list";
	}
	
	@RequestMapping({"/livro/list", "/livro"})
	public String listLivros(Model model) {
		model.addAttribute("livros", service.listAll());
		return "livro/list";
	}

    @RequestMapping("/livro/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("livro", service.getById(id));
        return "livro/show";
    }

    @RequestMapping("livro/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Livro livro = service.getById(id);
        LivroForm livroForm = livroToLivroForm.convert(livro);
        model.addAttribute("livroForm", livroForm);
        return "livro/livroform";
    }

    @RequestMapping("/livro/new")
    public String newLivro(Model model){
        model.addAttribute("livroForm", new LivroForm());
        return "livro/livroform";
    }

    @RequestMapping(value = "/livro", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Validated LivroForm livroForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "livro/livroform";
        }

        Livro livroSalvo = service.saveOrUpdateLivroForm(livroForm);

        return "redirect:/livro/show/" + livroSalvo.getId();
    }

    @RequestMapping("/livro/delete/{id}")
    public String delete(@PathVariable String id){
        service.delete(id);
        return "redirect:/livro/list";
    }

}
