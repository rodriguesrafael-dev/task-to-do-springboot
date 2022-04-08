package br.com.tasktodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tasktodo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
