package entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Campsite")
@Table(name = "campsite")
public class Campsite {

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
    private Park park;

    public Campsite() {

    }

}

