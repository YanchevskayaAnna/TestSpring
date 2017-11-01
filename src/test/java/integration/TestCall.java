package integration;

import dao.SQLDao.SQLAbonentDaoImpl;
import dao.SQLDao.SQLCallDaoImpl;
import dao.SQLDao.SQLUserDaoImpl;
import model.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import service.AbonentServiceImpl;
import service.CallServiceImpl;
import service.UserServiceImpl;
import service.interfaces.AbonentService;
import service.interfaces.CallService;
import service.interfaces.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.time.LocalDate;

public class TestCall {
    private static CallService callService;
    private static EntityManagerFactory emFactory;
    private static EntityManager em;
    private static Abonent abonent;

    @BeforeClass
    public static void beforeClass() throws IOException {
        emFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        em = emFactory.createEntityManager();
        callService = new CallServiceImpl(new SQLCallDaoImpl(emFactory));
        AbonentService abonentService = new AbonentServiceImpl(new SQLAbonentDaoImpl(emFactory));
        UserService userService = new UserServiceImpl(new SQLUserDaoImpl(emFactory));
        User user = new User("test", "test", UserType.USER);
        userService.createUser(user);
        abonent = new Abonent("test", user);
        abonentService.createAbonent(abonent);
    }

    @AfterClass
    public static void afterClass()  {
        emFactory.close();
    }

    @Test
    public void testCreateCall() {
        Call call = new Call(abonent, CallType.IN, "xxx", 50, LocalDate.of(2017, 1,1));
        callService.createCall(call);
        Call call1 = callService.getCallById(call.getId());
        Assert.assertNotNull(call1);
    }

    @Test
    public void testUpdateCall() {
    }

    @Test
    public void testDeleteCall() {
    }

    @Test
    public void testGetCallById() {
    }

    @Test
    public void testGetAllCalls() {
    }
}
