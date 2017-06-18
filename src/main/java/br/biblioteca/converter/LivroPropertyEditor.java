package br.biblioteca.converter;

import java.beans.PropertyEditorSupport;

import org.biblioteca.models.Livro;

public class LivroPropertyEditor extends PropertyEditorSupport {
	
	@Override
	public void setValue(Object value) {
		
		
		System.out.println(((Livro) value));
		
		
		String autor = String.valueOf(((Livro) value).getAutor().getId()) ;
		super.setValue(autor);
	}

}
