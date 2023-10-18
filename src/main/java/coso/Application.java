package coso;

import utils.JPAutil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Application {
    private static final EntityManagerFactory emf = JPAutil.emfCreate();

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();


    }
}