package metier.services;

public class CommentaireImpl {

	private static CommentaireImpl instance = null;
	
	private CommentaireImpl() {
		
	}
	
	public static CommentaireImpl getInstance() {
	    if (instance == null)
	                   instance = new CommentaireImpl();
	    return instance;
	}
}
