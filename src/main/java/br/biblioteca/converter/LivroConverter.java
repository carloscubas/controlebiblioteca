package br.biblioteca.converter;

import org.biblioteca.models.Livro;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//@Component
public class LivroConverter implements Converter<Object, Livro> {

	@Override
	public Livro convert(Object source) {
		// TODO Auto-generated method stub
		return null;
	}

}
