package br.biblioteca.converter;

import java.beans.PropertyEditorSupport;

import org.biblioteca.dao.AutorDAO;
import org.biblioteca.models.Autor;

import com.google.common.base.Strings;

public class AutorPropertyEditor extends PropertyEditorSupport{
	
	private AutorDAO dao;

	public AutorPropertyEditor(AutorDAO dao) {
		this.dao = dao;
	}
	
	
	@Override
    public void setAsText(String text) {
		
		Autor autor = null;
		
		if(!Strings.isNullOrEmpty(text)){
	        //transforma a string com o id em um long
	        Integer id = new Integer(text);
	        //recupera no db o profile do id referido
	        autor = dao.get(id);
	        //add o objeto profile, o qual faz parte do objeto user no controller
		}

        super.setValue(autor);
    }
	
	

}
