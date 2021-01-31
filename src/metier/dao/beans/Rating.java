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
public class Rating implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long        idRating;
    private int numberEtoile;

    @OneToOne
    @JoinColumn( name = "idUser", referencedColumnName = "cin" )
    private User        user;

    @ManyToOne
    @JoinColumn( name = "idClinique", referencedColumnName = "cin" )
    private Clinique    clinique;

    @ManyToOne
    @JoinColumn( name = "idHopital", referencedColumnName = "idHopital" )
    private Hopital     hopital;

    @ManyToOne
    @JoinColumn( name = "idLaboratoire", referencedColumnName = "idProfil" )
    private Laboratoire laboratoire;

    @ManyToOne
    @JoinColumn( name = "idPharmacie", referencedColumnName = "idProfil" )
    private Pharmacie   pharmacie;

    @ManyToOne
    @JoinColumn( name = "idCabinet", referencedColumnName = "idProfil" )
    private Cabinet     cabinet;
    
    @ManyToOne
    @JoinColumn( name = "idDocteur", referencedColumnName = "cin" )
    private Docteur     docteur;

    public Rating() {
        super();
    }

    public void setIdRating( long idRating ) {
        this.idRating = idRating;
    }

    public long getIdRating() {
        return idRating;
    }
    
    public int getNumberEtoile() {
		return numberEtoile;
	}
    
    public void setNumberEtoile(int numberEtoile) {
		this.numberEtoile = numberEtoile;
	}
    
    public Docteur getDocteur() {
		return docteur;
	}
    
    public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}
    
    

}
