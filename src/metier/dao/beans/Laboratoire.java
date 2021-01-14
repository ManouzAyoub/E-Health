package metier.dao.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idProfil")
public class Laboratoire extends Profil{

	private String name;
	
	@OneToMany
	Set<Rating> rating;
	
	@OneToMany
	Set<Commentaire> comments;
	
	public Laboratoire() {
		super();
	}
	
	public Set<Commentaire> getComments() {
		return comments;
	}
	
	public void setComments(Set<Commentaire> comments) {
		this.comments = comments;
	}
	
	public Set<Rating> getRating() {
		return rating;
	}
	
	public void setRating(Set<Rating> rating) {
		this.rating = rating;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
