package br.com.tasktodo.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;

import br.com.tasktodo.entity.TaskStattusEntity;
import br.com.tasktodo.services.TaskStattusServices;
import lombok.Data;

@Data
@Component
@ManagedBean(name = "taskStattusManagedBean")
@ViewScoped
public class TaskStattusManagedBean {

	public TaskStattusServices taskStattusServices = new TaskStattusServices();
	
	private TaskStattusEntity taskStattusEntity;
	
	private List<TaskStattusEntity> taskStattusList;
	
	public List<TaskStattusEntity> taskStattusList() {
		this.taskStattusList = taskStattusServices.findAll();
		return taskStattusList;
	}
	
}
