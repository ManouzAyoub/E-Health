package metier.dao.util;

import metier.dao.Implementations.CliniqueDao;
import metier.dao.Implementations.CommentaireDao;
import metier.dao.Implementations.DocteurDao;
import metier.dao.Implementations.HopitalDao;
import metier.dao.Implementations.LangueDao;
import metier.dao.Implementations.RatingDao;
import metier.dao.Implementations.RoleDao;
import metier.dao.Implementations.UserDao;
import metier.services.CliniqueImpl;
import metier.services.CommentaireImpl;
import metier.services.DocteurImpl;
import metier.services.EducationImpl;
import metier.services.HopitalImpl;
import metier.services.LangueImpl;
import metier.services.RatingImpl;
import metier.services.RecompenseImpl;
import metier.services.RoleImpl;
import metier.services.UserImpl;

public class Instances {
	
	public static DocteurDao docteurDao       = DocteurDao.getInstance();
	public static DocteurImpl docteurImpl     = DocteurImpl.getInstance();
	public static RatingDao ratingDao         = RatingDao.getInstance();
	public static RatingImpl ratingImpl       = RatingImpl.getInstance();
	public static CommentaireDao commentDao   = CommentaireDao.getInstance();
	public static CommentaireImpl commentImpl = CommentaireImpl.getInstance();
	public static UserDao userDao             = UserDao.getInstance();
	public static UserImpl userImpl           = UserImpl.getInstance();
	public static RoleImpl roleImpl           = RoleImpl.getInstance();
    public static RoleDao roleDao             = RoleDao.getInstance();
    public static CliniqueDao cliniqueDao     = CliniqueDao.getInsctance();
    public static CliniqueImpl cliniqueImpl   = CliniqueImpl.getInstance();
    public static HopitalDao hopitalDao       = HopitalDao.getInstance();
    public static HopitalImpl hopitalImpl     = HopitalImpl.getInstance();
    public static EducationImpl educImpl      = EducationImpl.getInstance();
	public static RecompenseImpl recomImpl    = RecompenseImpl.getInstance();
	public static LangueDao langueDao         = LangueDao.getInsctance();
	public static LangueImpl langueImpl       = LangueImpl.getInstance();

}
