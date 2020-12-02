package entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Campsite")
@Table(name = "campsite")
public class Campsite {

    @Column(name = "site_no")
    private String siteno;
    //@Column(name = "park_id")
    //private int parkid;
    @Column(name = "site_cap")
    private int capacity;
    @Column(name = "site_info_confidence")
    private int confidence;
    @Column(name = "site_rating")
    private float rating;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private int id;

    @ManyToOne
    @JoinColumn(name = "park_id")
    private Park parkid;

    public String getSiteno() {
        return siteno;
    }

    public void setSiteno(String siteno) {
        this.siteno = siteno;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Park getParkid() {
        return parkid;
    }

    public void setParkid(Park parkid) {
        this.parkid = parkid;
    }

    public Campsite() {

    }

}

