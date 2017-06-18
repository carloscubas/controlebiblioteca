package org.biblioteca.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.biblioteca.dao.AutorDAO;
import org.biblioteca.dao.LivroDAO;
import org.biblioteca.models.Autor;
import org.biblioteca.models.Livro;
import org.biblioteca.models.LivroForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.converter.AutorPropertyEditor;
import br.biblioteca.converter.LivroPropertyEditor;

// http://www.mballem.com/post/spring-3-mvc-com-validator-e-converter/

@Controller
@RequestMapping("/livros")
@Transactional
public class LivroController {

	@Autowired
	private LivroDAO livroDAO;

	@Autowired
	private AutorDAO autorDAO;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
		
		//binder.registerCustomEditor( Livro.class, "livro", new LivroPropertyEditor()  );
		
        binder.registerCustomEditor( Autor.class, new AutorPropertyEditor(autorDAO)  );
       
        //binder.registerCustomEditor(Livro.class, "autor", new LivroPropertyEditor());
        
    }

	@RequestMapping("/form")
	public ModelAndView formulario(@ModelAttribute Livro livro) {

		ModelAndView modelAndView = new ModelAndView("livro/form");
		modelAndView.addObject("listaautores", autorDAO.getAll());

		return modelAndView;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable("id") Integer id){
		
		Livro livro = livroDAO.get(id);
		
		LivroForm livroForm = new LivroForm();
		livroForm.setId(livro.getId());
		livroForm.setAutor(String.valueOf(livro.getAutor().getId()));
		livroForm.setDescricao(livro.getDescricao());
		livroForm.setTitulo(livro.getTitulo());
		livroForm.setDataLancamento(livro.getDataLancamento());
		
		
		ModelAndView modelAndView = new ModelAndView("livro/form");
		modelAndView.addObject("listaautores", autorDAO.getAll());
		modelAndView.addObject("livro", livroForm);
		
		return modelAndView;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("livro") 
		@Valid Livro livro,
		BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return formulario(livro);
		}
		
		if(livro.getId() != null){
			livroDAO.update(livro);
		}else{
			livroDAO.save(livro);
		}

		return new ModelAndView( "redirect:livros" );
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listaLivros() {

		ModelAndView modelAndView = new ModelAndView("livro/lista");
		modelAndView.addObject("livros", livroDAO.getAll());

		return modelAndView;
	}

}