package metier.dao.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "cin")
public class Clinique extends User{
	
	private String name;
	private String adresse;
	private String tel;
	private String emergency_tel;
	private String speciality;
	
	@ManyToOne
	@JoinColumn(name = "idUser" , referencedColumnName = "cin")
	private User user;
	
	@ManyToMany
    @JoinTable( name = "T_Clinique_Docteur",
                joinColumns = @JoinColumn( name = "cin" ),
                inverseJoinColumns = @JoinColumn( name = "email" ) )
    private List<Docteur> docteurs = new ArrayList<>();

	@ManyToMany
	Set<Docteur> works;
	
	@OneToMany
	Set<Rating> rating;
	
	@OneToMany
	Set<Commentaire> comments;
	
	public Set<Rating> getRating() {
		return rating;
	}

	public void setRating(Set<Rating> rating) {
		this.rating = rating;
	}

	public Set<Commentaire> getComments() {
		return comments;
	}

	public void setComments(Set<Commentaire> comments) {
		this.comments = comments;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmergency_tel() {
		return emergency_tel;
	}

	public void setEmergency_tel(String emergency_tel) {
		this.emergency_tel = emergency_tel;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	
	
	
	
}
