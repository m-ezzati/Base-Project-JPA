package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.function.Supplier;

public final class EntityManagerUtil {

    private static EntityManagerFactory emf ;

    public EntityManagerUtil(EntityManagerFactory emf) {
        EntityManagerUtil.emf = emf;
    }

    private static final Supplier<EntityManager> entityManagerSupplier = () ->
            emf.createEntityManager();

    private static EntityManager getEntityManager(){
        return entityManagerSupplier.get();
    }

    // why not this?
//    private static
//    EntityManager getEntityManager(){
//        return emf.createEntityManager();
//    }

}
