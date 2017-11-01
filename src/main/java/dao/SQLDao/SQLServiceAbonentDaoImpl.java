package dao.SQLDao;


import dao.interfaces.ServiceAbonentDao;
import model.Abonent;
import model.Service;
import model.ServiceAbonent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class SQLServiceAbonentDaoImpl extends SQLAbstractDAOImpl<ServiceAbonent> implements ServiceAbonentDao {
    public SQLServiceAbonentDaoImpl(EntityManagerFactory factory) {
        super(factory, ServiceAbonent.class);
    }

    @Override
    public List<Service> getCurrentServices(Abonent abonent, LocalDate date) {
        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT sa.service FROM ServiceAbonent sa where sa.abonent = :abonent and sa.dateFrom <= :date and (sa.dateTo >= :date or sa.dateTo IS NULL)";
//      String queryString = "SELECT sa.service FROM ServiceAbonent sa where sa.abonent = :abonent and sa.dateFrom <= :date";
        TypedQuery<Service> query = em.createQuery(queryString, Service.class);
        query.setParameter("abonent", abonent);
        query.setParameter("date", date);
//        query.setParameter("nulldate", null);
        return query.getResultList();

    }
}
