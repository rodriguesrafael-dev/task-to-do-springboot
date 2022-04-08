package br.com.tasktodo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.tasktodo.controller.TaskStattusController;
import br.com.tasktodo.entity.TaskStattusEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
public class TaskStattusServices {

	@Autowired
	private TaskStattusController taskStattusController;
	
	public List<TaskStattusEntity> findAll() {
		return taskStattusController.findAll();
	}
	
}
