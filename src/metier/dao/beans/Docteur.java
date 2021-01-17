package metier.dao.beans;

import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name = "cin")
public class Docteur extends User{
	
	    private String speciality;
	    private String languages;
	    private String practice;
	    private String tel;
	    @Transient
	    private String Base64image;
	    
	    
	    public String getBase64image() {
			return Base64image;
		}

		public void setBase64image(String base64image) {
			Base64image = base64image;
		}

		@Lob
	    @Column(name = "id_scan", columnDefinition="BLOB")
	    private byte[] id_scan;
	    
	    public byte[] getId_scan() {
			return id_scan;
		}

		public void setId_scan(byte[] id_scan) {
			this.id_scan = id_scan;
		}

		public byte[] getProfile_image() {
			return profile_image;
		}

		public void setProfile_image(byte[] profile_image) {
			this.profile_image = profile_image;
		}

		public byte[] getMed_certificate() {
			return med_certificate;
		}

		public void setMed_certificate(byte[] med_certificate) {
			this.med_certificate = med_certificate;
		}

		public byte[] getLocal_contract() {
			return local_contract;
		}

		public void setLocal_contract(byte[] local_contract) {
			this.local_contract = local_contract;
		}
		
		public void base64(byte[] bytes,Docteur doc) throws UnsupportedEncodingException {
		    byte[] encodeBase64 = Base64.getDecoder().decode(bytes);
	        String base64Encoded = new String(encodeBase64, "UTF-8");
	        doc.setBase64image(base64Encoded);
	    }

		@Lob
	    @Column(name = "profile_image", columnDefinition="BLOB")
	    private byte[] profile_image;
	    
	    @Lob
	    @Column(name = "med_certificate", columnDefinition="BLOB")
	    private byte[] med_certificate;
	    
	    @Lob
	    @Column(name = "local_contract", columnDefinition="BLOB")
	    private byte[] local_contract;
	    

	
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

	
	

}
