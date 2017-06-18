package org.biblioteca.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.biblioteca.dao.AlunoDAO;
import org.biblioteca.dao.AutorDAO;
import org.biblioteca.models.Aluno;
import org.biblioteca.models.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/alunos")
@Transactional
public class AlunoController {
	
	@Autowired
	private AlunoDAO alunoDAO;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView formulario(@ModelAttribute Aluno aluno) {
		
		ModelAndView modelAndView = new ModelAndView("aluno/form");
		return modelAndView;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable("id") Integer id){
		Aluno aluno = alunoDAO.get(id);
		ModelAndView modelAndView = new ModelAndView("aluno/form");
		modelAndView.addObject("aluno", aluno);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("aluno") 
		@Valid Aluno aluno,
		BindingResult bindingResult,
		RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			return formulario(aluno);
		}
		
		if(aluno.getId() != null){
			alunoDAO.update(aluno);
		}else{
			alunoDAO.save(aluno);
		}
		
		return new ModelAndView( "redirect:alunos" );
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listaAlunos() {
		
		ModelAndView modelAndView = new ModelAndView("aluno/lista");
		modelAndView.addObject("alunos", alunoDAO.getAll());
		
		return modelAndView;
	}

}