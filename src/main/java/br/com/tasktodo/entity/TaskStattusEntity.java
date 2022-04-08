package br.com.tasktodo.entity;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ManagedBean
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "taskstattus")
public class TaskStattusEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id")
    private long id;
	
    @Column(name = "taskstattusdescription", length = 15)
    private String taskStattusDescription; 
    
    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }
    
}
