package br.com.tasktodo.shared;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.omnifaces.converter.SelectItemsConverter;

import br.com.tasktodo.entity.TaskStattusEntity;

@FacesConverter("TaskStattusEntity")
public class TaskStattusEntitySelectItemsConverter extends SelectItemsConverter {

	@Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Long id = (value instanceof TaskStattusEntity) ? ((TaskStattusEntity) value).getId() : null;
        return (id != null) ? String.valueOf(id) : null;
    }
	
}
