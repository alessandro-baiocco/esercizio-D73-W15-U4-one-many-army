package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione Partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(Partecipazione);
            transaction.commit();
            System.out.println("Nuovo invito salvato correttamente");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    public Event findById(long id) {
        return em.find(Event.class, id);
    }

    public void delete(long id) {
        Partecipazione eventFounded = em.find(Partecipazione.class, id);
        try {
            if (eventFounded != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(eventFounded);
                transaction.commit();
                System.out.println("invito cancellato correttamente");
            } else {
                System.err.println("l'invito non è stato trovato");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
