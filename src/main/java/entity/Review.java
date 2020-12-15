package entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Review")
@Table(name = "review")
public class Review implements Comparable<Review> {

    @Column(name = "site_no")
    private String siteno;

    @Column(name = "park_id")
    private int parkid;
    @Column(name = "site_cap")
    @Min(value = 0)
    private int capacity;
    @Column(name = "site_info_confidence")
    private int confidence;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy="native")
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParkid() {
        return parkid;
    }

    public void setParkid(int parkid) {
        this.parkid = parkid;
    }

    public int compareTo(Review rev) {

        return getConfidence() - rev.getConfidence();

    }

}

