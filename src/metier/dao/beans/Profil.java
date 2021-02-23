package metier.dao.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Profil implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idProfil")
	private long idProfil;
	
	@OneToOne
	@JoinColumn(name = "idDocteur" ,nullable = true, referencedColumnName = "cin")
	private Docteur docteur;
	
	public Profil() {
		super();
	}
	
	public Docteur getDocteur() {
		return docteur;
	}
	
	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}
	
	public void setIdProfil(long idProfil) {
		this.idProfil = idProfil;
	}
	
	public long getIdProfil() {
		return idProfil;
	}
}
