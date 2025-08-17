package base.repository.impl;

import base.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Optional;

public class BaseRepositoryImpl <T, ID> implements BaseRepository <T,ID> {

//    protected EntityManagerFactory emf =
//            Persistence.createEntityManagerFactory("postgresql-pu");
    protected final EntityManagerFactory emf;
    protected final Class<T> entityClass;

    protected BaseRepositoryImpl(EntityManagerFactory emf, Class<T> entityClass) {
        this.emf = emf;
        this.entityClass = entityClass;
    }

    @Override
    public void add(T entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteById(ID id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        T entity = em.find(entityClass, id);
        if (entity != null) {
            em.remove(entity);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<T> findAll() {
        EntityManager em = emf.createEntityManager();
        List<T> result = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
                .getResultList();
        em.close();
        return result;
    }

    @Override
    public Optional<T> findById(ID id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        T entity = em.find(entityClass, id);
        em.close();
        return Optional.ofNullable(entity);
    }
}
