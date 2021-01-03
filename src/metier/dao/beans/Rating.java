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
public class Rating implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRating;
	
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
	
	public Rating() {
		super();
	}
	
	public void setIdRating(long idRating) {
		this.idRating = idRating;
	}
	
	public long getIdRating() {
		return idRating;
	}
	
}
