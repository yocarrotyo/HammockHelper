package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Role.
 */
@Entity(name = "Role")
@Table(name = "role")
public class Role {

    @Column(name = "role_name")
    private String rolename;
    @ManyToOne
    @JoinColumn(referencedColumnName = "user_name")
    private User username;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private int id;


    /**
     * Instantiates a new Role.
     */
    public Role() {

    }

    /**
     * Instantiates a new Role.
     */
    public Role(String rolename, User username) {
        this.rolename = rolename;
        this.username = username;

    }

    /**
     * Gets rolename.
     *
     * @return the rolename
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * Sets rolename.
     *
     * @param rolename the rolename
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public User getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(User username) {
        this.username = username;
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
