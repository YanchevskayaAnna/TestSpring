package dao.SQLDao;


import dao.interfaces.ServiceDao;
import model.Abonent;
import model.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class SQLServiceDaoImpl extends SQLAbstractDAOImpl<Service> implements ServiceDao {
    public SQLServiceDaoImpl(EntityManagerFactory factory) {
        super(factory, Service.class);
    }

    @Override
    public List<Abonent> getAllAbonentsWithService(Service service) {

        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT sa.abonent FROM ServiceAbonent sa where sa.service = :service";
        TypedQuery<Abonent> query = em.createQuery(queryString, Abonent.class);
        query.setParameter("service", service);
        return query.getResultList();

    }

    @Override
    public List<Abonent> getAllAbonentsWithServiceOnDate(Service service, LocalDate date) {
        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT sa.abonent FROM ServiceAbonent sa where sa.service = :service and sa.dateFrom <= :date and (sa.dateTo >= :date or sa.dateTo IS NULL)";
//        String queryString = "SELECT sa.abonent FROM ServiceAbonent sa where sa.service = :service and sa.dateFrom <= :date";
        TypedQuery<Abonent> query = em.createQuery(queryString, Abonent.class);
        query.setParameter("service", service);
        query.setParameter("date", date);
//        query.setParameter("nulldate", null);
        return query.getResultList();
    }
}
