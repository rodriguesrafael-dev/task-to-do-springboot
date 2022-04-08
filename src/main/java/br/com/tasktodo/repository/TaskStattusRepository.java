package br.com.tasktodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tasktodo.entity.TaskStattusEntity;

public interface TaskStattusRepository extends JpaRepository<TaskStattusEntity, Long>{

}
