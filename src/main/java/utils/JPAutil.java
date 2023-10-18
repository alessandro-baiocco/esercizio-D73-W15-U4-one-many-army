package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {
    private static EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("esercizio-D72-W15-U4");
        } catch (Throwable ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static EntityManagerFactory emfCreate() {
        return entityManagerFactory;
    }


}