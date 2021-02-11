package metier.dao.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import metier.dao.Implementations.DocteurDao;
import metier.dao.beans.Commentaire;
import metier.dao.beans.Docteur;
import metier.dao.beans.Rating;
import metier.services.CommentaireImpl;
import metier.services.RatingImpl;

public class TestRound {
	
	

	public static void main(String[] args) {
		
	    int x = 5;
	    Long y = 6L;
		
	    Double a = Double.valueOf(x);
	    Double b = Double.valueOf(y);
	    
	    System.out.println(a + " - " + b);
	    Double i2 = (a/b)*100;
	    System.out.println(" bien ?: "+ Double.valueOf(new DecimalFormat("##.##").format(i2)));
//		RatingImpl rImpl = RatingImpl.getInstance();
//		
//		Rating r = new Rating();
//		
//		Docteur docteur = new Docteur();
//		
//		DocteurDao dao = DocteurDao.getInstance();
//		
//		docteur = dao.getById(1L);
//		
//		Map<Integer, Long> m = new HashMap<Integer, Long>();
		
		
//		Map<String, List<String>> test = new HashMap<String, List<String>>();
//		
//		List<String> list = new ArrayList<String>();
//		list.add("el gourari");
//		list.add("el fahfouhi");
//		list.add("el hachimi");
//		
//		test.put("youssef", list);
//		
//		List<String> lst = new ArrayList<String>();
//		
//		System.out.println(test.getOrDefault("youssef", lst ).get(0)); // entry.getOrDefault(entry.key, entry.value).get(8)

//		float i = 5;
//		float nbr = 21;
//		Double variable;
//		variable = (double) ((i/nbr)*100);
//		System.out.println(Math.round(i/nbr));
//		
//		System.out.println(Math.round(variable));
//		double a = 123.13698;
//	    double roundOff = Math.round(a*100)/100.0;
//
//	    System.out.println(roundOff);
	}

}
