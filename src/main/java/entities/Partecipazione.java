package entities;

import enums.Partecipa;

import javax.persistence.*;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {

    @Id
    @GeneratedValue
    private long ID;

    @ManyToOne
    @JoinColumn(name = "partecipation_id", nullable = false)
    private Persona partecipante;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event evento;


    @Enumerated(EnumType.STRING)
    private Partecipa conferma;


    public Partecipazione() {
    }

    public Partecipazione(Partecipa conferma) {
        this.conferma = conferma;
    }

    public Partecipa getConferma() {
        return conferma;
    }

    public void setConferma(Partecipa conferma) {
        this.conferma = conferma;
    }

    public long getID() {
        return ID;
    }
}
