package dao.SQLDao;

import dao.interfaces.CallDao;
import model.Abonent;
import model.Call;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLCallDaoImpl extends SQLAbstractDAOImpl<Call> implements CallDao {

    public SQLCallDaoImpl(EntityManagerFactory factory) {
        super(factory, Call.class);
    }

    @Override
    public Double getAverageDuration(Abonent abonent) {

        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT AVG(m.duration) FROM Call m  WHERE m.abonent = :abonent";
        TypedQuery<Double> query = em.createQuery(queryString, Double.class);
        query.setParameter("abonent",  abonent);

        return query.getSingleResult();
    }

    @Override
    public Double getAverageDuration(Abonent abonent, LocalDate dateFrom, LocalDate dateTo) {

        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT AVG(m.duration) FROM Call m  WHERE m.date >= :dateFrom and m.date <= :dateTo and m.abonent = :abonent";
        TypedQuery<Double> query = em.createQuery(queryString, Double.class);
        query.setParameter("abonent",  abonent);
        query.setParameter("dateFrom", dateFrom);
        query.setParameter("dateTo",   dateTo);

        return query.getSingleResult();
    }

    @Override
    public Map<Abonent, Integer> getAverageDuration() {
        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT m.abonent,  AVG(m.duration) FROM Call m GROUP BY m.abonent";
        TypedQuery<Object[]> query = em.createQuery(queryString, Object[].class);
        List<Object[]> resultList = query.getResultList();

        HashMap<Abonent, Integer> map = new HashMap<Abonent, Integer>();

        for (int i = 0; i < resultList.size(); i++) {
            map.put((Abonent) resultList.get(i)[0], ((Double) resultList.get(i)[1]).intValue());
        }
        return map;
    }

    @Override
    public Map<Abonent, Integer> getAverageDuration(LocalDate dateFrom, LocalDate dateTo) {

        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT m.abonent,  AVG(m.duration) FROM Call m  WHERE m.date >= :dateFrom and m.date <= :dateTo GROUP BY m.abonent";
        TypedQuery<Object[]> query = em.createQuery(queryString, Object[].class);
        query.setParameter("dateFrom", dateFrom);
        query.setParameter("dateTo",   dateTo);
        List<Object[]> resultList = query.getResultList();
        HashMap<Abonent, Integer> map = new HashMap<Abonent, Integer>();

        for (int i = 0; i < resultList.size(); i++) {
            map.put((Abonent) resultList.get(i)[0], ((Double) resultList.get(i)[1]).intValue());
        }
        return map;
    }

    @Override
    public Map<User, Integer> getAverageDurationUser() {
        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT a.user,  AVG(c.duration) FROM Call c join c.abonent a GROUP BY a.user";
        TypedQuery<Object[]> query = em.createQuery(queryString, Object[].class);
        List<Object[]> resultList = query.getResultList();

        HashMap<User, Integer> map = new HashMap<User, Integer>();

        for (int i = 0; i < resultList.size(); i++) {
            map.put((User) resultList.get(i)[0], ((Double) resultList.get(i)[1]).intValue());
        }
        return map;
    }

    @Override
    public Map<User, Integer> getAverageDurationUser(LocalDate dateFrom, LocalDate dateTo) {

        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT a.user,  AVG(c.duration) FROM Call c join c.abonent a  WHERE c.date >= :dateFrom and c.date <= :dateTo GROUP BY a.user";
        TypedQuery<Object[]> query = em.createQuery(queryString, Object[].class);
        query.setParameter("dateFrom", dateFrom);
        query.setParameter("dateTo",   dateTo);
        List<Object[]> resultList = query.getResultList();

        HashMap<User, Integer> map = new HashMap<User, Integer>();

        for (int i = 0; i < resultList.size(); i++) {
            map.put((User) resultList.get(i)[0], ((Double) resultList.get(i)[1]).intValue());
        }
        return map;
    }
}
