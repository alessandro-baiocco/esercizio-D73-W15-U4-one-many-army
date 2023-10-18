package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "zona")
public class Zona {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String citta;

    @OneToMany
    @JoinTable(name = "lista_eventi",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<Event> eventi;


    public Zona() {

    }

    public Zona(String name, String citta) {
        this.name = name;
        this.citta = citta;
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
}
