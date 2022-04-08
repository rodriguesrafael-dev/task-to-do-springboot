package br.com.tasktodo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ManagedBean
@NoArgsConstructor
@AllArgsConstructor
@Data 
@Entity
@Table(name = "tasks")
public class TaskEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private long id;
	
	@Column(name = "title", length = 100)
	private String title;
	
	@Column(name = "description", length = 160)
	private String description;
	
	@Column(name = "deadline")
	private LocalDate deadline;
	
	@CreationTimestamp
	@Column(name = "createdat")
	private LocalDate createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedat")
	private LocalDate updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;
	
	@ManyToOne
	@JoinColumn(name = "priority_id")
	private PriorityEntity priorityEntity;
	
	@ManyToOne
	@JoinColumn(name = "taskStattus_id")
	private TaskStattusEntity taskStattusEntity;

}
