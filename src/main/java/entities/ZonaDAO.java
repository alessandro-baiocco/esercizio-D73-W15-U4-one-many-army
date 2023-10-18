package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ZonaDAO {
    private EntityManager em;

    public ZonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Zona zn) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(zn);
            transaction.commit();
            System.out.println("Nuovo zona salvato correttamente");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    public Zona findById(long id) {
        return em.find(Zona.class, id);
    }

    public void delete(long id) {
        Zona eventFounded = em.find(Zona.class, id);
        try {
            if (eventFounded != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(eventFounded);
                transaction.commit();
                System.out.println("la zona è stato cancellato correttamente");
            } else {
                System.err.println("la zona non è stato trovato");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


}
