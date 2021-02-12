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
import metier.dao.beans.Role;
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
	public List<Docteur> getDoctorsAccordingToTheirAvailability(boolean bool, Role role){
		String hql = "select o from Docteur o, User u where o.dispo = :bool and u.idRole =: idRole";
		Query q = session.createQuery(hql);
		q.setParameter("idRole", role.getIdRole());
		q.setParameter("bool", bool);
		List<Docteur> doctors = q.getResultList();
		
		if (doctors.size() != 0) {
			return doctors;
		}else {
			return null;
		}
	}
	
	// Specifier les donn�es � afficher dans la page searchDoctor par doctor
	public Map<Long, List<String>> displayDoctorsInPage(List<Docteur> list) {
		function();
		System.out.println("la taille de la list passer est egale :::: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			List<String> string = new ArrayList<>();
			Docteur docteur = list.get(i);
			System.out.println("le nom de la list passer est egale :::: " + docteur.getFirstname());
			idDocteur      = String.valueOf(docteur.getCin());
			fullName       = docteur.getFirstname() + " " + docteur.getLastname();
			HDepart        = String.valueOf(docteur.getHeureDepart());
			HFin           = String.valueOf(docteur.getHeureFin());
			JDepart        = docteur.getJourDepart();
			JFin           = docteur.getJourFin();
			adresse        = docteur.getAdresse();
			gender         = docteur.getGender();
			image          = Base64.getEncoder().encodeToString(docteur.getProfile_image());
			numberOfRating = String.valueOf(ratingImpl.getNumberOfRating(docteur.getCin(), "idDocteur"));
			average        = String.valueOf(ratingImpl.getAverageOfRating(docteur.getCin() , "idDocteur"));
			rating         = " stars_" + ratingImpl.getAverageOfRating(docteur.getCin(), "idDocteur");
			specialiter    = docteur.getSpeciality();
			System.out.println(specialiter);
			System.out.println(specialities.get(docteur.getSpeciality()));
			
			if ( !specialities.get(docteur.getSpeciality()).isEmpty() ) {
				specialiterClass = specialities.getOrDefault(docteur.getSpeciality(), "");
			}
			
			list_langue = docteur.getLangues();
			
			for(Langue ls_lg : list_langue) {
				all_languages += " " + ls_lg.getLangue() + " ";
			}
			
			if(docteur.getConsultationDomicile()) {
				System.out.println("// consultation a domicile //");
				aDomicile = "Consultation_a_domicile";
			} else {
				System.out.println(" Non // consultation a domicile //");
				aDomicile = "";
			}
			
			if (docteur.getTeleMedcine()) {
				System.out.println("// tele medecine //");
				teleMedcine = "Telemedecine";
			} else {
				System.out.println(" Non // consultation a domicile //");
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
//		for(Docteur docteur : list) {
//			System.out.println("displayDoctorsInPage : " + docteur);
//				
//		}
		specialities.clear();
		return classes_list_map;
	}

	public Map<String, String> displayDataInProfilePage(Docteur docteur){
		data.put("id", String.valueOf(docteur.getCin()));
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
		data.put("telemedecine", docteur.getTeleMedcine() ? "T�l�m�decine" : "" );
		data.put("adomicile", docteur.getConsultationDomicile() ? "Consultation a domicile" : ""  );
		data.put("heureD", String.valueOf(docteur.getHeureDepart()) );
		data.put("heureF", String.valueOf(docteur.getHeureFin()) );
		data.put("jourD",  docteur.getJourDepart());
		data.put("jourF",  docteur.getJourFin());
		data.put("description", docteur.getDescription());
		data.put("nbrRating", String.valueOf(ratingImpl.getNumberOfRating(docteur.getCin(),"idDocteur")));
		data.put("image", Base64.getEncoder().encodeToString(docteur.getProfile_image()));
		data.put("average", String.valueOf(ratingImpl.getAverageOfRating(docteur.getCin(), "idDocteur")));
		
		return data;
	}
	
	public List<Docteur> getDoctorsByYourAdress(String ville, Boolean bool){
		List<Docteur> list = new ArrayList<Docteur>();
		String hql = "select d from Docteur d where dispo = :bool and  ville like ?1";
		Query q = session.createQuery(hql);
		q.setParameter("bool", bool);
		q.setParameter(1, "%"+ ville + "%");
		list = q.getResultList();
		return list;
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
	
	public String getImageAsString(Docteur docteur) {
		String image = Base64.getEncoder().encodeToString(docteur.getProfile_image());
		return image;
	}
}
