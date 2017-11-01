package dao.SQLDao;

import dao.interfaces.PaymentDao;
import model.Payment;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLPaymentDaoImpl extends SQLAbstractDAOImpl<Payment> implements PaymentDao {
    public SQLPaymentDaoImpl(EntityManagerFactory factory) {
        super(factory, Payment.class);
    }

    @Override
    public Map<User, Integer> getAveragePayment() {

        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT a.user,  AVG(p.value) FROM Payment p join p.abonent a GROUP BY a.user";
        TypedQuery<Object[]> query = em.createQuery(queryString, Object[].class);
        List<Object[]> resultList = query.getResultList();
        HashMap<User, Integer> map = new HashMap<User, Integer>();
        for (int i = 0; i < resultList.size(); i++) {
            map.put((User) resultList.get(i)[0], ((Double) resultList.get(i)[1]).intValue());
        }
        return map;

    }

    @Override
    public Double getAllPayments(LocalDate dateFrom, LocalDate dateTo) {

        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT SUM(p.value) FROM Payment p  WHERE p.paymentDay >= :dateFrom and p.paymentDay <= :dateTo";
        TypedQuery<Long> query = em.createQuery(queryString, Long.class);
        query.setParameter("dateFrom",  dateFrom);
        query.setParameter("dateTo",    dateTo);

        return query.getSingleResult().doubleValue();

    }
}
