package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.function.Supplier;

public final class EntityManagerUtil {

//    private static EntityManagerFactory emf ;
//    public EntityManagerUtil(EntityManagerFactory emf) {
//        EntityManagerUtil.emf = emf;
//    }

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgresql-pu");

    private static final Supplier<EntityManager> entityManagerSupplier = emf::createEntityManager;

    public static EntityManager getEntityManager() {
        return entityManagerSupplier.get();
    }

    // why not this?
//    private static
//    EntityManager getEntityManager(){
//        return emf.createEntityManager();
//    }

}
