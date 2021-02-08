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
	private String idDocteur;
	private String all_languages;
	private List<Langue> list_langue;
	private List<String> string = new ArrayList<>();
	private Map<Long,List<String>> classes_list_map = new HashMap<Long, List<String>>();
	private Map<String,String> specialities = new HashMap<String,String>();
	private Map<String , String >data = new HashMap<String , String>();

	
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
	
	// Specifier les données à afficher dans la page searchDoctor par doctor
	public Map<Long, List<String>> displayDoctorsInPage(List<Docteur> list) {
		function();
		string.clear();
		for(Docteur docteur : list) {	
			idDocteur      = String.valueOf(docteur.getCin());
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
			string.add(idDocteur);		  //17
			
			classes_list_map.put(docteur.getCin(), string);
			
		}
		specialities.clear();
		return classes_list_map;
	}

	public Map<String, String> displayDataInProfilePage(Docteur docteur){
		data.put("fullname", docteur.getFirstname() + " " + docteur.getLastname());
		data.put("gender", docteur.getGender()  );
		data.put("adresse", docteur.getAdresse() );
		data.put("age", String.valueOf(docteur.getAge())  );
		data.put("speciality", docteur.getSpeciality() );
		String[] str = docteur.getTel().split("");
		String string ="";
		for(int i = 1 ; i<str.length ; i++) {
			string += str[i];
		}
		data.put("phone", string  );
		data.put("telemedecine", docteur.getTeleMedcine() ? "Télémédecine" : "" );
		data.put("adomicile", docteur.getConsultationDomicile() ? "Consultation a domicile" : ""  );
		data.put("heureD", String.valueOf(docteur.getHeureDepart()) );
		data.put("heureF", String.valueOf(docteur.getHeureFin()) );
		data.put("jourD",  docteur.getJourDepart());
		data.put("jourF",  docteur.getJourFin());
		data.put("description", docteur.getDescription());
		data.put("nbrRating", String.valueOf(ratingImpl.getNumberOfRatingByDoctor(docteur)));
		data.put("image", Base64.getEncoder().encodeToString(docteur.getProfile_image()));
		data.put("average", String.valueOf(ratingImpl.getAverageOfRatingByDoctor(docteur)));
		
//		List<Long> list = ratingImpl.countDistinctValueOfRate(docteur);
//		for(Long li : list) {
//			System.out.println("frooooom number "+li);
//		}
		
		return data;
	}
	
	
	
	
	// remplir le map de specialiter et leur class jsp
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
}
