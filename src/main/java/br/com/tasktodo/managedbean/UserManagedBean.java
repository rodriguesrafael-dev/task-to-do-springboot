package br.com.tasktodo.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;

import br.com.tasktodo.entity.UserEntity;
import br.com.tasktodo.services.UserServices;
import lombok.Data;

@Data
@Component
@ManagedBean(name = "userManagedBean")
@ViewScoped
public class UserManagedBean {

	public UserServices userServices = new UserServices();
	
	private UserEntity userEntity;
	
	private List<UserEntity> userList;
	
	private List<UserEntity> userListFindName;
	
	public String getBackHome() {
		return "index?faces-redirect=true";
	}
	
	public String getUserCreate() {		
		this.userEntity = new UserEntity();
		return "userCreate?faces-redirect=true";
	}
	
	public String getUserEdit(UserEntity userEntity) {
		this.userEntity = userEntity;
		return "userEdit?faces-redirect=true";
	}

	public String save() {
		this.userServices.save(userEntity);
		userEntity = new UserEntity();
		return "";
	}
	
	public String update(Long id, UserEntity userEntity) {
		this.userServices.update(id, this.userEntity);
		this.userEntity = new UserEntity();
		return "userCreate?faces-redirect=true";
	}
	
	public String delete(Long id) {
		this.userServices.delete(id);
		userEntity = new UserEntity();
		return "index?faces-redirect=true";
	}
	
	public List<UserEntity> userList() {
		this.userList = userServices.findAll();
		return userList;
	}
	
}
