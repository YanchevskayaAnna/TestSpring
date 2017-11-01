package integration;


import dao.SQLDao.*;
import model.Abonent;
import model.User;
import model.UserType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import service.*;
import service.interfaces.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;

public class TestAbonent {

    private static AbonentService abonentService;
    private static UserService userService;
    private static EntityManagerFactory emFactory;
    private static User user;

    @BeforeClass
    public static void beforeClass() throws IOException {
        emFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        abonentService = new AbonentServiceImpl(new SQLAbonentDaoImpl(emFactory));
        userService = new UserServiceImpl(new SQLUserDaoImpl(emFactory));
        user = new User("test", "test", UserType.USER);
        userService.createUser(user);
    }

    @AfterClass
    public static void afterClass()  {
         emFactory.close();
    }

    @Test
    public void testCreateAbonent() {
//        Abonent abonent = new Abonent("test create", new User("test create", "xxx", UserType.USER));
        Abonent abonent = new Abonent("test create", user);
        abonentService.createAbonent(abonent);
        Abonent abonent1 = abonentService.getAbonentById(abonent.getId());
        Assert.assertNotNull(abonent1);
    }

    @Test
    public void testUpdateAbonent() {
//        Abonent abonent = new Abonent("test update", new User("test update", "xxx", UserType.USER));
        Abonent abonent = new Abonent("test update", user);
        abonentService.createAbonent(abonent);
        Abonent abonent1 = abonentService.getAbonentById(abonent.getId());
        abonent1.setName("update");
        abonentService.updateAbonent(abonent1);
        Abonent updatedAbonent = abonentService.getAbonentById(abonent1.getId());
        Assert.assertNotNull(updatedAbonent);
        Assert.assertEquals("update", updatedAbonent.getName());
    }

    @Test
    public void testDeleteAbonent() {
//        Abonent abonent = new Abonent("test delete", new User("test delete", "xxx", UserType.USER));
        Abonent abonent = new Abonent("test delete", user);
        abonentService.createAbonent(abonent);
        Abonent abonent1 = abonentService.getAbonentById(abonent.getId());
        Assert.assertNotNull(abonent1);
        abonentService.deleteAbonent(abonent);
        Abonent deletedAbonent = abonentService.getAbonentById(abonent.getId());
        Assert.assertNull(deletedAbonent);
    }

    @Test
    public void testGetAbonentById() {
//        Abonent abonent = new Abonent("test get abonent by id", new User("test get abonent by id", "xxx", UserType.USER));
        Abonent abonent = new Abonent("test get abonent by id", user);
        abonentService.createAbonent(abonent);
        Abonent getAbonentByID = abonentService.getAbonentById(abonent.getId());
        Assert.assertEquals(abonent.getId(), getAbonentByID.getId());
        Assert.assertEquals(abonent.getName(), getAbonentByID.getName());
    }

    @Test
    public void testGetAllAbonents() {
//        Abonent abonent = new Abonent("test get all abonents", new User("test get all abonents", "xxx", UserType.USER));
        Abonent abonent = new Abonent("test get all abonents", user);
        abonentService.createAbonent(abonent);
        List<Abonent> abonentList = abonentService.getAllAbonents();
        Assert.assertNotNull(abonentList);
    }
}
