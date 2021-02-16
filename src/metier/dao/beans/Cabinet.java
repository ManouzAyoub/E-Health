package metier.dao.beans;


import java.util.Set;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idProfil")
public class Cabinet extends Profil{

	private String name;
	private String adresse;
	
	
	@OneToMany
	Set<Rating> rating;
	
	@OneToMany
	Set<Commentaire> comments;
	
	public Cabinet() {
		super();
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

	
	
	
	
	
	
}
