package base.repository.impl;

import base.model.BaseEntity;
import base.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseRepositoryImpl <T extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository <T,ID> {

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
        try{
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }catch(RuntimeException e){
            throw new RuntimeException(e);
        }finally {
            em.close();
        }
    }

    @Override
    public void deleteById(ID id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            T entity = em.find(entityClass, id);
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    @Override
    public List<T> findAll() {
        EntityManager em = emf.createEntityManager();
        List<T> result;
        try{
             result = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
                    .getResultList();
        }finally {
            em.close();
        }
        return result;
    }

    @Override
    public Optional<T> findById(ID id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            T entity = em.find(entityClass, id);
            return Optional.ofNullable(entity);
        }finally {
            em.close();
        }
    }
}
