package metier.dao.beans;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "cin")
public class Clinique extends User{
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="adresse",nullable=false)
	private String adresse;
	
	private String description;
	
	@Column(name="emergency_tel",nullable=false)
	private String emergency_tel;
	
	@Column(name="speciality",nullable=false)
	private String speciality;
	
	private Boolean dispo;
	private String ville;
	private String id;
	private Boolean first_using;
	private Long nbrVisiters;
	
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
	
	public Long getNbrVisiters() {
		return nbrVisiters;
	}
	
	public void setNbrVisiters(Long nbrVisiters) {
		this.nbrVisiters = nbrVisiters;
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	public Boolean getDispo() {
		return dispo;
	}
	
	public void setDispo(Boolean dispo) {
		this.dispo = dispo;
	}
	
	public List<Docteur> getDocteurs() {
		return docteurs;
	}
	
	public void setDocteurs(List<Docteur> docteurs) {
		this.docteurs = docteurs;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public Boolean getFirst_using() {
		return first_using;
	}
	
	public void setFirst_using(Boolean first_using) {
		this.first_using = first_using;
	}

	@Override
	public String toString() {
		return "Clinique [name=" + name + ", adresse=" + adresse + ", description=" + description + ", emergency_tel="
				+ emergency_tel + ", speciality=" + speciality + ", dispo=" + dispo + ", ville=" + ville
				+ ", first_using=" + first_using + ", user=" + user + ", docteurs=" + docteurs + ", works=" + works
				+ ", rating=" + rating + ", comments=" + comments + "]";
	}
	
	
}
