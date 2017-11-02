package dao.SQLDao;

import dao.interfaces.UserDao;
import exception.TableIsEmptyException;
import model.Abonent;
import model.User;
import model.UserType;
import model.auxiliary.AbonentInfo;
import sun.awt.datatransfer.DataTransferer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SQLUserDaoImpl extends SQLAbstractDAOImpl<User> implements UserDao {

    public SQLUserDaoImpl(EntityManagerFactory factory) {
        super(factory, User.class);
    }

    @Override
    public List<User> getAllUsersWithUserType(UserType usertype) {

        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT u FROM User u where u.userType = :usertype";
        TypedQuery<User> query = em.createQuery(queryString, User.class);
        query.setParameter("usertype", usertype);
        return query.getResultList();
    }

    @Override
    public List<Abonent> getAllAbonents(User user) throws TableIsEmptyException {
        List<Abonent> resultlist = user.getAbonentList();
        if (resultlist.size() == 0) {
            throw new TableIsEmptyException("Current table is empty");
        }
        return resultlist;
    }

    @Override
    public List<AbonentInfo> getAllAbonentsWithInfo(User user) throws TableIsEmptyException {
        List<Abonent> abonentlist = user.getAbonentList();
        if (abonentlist.size() == 0) {
            throw new TableIsEmptyException("Current table is empty");
        }

        List<AbonentInfo> resultlist = new ArrayList<>();
        for (Abonent abonent: abonentlist){
            AbonentInfo abonentInfo = new AbonentInfo();
            abonentInfo.setName(abonent.getName());
            abonentInfo.setType(user.getUserType());
            abonentInfo.setServices(new SQLServiceAbonentDaoImpl(this.factory).getCurrentServices(abonent, LocalDate.now()));
            abonentInfo.setBalance(new SQLAbonentDaoImpl(this.factory).calculateBalance(abonent, LocalDate.now()));
            resultlist.add(abonentInfo);
        }
        return resultlist;
    }

    @Override
    public User getUserByName(String nameUser){
        EntityManager em = factory.createEntityManager();
        //Строим таблицу с полями Сервис Дата с - Дата по
        String queryString = "SELECT u FROM User u  WHERE u.login = :name";
        TypedQuery<User> query = em.createQuery(queryString, User.class);
        query.setParameter("name",   nameUser);
        return query.getSingleResult();

    }


}
