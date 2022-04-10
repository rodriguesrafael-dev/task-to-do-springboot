package br.com.tasktodo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.tasktodo.controller.TaskController;
import br.com.tasktodo.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class TaskServices {

	@Autowired
	private TaskController taskController;
	
	public TaskEntity save(TaskEntity taskEntity) {
		return taskController.save(taskEntity);
	}
	
	public void update(Long id, TaskEntity updatedTask) {
		taskController.update(id, updatedTask);
	}
	
	public void delete(Long id) {
		taskController.delete(id);
	}
	
	public List<TaskEntity> findAll() {
		return taskController.findAll();
	}

	public List<TaskEntity> listTaskFilter(long id, String title, String userEntity, String taskStattusEntity) {
		return taskController.listTaskFilter(id, title, userEntity, taskStattusEntity);
	}
	
}
