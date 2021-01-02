package metier.dao.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hopital implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idHopital;
	
	public Hopital() {
		super();
	}
	
	public void setIdHopital(long idHopital) {
		this.idHopital = idHopital;
	}
	
	public long getIdHopital() {
		return idHopital;
	}
	
	
}
