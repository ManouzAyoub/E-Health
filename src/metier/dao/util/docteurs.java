package metier.dao.util;

import java.util.List;

import metier.dao.Implementations.DocteurDao;
import metier.dao.beans.Docteur;

public class docteurs {

	public static void main(String[] args) {
		
		DocteurDao dao = DocteurDao.getInstance();
		
		List<Docteur>  d = dao.getAll();

	}

}
