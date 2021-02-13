package metier.dao.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Commentaire implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCommentaire;
	private String commentaire;
	private Date date_commentaire;
	
	@OneToOne
	@JoinColumn(name = "idUser" , referencedColumnName = "cin")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "idClinique" , referencedColumnName = "cin")
	private Clinique clinique;
	
	@ManyToOne
	@JoinColumn(name = "idHopital" , referencedColumnName = "idHopital")
	private Hopital hopital;
	
	@ManyToOne
	@JoinColumn(name = "idLaboratoire" , referencedColumnName = "idProfil")
	private Laboratoire laboratoire;
	
	@ManyToOne
	@JoinColumn(name = "idPharmacie" , referencedColumnName = "idPharmacie")
	private Pharmacie pharmacie;
	
	@ManyToOne
	@JoinColumn(name = "idCabinet" , referencedColumnName = "idProfil")
	private Cabinet cabinet;
	
	@ManyToOne
	@JoinColumn(name = "idDocteur" , referencedColumnName = "cin")
	private Docteur docteur;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Clinique getClinique() {
		return clinique;
	}

	public void setClinique(Clinique clinique) {
		this.clinique = clinique;
	}

	public Hopital getHopital() {
		return hopital;
	}

	public void setHopital(Hopital hopital) {
		this.hopital = hopital;
	}

	public Laboratoire getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public Cabinet getCabinet() {
		return cabinet;
	}

	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}

	public Commentaire() {
		super();
	}
	
	public long getIdCommentaire() {
		return idCommentaire;
	}

	public void setIdCommentaire(long idCommentaire) {
		this.idCommentaire = idCommentaire;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public Date getDate_commentaire() {
		return date_commentaire;
	}
	
	public void setDate_commentaire(Date date_commentaire) {
		this.date_commentaire = date_commentaire;
	}
		
	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}
	
	public Docteur getDocteur() {
		return docteur;
	}
}
