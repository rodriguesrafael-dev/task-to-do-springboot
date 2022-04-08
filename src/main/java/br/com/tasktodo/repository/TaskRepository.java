package br.com.tasktodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tasktodo.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long>{

}
