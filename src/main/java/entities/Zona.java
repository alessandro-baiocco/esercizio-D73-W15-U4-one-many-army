package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zona")
public class Zona {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String citta;


    @OneToMany(mappedBy = "zona")
    private List<Event> eventi;


    public Zona() {

    }

    public Zona(String name, String citta) {
        this.name = name;
        this.citta = citta;
        this.eventi = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Zona " +
                " | " + name +
                " | " + citta;
    }
}
