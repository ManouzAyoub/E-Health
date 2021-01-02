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

@Entity
public class Docteur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDocteur;
	
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

	public long getIdDocteur() {
		return idDocteur;
	}

	public void setIdDocteur(long idDocteur) {
		this.idDocteur = idDocteur;
	}

	
}
