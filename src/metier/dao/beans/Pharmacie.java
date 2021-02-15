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
//@PrimaryKeyJoinColumn(name = "idProfil")
public class Pharmacie implements Serializable{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long idPharmacie;
	private String name;
	private String ville;
	private String email;
	private Boolean ouverte_jour;
	private Boolean ouverte_nuit;
	private Boolean ouverte_journer;
	private String tel;
	private String adresse;
	private String id;
	private Boolean dispo;
	
	
	@OneToMany
	Set<Rating> rating;
	
	@OneToMany
	Set<Commentaire> comments;
	
	public Pharmacie() {
		super();
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Boolean getOuverte_jour() {
		return ouverte_jour;
	}

	public void setOuverte_jour(Boolean ouverte_jour) {
		this.ouverte_jour = ouverte_jour;
	}

	public Boolean getOuverte_nuit() {
		return ouverte_nuit;
	}

	public void setOuverte_nuit(Boolean ouverte_nuit) {
		this.ouverte_nuit = ouverte_nuit;
	}

	public Boolean getOuverte_journer() {
		return ouverte_journer;
	}

	public void setOuverte_journer(Boolean ouverte_journer) {
		this.ouverte_journer = ouverte_journer;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Long getIdPharmacie() {
		return idPharmacie;
	}
	
	public void setIdPharmacie(Long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Boolean getDispo() {
		return dispo;
	}
	
	public void setDispo(Boolean dispo) {
		this.dispo = dispo;
	}
	
}
