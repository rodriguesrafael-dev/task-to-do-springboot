package br.com.tasktodo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tasktodo.entity.TaskStattusEntity;
import br.com.tasktodo.repository.TaskStattusRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/taskStattus")
public class TaskStattusController {

	private final TaskStattusRepository taskStattusRepository;
	
	@GetMapping
    public List<TaskStattusEntity> findAll() {
        return taskStattusRepository.findAll();
    }
	
}
