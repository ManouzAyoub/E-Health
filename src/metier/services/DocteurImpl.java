package metier.services;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;

import metier.dao.beans.Docteur;
import metier.dao.beans.Langue;
import metier.dao.util.HibernateUtil;

public class DocteurImpl {
	
	private static DocteurImpl instance = null;
	private RatingImpl ratingImpl = RatingImpl.getInstance();
	private Session session = HibernateUtil.openSession();
	private String fullName;
	private String specialiter;
	private String specialiterClass;
	private String adresse;
	private String aDomicile;
	private String teleMedcine;
	private String gender;
	private String rating;
	private String numberOfRating;
	private String average;
	private String HDepart;
	private String HFin;
	private String JDepart;
	private String JFin;
	private String image;
	private String all_languages;
	private List<Langue> list_langue;
	private List<String> string = new ArrayList<>();
	private Map<Long,List<String>> classes_list_map = new HashMap<Long, List<String>>();
	private Map<String,String> specialities = new HashMap<String,String>();

	
	private DocteurImpl() {
		
	}
	
	public static DocteurImpl getInstance() {
	    if (instance == null)
	                   instance = new DocteurImpl();
	    return instance;
	}
	
	// return les docteur selon l'attribue de confirmation par l'administrateur 
	public List<Docteur> getDoctorsAccordingToTheirAvailability(boolean bool){
		String hql = "select o from Docteur o where dispo = :bool";
		Query q = session.createQuery(hql);
		q.setParameter("bool", bool);
		List<Docteur> doctors = q.getResultList();
		return doctors;
	}
	
	// Specifier les donn�es � afficher dans la page searchDoctor par doctor
	public Map<Long, List<String>> displayDoctorsInPage(List<Docteur> list) {
		function();
		string.clear();
		for(Docteur docteur : list) {	
			fullName       = docteur.getFirstname() + " " + docteur.getLastname();
			HDepart        = String.valueOf(docteur.getHeureDepart());
			HFin           = String.valueOf(docteur.getHeureFin());
			JDepart        = docteur.getJourDepart();
			JFin           = docteur.getJourFin();
			adresse        = docteur.getAdresse();
			gender         = docteur.getGender();
			image          = Base64.getEncoder().encodeToString(docteur.getProfile_image());
			numberOfRating = String.valueOf(ratingImpl.getNumberOfRatingByDoctor(docteur));
			average        = String.valueOf(ratingImpl.getAverageOfRatingByDoctor(docteur));
			rating         = " stars_" + ratingImpl.getAverageOfRatingByDoctor(docteur);
			specialiter    = docteur.getSpeciality();
			
			if ( !specialities.get(docteur.getSpeciality()).isEmpty() ) {
				specialiterClass = specialities.getOrDefault(docteur.getSpeciality(), "");
			}
			
			list_langue = docteur.getLangues();
			
			for(Langue ls_lg : list_langue) {
				all_languages += " " + ls_lg.getLangue() + " ";
			}
			
			if(docteur.getConsultationDomicile()) {
				aDomicile = "Consultation_a_domicile";
			} else {
				aDomicile = "";
			}
			
			if (docteur.getTeleMedcine()) {
				teleMedcine = "Telemedecine";
			} else {
				teleMedcine = "";
			}
			
			string.add(fullName);  		  //0
			string.add(specialiter); 	  //1
			string.add(adresse); 		  //2
			string.add(gender);   		  //3
			string.add(all_languages);    //4
			string.add(numberOfRating);   //5
			string.add(teleMedcine); 	  //6
			string.add(aDomicile); 		  //7
			string.add(rating); 		  //8
			string.add(numberOfRating);   //9
			string.add(average);          //10
			string.add(specialiterClass); //11
			string.add(HDepart); 		  //12
			string.add(HFin); 			  //13
			string.add(JDepart);  		  //14
			string.add(JFin);  			  //15
			string.add(image); 			  //16
			
			classes_list_map.put(docteur.getCin(), string);
			
		}
		specialities.clear();
		return classes_list_map;
	}
	
	// remplir le map de specialiter et leur class jsp
	public void function() {
		specialities.put("Chirurgie esth�tique", "Chirurgie_esthetique");
		specialities.put("Chirurgie vasculaire", "Chirurgie_vasculaire");
		specialities.put("Chirurgie visc�rale et digestive", "Chirurgie_viscerale_et_digestive");
		specialities.put("Gyn�cologie obst�trique", "Gynecologie_obstetrique");
		specialities.put("Neurochirurgie", "Neurochirurgie");
		specialities.put("Allergologie", "Allergologie");
		specialities.put("Anatomie et cytologie pathologique", "Anatomie_et_cytologie_pathologique");
		specialities.put("Anesth�sie", "Anesthesie");
		specialities.put("Cardiologie", "Cardiologie");
		specialities.put("Dermatologie", "Dermatologie");
		specialities.put("Endocrinologie-nutrition", "Endocrinologie-nutrition");
		specialities.put("G�n�tique", "Genetique");
		specialities.put("Allergologie", "Allergologie");
		specialities.put("Gyn�cologie m�dicale", "Gynecologie_medicale");
		specialities.put("H�matologie", "Hematologie");
		specialities.put("Urgentiste", "Urgentiste");
		specialities.put("Sant� publique", "Sante_publique");
		specialities.put("R�animation", "Reanimation");
		specialities.put("Radiologie", "Radiologie");
		specialities.put("Psychiatrie", "Psychiatrie");
		specialities.put("Neurologie", "Neurologie");
		specialities.put("N�phrologie", "Nephrologie");
		specialities.put("M�decine physique et r�adaptation", "Medecine_physique_et_readaptation");
		specialities.put("M�decine g�n�rale", "Medecine_generale");
		specialities.put("Chirurgie p�diatrique", "Chirurgie_pediatrique");
	}
}
