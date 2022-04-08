package br.com.tasktodo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.tasktodo.controller.UserController;
import br.com.tasktodo.entity.UserEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
public class UserServices {

	@Autowired
	private UserController userController;
	
	public UserEntity save(UserEntity userEntity) {
		return userController.save(userEntity);
	}
	
	public void update(Long id, UserEntity updatedUser) {
		userController.update(id, updatedUser);
	}
	
	public void delete(Long id) {
		userController.delete(id);
	}
	
	public List<UserEntity> findAll() {
		return userController.findAll();
	}
	
}
