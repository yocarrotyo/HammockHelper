package entity;

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
    private int parkid;

    @OneToMany(mappedBy="park",cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.EAGER)
    private List<Campsite> campsites = new ArrayList<>();

    public Park() {

    }
}
