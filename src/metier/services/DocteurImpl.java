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
	RatingImpl ratingImpl = RatingImpl.getInstance();
	String fullName;
	String specialiter;
	String specialiterClass;
	String adresse;
	String aDomicile;
	String teleMedcine;
	String gender;
	String rating;
	String numberOfRating;
	String average;
	String HDepart;
	String HFin;
	String JDepart;
	String JFin;
	String image;
	Map<Long,List<String>> classes_list_map = new HashMap<Long, List<String>>();
	String all_languages;
	List<Langue> list_langue;
	List<String> string = new ArrayList<>();
	Session session = HibernateUtil.openSession();
	Map<String,String> specialities = new HashMap<String,String>();
	
	public void function() {
		specialities.put("Chirurgie esthétique", "Chirurgie_esthetique");
		specialities.put("Chirurgie vasculaire", "Chirurgie_vasculaire");
		specialities.put("Chirurgie viscérale et digestive", "Chirurgie_viscerale_et_digestive");
		specialities.put("Gynécologie obstétrique", "Gynecologie_obstetrique");
		specialities.put("Neurochirurgie", "Neurochirurgie");
		specialities.put("Allergologie", "Allergologie");
		specialities.put("Anatomie et cytologie pathologique", "Anatomie_et_cytologie_pathologique");
		specialities.put("Anesthésie", "Anesthesie");
		specialities.put("Cardiologie", "Cardiologie");
		specialities.put("Dermatologie", "Dermatologie");
		specialities.put("Endocrinologie-nutrition", "Endocrinologie-nutrition");
		specialities.put("Génétique", "Genetique");
		specialities.put("Allergologie", "Allergologie");
		specialities.put("Gynécologie médicale", "Gynecologie_medicale");
		specialities.put("Hématologie", "Hematologie");
		specialities.put("Urgentiste", "Urgentiste");
		specialities.put("Santé publique", "Sante_publique");
		specialities.put("Réanimation", "Reanimation");
		specialities.put("Radiologie", "Radiologie");
		specialities.put("Psychiatrie", "Psychiatrie");
		specialities.put("Neurologie", "Neurologie");
		specialities.put("Néphrologie", "Nephrologie");
		specialities.put("Médecine physique et réadaptation", "Medecine_physique_et_readaptation");
		specialities.put("Médecine générale", "Medecine_generale");
		specialities.put("Chirurgie pédiatrique", "Chirurgie_pediatrique");
	}
	
	private DocteurImpl() {
		
	}
	
	public static DocteurImpl getInstance() {
	    if (instance == null)
	                   instance = new DocteurImpl();
	    return instance;
	}
	
	public List<Docteur> getDoctorsAccordingToTheirAvailability(boolean bool){
		String hql = "select o from Docteur o where dispo = :bool";
		Query q = session.createQuery(hql);
		q.setParameter("bool", bool);
		List<Docteur> doctors = q.getResultList();
		return doctors;
	}
	
	public Map<Long, List<String>> displayDoctorsInPage(List<Docteur> list) {
		function();
		for(Docteur docteur : list) {
			
			fullName       = docteur.getFirstname() + " " + docteur.getLastname(); 
			if ( !specialities.get(docteur.getSpeciality()).isEmpty() ) {
				specialiterClass = specialities.getOrDefault(docteur.getSpeciality(), "");
			}
			HDepart = String.valueOf(docteur.getHeureDepart());
			HFin  = String.valueOf(docteur.getHeureFin());
			JDepart = docteur.getJourDepart();
			
			JFin = docteur.getJourFin();
			adresse        = docteur.getAdresse();
			gender         = docteur.getGender();
			image = Base64.getEncoder().encodeToString(docteur.getProfile_image());
			numberOfRating = String.valueOf(ratingImpl.getNumberOfRatingByDoctor(docteur));
			average        = String.valueOf(ratingImpl.getAverageOfRatingByDoctor(docteur));
			rating         = " stars_" + ratingImpl.getAverageOfRatingByDoctor(docteur);
			specialiter = docteur.getSpeciality();
			
			// la list des langues par docteur
			list_langue = docteur.getLangues();
			
			
			for(Langue ls_lg : list_langue) {
				all_languages += " " + ls_lg.getLangue() + " ";
			}
			
			if(docteur.getConsultationDomicile()) {
				aDomicile = "Consultation_a_domicile";
			}
			
			if (docteur.getTeleMedcine()) {
				teleMedcine = "Telemedecine";
			}
			
			string.add(fullName); //0
			string.add(specialiter); //1
			string.add(adresse); //2
			string.add(gender); //3
			string.add(all_languages); //4
			string.add(numberOfRating); //5
			string.add(teleMedcine); //6
			string.add(aDomicile); //7
			string.add(rating); //8
			string.add(numberOfRating); //9
			string.add(average); // 10
			string.add(specialiterClass); //11
			string.add(HDepart); //12
			string.add(HFin); //13
			string.add(JDepart); //14
			string.add(JFin); //15
			string.add(image); //16
			classes_list_map.put(docteur.getCin(), string);
			
		}
		specialities.clear();
		
		return classes_list_map;
	}
}
