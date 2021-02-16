package metier.dao.util;

import metier.dao.Implementations.CliniqueDao;
import metier.dao.Implementations.CommentaireDao;
import metier.dao.Implementations.DocteurDao;
import metier.dao.Implementations.EducationDao;
import metier.dao.Implementations.HopitalDao;
import metier.dao.Implementations.LangueDao;
import metier.dao.Implementations.PharmacieDao;
import metier.dao.Implementations.RatingDao;
import metier.dao.Implementations.RecompenceDao;
import metier.dao.Implementations.RoleDao;
import metier.dao.Implementations.UserDao;
import metier.services.CliniqueImpl;
import metier.services.CommentaireImpl;
import metier.services.DocteurImpl;
import metier.services.EducationImpl;
import metier.services.HopitalImpl;
import metier.services.LangueImpl;
import metier.services.PharmacieImpl;
import metier.services.RatingImpl;
import metier.services.RecompenseImpl;
import metier.services.RoleImpl;
import metier.services.SendEmailService;
import metier.services.SignInFormService;
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
    public static EducationDao educDao      = EducationDao.getInsctance();
	public static RecompenseImpl recomImpl    = RecompenseImpl.getInstance();
	public static RecompenceDao recomDao    = RecompenceDao.getInsctance();
	public static LangueDao langueDao         = LangueDao.getInsctance();
	public static LangueImpl langueImpl       = LangueImpl.getInstance();
	public static PharmacieDao pharmacieDao = PharmacieDao.getInstance();
	public static SignInFormService signInService = SignInFormService.getInstance();
	public static SendEmailService send   = SendEmailService.getInstance();
	public static PharmacieImpl pharmacieImpl = PharmacieImpl.getInstance();

}
