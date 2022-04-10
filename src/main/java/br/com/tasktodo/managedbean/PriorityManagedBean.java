package br.com.tasktodo.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;

import br.com.tasktodo.entity.PriorityEntity;
import br.com.tasktodo.services.PriorityServices;
import lombok.Data;

@Data
@Component
@ManagedBean(name = "priorityManagedBean")
@ViewScoped
public class PriorityManagedBean {

	private PriorityServices priorityServices = new PriorityServices();
	
	private PriorityEntity priorityEntity;
	
	private List<PriorityEntity> priorityList;
	
	public List<PriorityEntity> priorityList() {
		this.priorityList = priorityServices.findAll();
		return priorityList;
	}
	
}
