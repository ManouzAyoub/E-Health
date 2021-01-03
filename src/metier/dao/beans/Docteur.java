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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "cin")
public class Docteur extends User{
	
	private String name;
	private String specialiter;
	
	@ManyToOne
	@JoinColumn(name = "idUser" , referencedColumnName = "cin")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "idHopital" , referencedColumnName = "idHopital")
	private Hopital hopital;
	
	@OneToOne
	@JoinColumn(name = "idProfil", nullable = true , referencedColumnName = "idProfil")
	private Profil profil;
	
	@ManyToMany
	Set<Clinique> travaille;
	
	public Docteur() {
		super();
	}
	
	public User getUser() {
		return user;
	}
	
	public Set<Clinique> getTravaille() {
		return travaille;
	}
	
	public void setTravaille(Set<Clinique> travaille) {
		this.travaille = travaille;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSpecialiter() {
		return specialiter;
	}
	
	public void setSpecialiter(String specialiter) {
		this.specialiter = specialiter;
	}
	
}
