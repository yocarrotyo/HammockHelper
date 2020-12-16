package entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Review.
 */
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

    /**
     * Instantiates a new Review.
     */
    public Review() {

    }

    /**
     * Gets siteno.
     *
     * @return the siteno
     */
    public String getSiteno() {
        return siteno;
    }

    /**
     * Sets siteno.
     *
     * @param siteno the siteno
     */
    public void setSiteno(String siteno) {
        this.siteno = siteno;
    }

    /**
     * Gets capacity.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets capacity.
     *
     * @param capacity the capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets confidence.
     *
     * @return the confidence
     */
    public int getConfidence() {
        return confidence;
    }

    /**
     * Sets confidence.
     *
     * @param confidence the confidence
     */
    public void setConfidence(int confidence) {
        this.confidence = confidence;
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

    /**
     * Gets parkid.
     *
     * @return the parkid
     */
    public int getParkid() {
        return parkid;
    }

    /**
     * Sets parkid.
     *
     * @param parkid the parkid
     */
    public void setParkid(int parkid) {
        this.parkid = parkid;
    }

    public int compareTo(Review rev) {

        return getConfidence() - rev.getConfidence();

    }

}

