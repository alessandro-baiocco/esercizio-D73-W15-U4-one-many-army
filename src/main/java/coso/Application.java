package coso;

import com.github.javafaker.Faker;
import entities.*;
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

        Zona cosimo = new Zona();

        Faker faker = new Faker();
        Supplier<Persona> personaSupplier = () -> {
            return new Persona(faker.name().firstName(), faker.name().lastName(), LocalDate.now(), Sesso.FEMMINA);
        };
        Supplier<Event> EventSupplier = () -> {
            return new Event(faker.esports().event(), LocalDate.now() , TipoEvento.PUBBLICO , rnd.nextInt(1 , 50) , Zona);
        };

        PersonaDAO persD = new PersonaDAO(em);
        EventDAO eD = new EventDAO(em)

        for (int i = 0; i < 10; i++) {
            eD.save(personaSupplier.get());
        }


    }
}