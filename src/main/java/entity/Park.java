package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public Park() {

    }

    public String getParkname() {
        return parkname;
    }

    public void setParkname(String parkname) {
        this.parkname = parkname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getParklat() {
        return parklat;
    }

    public void setParklat(double parklat) {
        this.parklat = parklat;
    }

    public double getParklong() {
        return parklong;
    }

    public void setParklong(double parklong) {
        this.parklong = parklong;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getPark_id() {
        return park_id;
    }

    public void setPark_id(int id) {
        this.park_id = id;
    }

    public List<Campsite> getCampsites() {
        return campsites;
    }

    public void setCampsites(List<Campsite> campsites) {
        this.campsites = campsites;
    }
}
