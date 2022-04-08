package br.com.tasktodo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.tasktodo.entity.TaskEntity;
import br.com.tasktodo.repository.TaskRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	private final TaskRepository taskRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TaskEntity save(@RequestBody TaskEntity taskEntity) {
		return taskRepository.save(taskEntity);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @RequestBody TaskEntity updatedTask) {
		taskRepository
			.findById(id)
			.map(TaskEntity -> {
				updatedTask.setTitle(updatedTask.getTitle());
				updatedTask.setDescription(updatedTask.getDescription());
				updatedTask.setDeadline(updatedTask.getDeadline());
				updatedTask.getUserEntity().setId(updatedTask.getUserEntity().getId());
				updatedTask.getPriorityEntity().setId(updatedTask.getPriorityEntity().getId());
				updatedTask.getTaskStattusEntity().setId(updatedTask.getTaskStattusEntity().getId());
				return taskRepository.save(updatedTask);
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa nao encontrada!"));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		taskRepository.findById(id)
        .map(taskEntity -> {
        	taskRepository.delete(taskEntity);
            return Void.TYPE;
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa nao encontrada!"));
	}
	
	@GetMapping
    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }
	
	@SuppressWarnings("null")
	@GetMapping("{id}/{title}/{userEntity}/{taskStattusEntity}")
	public List<TaskEntity> listTaskFilter(@PathVariable long id, @PathVariable String title, @PathVariable String userEntity, @PathVariable String taskStattusEntity) {
		List<TaskEntity> list = new ArrayList<>();
		EntityManager entityManager = null;
		try {
			list = entityManager
					.createQuery(
							"SELECT t FROM TaskEntity t JOIN t.userEntity u JOIN t.taskStattusEntity ts "
							+ "WHERE t.id=:id "
							+ "OR t.title=:title "
							+ "OR u.userName=:userEntity "
							+ "OR ts.taskStattusDescription=:taskStattusEntity "
							+ "ORDER BY t.id", TaskEntity.class)
					.setParameter("id", id)
					.setParameter("title", title)
					.setParameter("userEntity", userEntity)
					.setParameter("taskStattusEntity", taskStattusEntity)
					.getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	
}
