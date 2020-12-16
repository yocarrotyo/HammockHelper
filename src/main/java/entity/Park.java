package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Park.
 */
@Entity(name = "Park")
@Table(name = "park")
public class Park {

    @Column(name = "pk_name")
    private String parkname;
    @Column(name = "pk_state")
    private String state;
    @Column(name = "pk_lat")
    private double parklat;
    @Column(name = "pk_long")
    private double parklong;
    @Column(name = "pk_ZIP")
    private String zipcode;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private int park_id;

    @OneToMany(mappedBy="parkid",cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.EAGER)
    private List<Campsite> campsites = new ArrayList<>();

    /**
     * Instantiates a new Park.
     */
    public Park() {

    }

    /**
     * Gets parkname.
     *
     * @return the parkname
     */
    public String getParkname() {
        return parkname;
    }

    /**
     * Sets parkname.
     *
     * @param parkname the parkname
     */
    public void setParkname(String parkname) {
        this.parkname = parkname;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets parklat.
     *
     * @return the parklat
     */
    public double getParklat() {
        return parklat;
    }

    /**
     * Sets parklat.
     *
     * @param parklat the parklat
     */
    public void setParklat(double parklat) {
        this.parklat = parklat;
    }

    /**
     * Gets parklong.
     *
     * @return the parklong
     */
    public double getParklong() {
        return parklong;
    }

    /**
     * Sets parklong.
     *
     * @param parklong the parklong
     */
    public void setParklong(double parklong) {
        this.parklong = parklong;
    }

    /**
     * Gets zipcode.
     *
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Sets zipcode.
     *
     * @param zipcode the zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Gets park id.
     *
     * @return the park id
     */
    public int getPark_id() {
        return park_id;
    }

    /**
     * Sets park id.
     *
     * @param id the id
     */
    public void setPark_id(int id) {
        this.park_id = id;
    }

    /**
     * Gets campsites.
     *
     * @return the campsites
     */
    public List<Campsite> getCampsites() {
        return campsites;
    }

    /**
     * Sets campsites.
     *
     * @param campsites the campsites
     */
    public void setCampsites(List<Campsite> campsites) {
        this.campsites = campsites;
    }
}
