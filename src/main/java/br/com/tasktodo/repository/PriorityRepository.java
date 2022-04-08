package br.com.tasktodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tasktodo.entity.PriorityEntity;

public interface PriorityRepository extends JpaRepository<PriorityEntity, Long>{

}
