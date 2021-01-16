package metier.dao.beans;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "cin")
public class Docteur extends User{
	
	    private String speciality;
	    private String languages;
	    private String practice;
	    private String tel;
 //	    private InputStream id_scan; 
	    private String profile_image;
//	    private InputStream med_certificate;
	    private String local_contract;
	
	@ManyToOne
	@JoinColumn(name = "idUser" , referencedColumnName = "cin")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "idHopital" , referencedColumnName = "idHopital")
	private Hopital hopital;
	
	@OneToOne
	@JoinColumn(name = "idProfil", nullable = true , referencedColumnName = "idProfil")
	private Profil profil;
	
	@ManyToMany
	Set<Clinique> travaille;
	

	public Docteur() {
		super();
	}
	
	public User getUser() {
		return user;
	}
	
	public Set<Clinique> getTravaille() {
		return travaille;
	}
	
	public void setTravaille(Set<Clinique> travaille) {
		this.travaille = travaille;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getPractice() {
		return practice;
	}

	public void setPractice(String practice) {
		this.practice = practice;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

//	public InputStream getId_scan() {
//		return id_scan;
//	}
//
//	public void setId_scan(InputStream id_scan) {
//		this.id_scan = id_scan;
//	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

//	public InputStream getMed_certificate() {
//		return med_certificate;
//	}
//
//	public void setMed_certificate(InputStream med_certificate) {
//		this.med_certificate = med_certificate;
//	}

	public String getLocal_contract() {
		return local_contract;
	}

	public void setLocal_contract(String local_contract) {
		this.local_contract = local_contract;
	}

	
}
