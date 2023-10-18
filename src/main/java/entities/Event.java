package entities;

import enums.TipoEvento;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "evento")
public class Event {
    @Id
    @GeneratedValue
    private long eventId;

    private String titolo;

    private LocalDate dataEvento;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    private int numeroMassimoPartecipanti;

    @OneToMany(mappedBy = "evento")
    @OrderBy("title ASC")
    private List<Partecipazione> partecipanti;


    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Zona zona;


    public Event() {
    }


    public Event(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, int numeroMassimoPartecipanti, List<Partecipazione> partecipanti, Zona zona) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.zona = zona;
    }


    public List<Partecipazione> getPartecipanti() {
        return partecipanti;
    }

    public void setPartecipanti(List<Partecipazione> partecipanti) {
        this.partecipanti = partecipanti;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public long getEventId() {
        return eventId;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Event " +
                titolo +
                " | " + dataEvento +
                " | " + tipoEvento +
                " | massimo : " + numeroMassimoPartecipanti + " partecipanti";
    }
}
