package metier.dao.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hopital implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idHopital;
	
	@OneToMany
	Set<Rating> rating;
	
	@OneToMany
	Set<Commentaire> comments;
	
	public Hopital() {
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
	
	public void setIdHopital(long idHopital) {
		this.idHopital = idHopital;
	}
	
	public long getIdHopital() {
		return idHopital;
	}
	
	
}
