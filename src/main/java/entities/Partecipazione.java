package entities;

import enums.Partecipa;

import javax.persistence.*;

//@ManyToOne
//@JoinColumn(name = "user_id", nullable = false)
//private User user; // <-- Foreign Key

//@OneToMany(mappedBy = "user")
//@OrderBy("title ASC")
//private List<BlogPost> blogPosts; // Non viene creato a DB, serve
//// solo lato Java per permetterci di ottenere la lista di tutti i blog
//// scritti da un certo utente


@Entity
@Table(name = "partecipazione")
public class Partecipazione {

    @Id
    @GeneratedValue
    private long ID;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event evento;


    @Enumerated(EnumType.STRING)
    private Partecipa conferma;


    public Partecipazione() {
    }

    public Partecipazione(Persona partecipante, Event evento, Partecipa conferma) {
        this.persona = partecipante;
        this.evento = evento;
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

    @Override
    public String toString() {
        return persona +
                " partecipazione all'evento : " + evento +
                " " + conferma;
    }
}
