package metier.dao.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "cin")
public class Clinique extends User{
	
	@ManyToOne
	@JoinColumn(name = "idUser" , referencedColumnName = "cin")
	private User user;

	@ManyToMany
	Set<Docteur> works;
	
	public Clinique() {
		super();
	}
	
	public Set<Docteur> getWorks() {
		return works;
	}
	
	public void setWorks(Set<Docteur> works) {
		this.works = works;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
