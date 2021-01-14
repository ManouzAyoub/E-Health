package metier.dao.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
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
public class Cabinet extends Profil{

	

	private String name;
	private String adresse;
	
	@Override
	public String toString() {
		return "Cabinet [name=" + name + ", idCabinet=" + getIdProfil() + ", adresse=" + adresse + ", rating=" + rating + ", comments=" + comments + "]";
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

	public Cabinet() {
		super();
	}
	
	
	
	
	
}
