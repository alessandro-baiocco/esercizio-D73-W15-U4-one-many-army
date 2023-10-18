package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventDAO {
    private EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event evento) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(evento);
            transaction.commit();
            System.out.println("Nuovo studente salvato correttamente");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    public Event findById(long id) {
        return em.find(Event.class, id);
    }

    public void delete(long id) {
        Event eventFounded = em.find(Event.class, id);
        try {
            if (eventFounded != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(eventFounded);
                transaction.commit();
                System.out.println("l'evento è stato cancellato correttamente");
            } else {
                System.err.println("l'evento non è stato trovato");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    public void refresh(Event evento) {
        Event needRef = em.find(Event.class, evento.getEventId());
        if (needRef != null) em.refresh(needRef);
    }
}
