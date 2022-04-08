package br.com.tasktodo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.tasktodo.controller.PriorityController;
import br.com.tasktodo.entity.PriorityEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
public class PriorityServices {

	@Autowired
	private PriorityController priorityController;
	
	public List<PriorityEntity> findAll() {
		return priorityController.findAll();
	}
	
}
