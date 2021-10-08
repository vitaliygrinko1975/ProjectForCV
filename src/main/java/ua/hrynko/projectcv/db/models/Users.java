package ua.hrynko.projectcv.db.models;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * User entity.
 */
@Entity(name = "users")
public class Users implements Serializable {

    private static final long serialVersionUID = -6889036256149495388L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 256)
    @Column(name = "login", nullable = false)
    private String login;


    @NotNull
    @Size(max = 256)
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Size(max = 256)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Size(max = 256)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Roles role;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users [login=" + login
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", role=" + role.getName()
                + ", id=" + id + "]";
    }

}
