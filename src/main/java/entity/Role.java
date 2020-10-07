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

    //@Column(name = "user_name")
    //private String username;

    @ManyToOne
    @JoinColumn(name="user_name", referencedColumnName = "user_name")
    private User user;

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
     *      * @param admin
     *      * @param username
     *      * @param user
     */
    public Role(String rolename, User user) {
        this.rolename = rolename;
        this.user = user;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
