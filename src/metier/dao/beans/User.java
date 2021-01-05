package metier.dao.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class User implements Serializable {

    @Id
<<<<<<< HEAD
    private String id;
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cin;
>>>>>>> 6c6f451704ae988626cb9b17a3010973d71d86ad
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn( name = "idRole", referencedColumnName = "idRole" )
    private Role   role;

    public User() {
        super();
    }

    public Role getRole() {
        return role;
    }

    public void setRole( Role role ) {
        this.role = role;
    }

<<<<<<< HEAD
    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
=======
    public Long getCin() {
        return cin;
    }

    public void setCin( Long cin ) {
        this.cin = cin;
>>>>>>> 6c6f451704ae988626cb9b17a3010973d71d86ad
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname( String firstname ) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname( String lastname ) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

}
