package ir.airport.utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private final static EntityManagerFactory entityManagerFactory;
    private final static EntityManager entityManager;

    static{
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManager getEntityManager(){
        return entityManager;
    }
}
