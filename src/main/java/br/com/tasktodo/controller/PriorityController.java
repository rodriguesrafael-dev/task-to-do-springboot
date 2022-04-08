package br.com.tasktodo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tasktodo.entity.PriorityEntity;
import br.com.tasktodo.repository.PriorityRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/priorities")
public class PriorityController {

	private final PriorityRepository priorityRepository;
	
	@GetMapping
	public List<PriorityEntity> findAll() {
		return priorityRepository.findAll();
	}
	
}
