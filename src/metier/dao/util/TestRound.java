package metier.dao.util;

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
		
		RatingImpl rImpl = RatingImpl.getInstance();
		
		Rating r = new Rating();
		
		Docteur docteur = new Docteur();
		
		DocteurDao dao = DocteurDao.getInstance();
		
		docteur = dao.getById(1L);
		
		Map<Integer, Long> m = new HashMap<Integer, Long>();
		
		Map<Integer , Long> list = rImpl.countDistinctValueOfRate(docteur); 
		
		System.out.println(list.getOrDefault(4, 0L));
		
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

	}

}
