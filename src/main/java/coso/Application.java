package coso;

import com.github.javafaker.Faker;
import entities.*;
import enums.Partecipa;
import enums.Sesso;
import enums.TipoEvento;
import utils.JPAutil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = JPAutil.emfCreate();

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Random rnd = new Random();
        Faker faker = new Faker();

        PersonaDAO persD = new PersonaDAO(em);
        EventDAO eD = new EventDAO(em);
        ZonaDAO zD = new ZonaDAO(em);
        PartecipazioneDAO partD = new PartecipazioneDAO(em);


        Supplier<Zona> zonaSupplier = () -> {
            return new Zona(faker.address().fullAddress(), faker.address().cityName());
        };


        Supplier<Persona> personaSupplier = () -> {
            return new Persona(faker.name().firstName(), faker.name().lastName(), LocalDate.now(), Sesso.MASCHIO);
        };

        Supplier<Event> eventSupplier = () -> {
            return new Event(faker.esports().event(), LocalDate.now(), TipoEvento.PUBBLICO, rnd.nextInt(1, 50), zD.findById(rnd.nextInt(110, 119)));
        };
        Supplier<Partecipazione> invitiSupplier = () -> {
            return new Partecipazione(persD.findById(rnd.nextInt(100, 109)), eD.findById(rnd.nextInt(120, 129)), Partecipa.CONFERMATO);
        };

//
//        for (int i = 0; i < 10; i++) {
//            persD.save(personaSupplier.get());
//        }
//        for (int i = 0; i < 10; i++) {
//            zD.save(zonaSupplier.get());
//        }

//        for (int i = 0; i < 10; i++) {
//            eD.save(eventSupplier.get());
//        }
//        for (int i = 0; i < 10; i++) {
//            partD.save(invitiSupplier.get());
//        }


//        eD.delete(127);
//        System.out.println(partD.findById(88));
//        for (int i = 0; i < 10; i++) {
//            partD.save(invitiSupplier.get());
//        }


        Persona franco = personaSupplier.get();
        Zona portoCazzi = zonaSupplier.get();
        Event festaVera = new Event(faker.esports().event(), LocalDate.now(), TipoEvento.PUBBLICO, rnd.nextInt(1, 50), portoCazzi);
        Partecipazione cheFaFranco = new Partecipazione(franco, festaVera, Partecipa.CONFERMATO);


        em.close();
        emf.close();
    }
}