package org.biblioteca.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.biblioteca.dao.AutorDAO;
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
@RequestMapping("/autores")
@Transactional
public class AutorController {
	
	@Autowired
	private AutorDAO autorDAO;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView formulario(@ModelAttribute Autor autor) {
		
		ModelAndView modelAndView = new ModelAndView("autor/form");
		return modelAndView;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable("id") Integer id){
		Autor autor = autorDAO.get(id);
		ModelAndView modelAndView = new ModelAndView("autor/form");
		modelAndView.addObject("autor", autor);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("autor") 
		@Valid Autor autor,
		BindingResult bindingResult,
		RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			return formulario(autor);
		}
		
		if(autor.getId() != null){
			autorDAO.update(autor);
		}else{
			autorDAO.save(autor);
		}
		
		
		return new ModelAndView( "redirect:autores" );
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listaAutores() {
		
		ModelAndView modelAndView = new ModelAndView("autor/lista");
		modelAndView.addObject("autores", autorDAO.getAll());
		
		return modelAndView;
	}

}