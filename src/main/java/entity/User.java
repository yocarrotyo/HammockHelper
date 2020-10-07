package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type User.
 */
@Entity(name = "User")
@Table(name = "user")
public class User {
    @Column(name = "user_name")
    private String username;
    @Column(name = "user_fname")
    private String fname;
    @Column(name = "user_lname")
    private String lname;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private int id;

    /**
     * Instantiates a new User.
     */
    public User() {

    }

    /**
     * Instantiates a new User.
     *
     * @param username the username
     * @param fname    the first name
     * @param lname    the last name
     * @param email    the email
     * @param password the password
     */
    public User(String username, String fname, String lname, String email, String password) {
        this.username = username;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets fname.
     *
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * Sets fname.
     *
     * @param fname the fname
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * Gets lname.
     *
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * Sets lname.
     *
     * @param lname the lname
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }
}
