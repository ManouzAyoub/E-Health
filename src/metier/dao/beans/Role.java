package metier.dao.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	
	public Role() {
		super();
	}
	
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
	public int getIdRole() {
		return idRole;
	}
	

}
