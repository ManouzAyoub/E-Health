package metier.dao.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CliniqueDocteur implements Serializable{
	
	@Id
	private long idCliniqueDocteur;
	
	@ManyToOne
	@JoinColumn(name = "idClinique" , referencedColumnName = "cin")
	private Clinique clinique;
	
	@ManyToOne
	@JoinColumn(name = "idDocteur" , referencedColumnName = "cin")
	private Docteur docteur;

	public Clinique getClinique() {
		return clinique;
	}

	public void setClinique(Clinique clinique) {
		this.clinique = clinique;
	}

	public Docteur getDocteur() {
		return docteur;
	}

	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}
	
	public long getIdCliniqueDocteur() {
		return idCliniqueDocteur;
	}
	
	public void setIdCliniqueDocteur(long idCliniqueDocteur) {
		this.idCliniqueDocteur = idCliniqueDocteur;
	}
	
}
