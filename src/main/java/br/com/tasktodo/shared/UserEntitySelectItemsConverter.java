package br.com.tasktodo.shared;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.omnifaces.converter.SelectItemsConverter;

import br.com.tasktodo.entity.UserEntity;

@FacesConverter("UserEntity")
public class UserEntitySelectItemsConverter extends SelectItemsConverter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Long id = (value instanceof UserEntity) ? ((UserEntity) value).getId() : null;
        return (id != null) ? String.valueOf(id) : null;
    }
    
}
