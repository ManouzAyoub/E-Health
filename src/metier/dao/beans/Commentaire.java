package metier.dao.beans;

import java.io.Serializable;

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
	
	@OneToOne
	@JoinColumn(name = "idUser" , referencedColumnName = "cin")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "idClinique" , referencedColumnName = "cin")
	private Clinique clinique;
	
	@OneToOne
	@JoinColumn(name = "idHopital" , referencedColumnName = "idHopital")
	private Hopital hopital;
	
	@OneToOne
	@JoinColumn(name = "idLaboratoire" , referencedColumnName = "code")
	private Laboratoire laboratoire;
	
	@OneToOne
	@JoinColumn(name = "idPharmacie" , referencedColumnName = "code")
	private Pharmacie pharmacie;
	
	@OneToOne
	@JoinColumn(name = "idCabinet" , referencedColumnName = "code")
	private Cabinet cabinet;
	
	
	

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
	
	
}
