package br.com.tasktodo.shared;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("localDateFacesConverter")
public class LocalDateConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String str) {

		if (null == str || str.isEmpty()) {
			return null;
		}

		LocalDate localDate;

		try {
			localDate = LocalDate.parse(str, DateTimeFormatter.ofPattern("dd/MM/yyyy"));	
		} catch (DateTimeParseException e) {	
			throw new ConverterException(""+e);
		}
		return localDate;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {

		if (null == obj) {
			return "";
		}
		return ((LocalDate) obj).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
}
