package dao.SQLDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

import dao.interfaces.AbstractDAO;
import model._IDEntity;
import org.apache.log4j.Logger;


public class SQLAbstractDAOImpl<E extends _IDEntity> implements AbstractDAO<E> {

    private Class<E> entityClass;
    private String nameClass;
    protected EntityManagerFactory factory;
    private static final Logger LOGGER = Logger.getLogger(SQLAbstractDAOImpl.class.getName());
    //Сделать try finally через лямбду, передавать метод как параметр

    public SQLAbstractDAOImpl(EntityManagerFactory factory, Class<E> entityClass) {
        this.factory = factory;
        this.entityClass = entityClass;
        this.nameClass = entityClass.getSimpleName();
    }

    @Override
    public List<E> getAll() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<E> namedQuery = em.createNamedQuery(nameClass + ".getAll", entityClass);
        return namedQuery.getResultList();
    }

    @Override
    public E getEntityById(Integer id){
        EntityManager em = factory.createEntityManager();
        return em.find(entityClass, id);
    }

    @Override
    public boolean update(E entity){

        LOGGER.info("update " + nameClass);

        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(entity);
            transaction.commit();
            LOGGER.info(nameClass + " was saved");
        } catch (Exception e) {
            LOGGER.error(nameClass + " was not saved", e);
            transaction.rollback();
        } finally {
            em.close();
        }

        return true;

    }

    @Override
    public boolean create(E entity){

        LOGGER.info("create new " + nameClass);

        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(entity);
            transaction.commit();
            LOGGER.info(nameClass + " was saved");
        } catch (Exception e) {
            LOGGER.error(nameClass + " was not saved", e);
            transaction.rollback();
        } finally {
            em.close();
        }

        return true;

    }

    public boolean delete(E entity){

        LOGGER.info("delete " + nameClass);
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        // сделали E extends id и поэтому доступно поле id
        E delEntity = em.find(entityClass, entity.getId());

        try {
            transaction.begin();
            em.remove(delEntity);
            transaction.commit();
            LOGGER.info(nameClass + " was deleted");
        } catch (Exception e) {
            LOGGER.error(nameClass + " was not deleted", e);
            transaction.rollback();
        } finally {
            em.close();
        }
        return true;

    }

}
