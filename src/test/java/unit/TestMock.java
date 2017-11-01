package unit;

import dao.SQLDao.SQLAbonentDaoImpl;
import dao.interfaces.AbonentDao;
import dao.interfaces.CallDao;
import dao.interfaces.ServiceDao;
import model.*;
import org.junit.BeforeClass;
import org.junit.Test;
import service.AbonentServiceImpl;
import service.ServiceServiceImpl;
import service.interfaces.*;

import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMock {

    private static AbonentService abonentService;
    private static ServiceService serviceService;
    private static UserService userService;
    private static ServiceAbonentService serviceAbonentService;
    private static CallService callService;
    private static PaymentService paymentService;
    private static EntityManagerFactory emFactory;

    @BeforeClass
    public static void init() {
        //users
        User user = new User("user", "xxx", UserType.USER);
        User admin = new User("admin", "xxx", UserType.ADMIN);
        //abonents
        Abonent userAbonent  = new Abonent("user", user);
        Abonent adminAbonent = new Abonent("admin", admin);
        //services
        Service serviceCall = new Service("Call", 100);
        Service serviceInet = new Service("Inet", 200);
        Service serviceCallInet = new Service("Call&Inet", 150);
        //services abonents
        ServiceAbonent serviceCallUser = new ServiceAbonent(serviceCall, userAbonent, LocalDate.of(2017, 1,1), null);
        ServiceAbonent serviceInetUser = new ServiceAbonent(serviceInet, userAbonent, LocalDate.of(2017, 1,1), null);
        ServiceAbonent serviceCallInetUser = new ServiceAbonent(serviceCallInet, userAbonent, LocalDate.of(2017, 1,1), null);
        ServiceAbonent serviceCallAdmin = new ServiceAbonent(serviceCall, adminAbonent, LocalDate.of(2017, 1,1), null);
        ServiceAbonent serviceInetAdmin = new ServiceAbonent(serviceInet, adminAbonent, LocalDate.of(2017, 1,1), null);
        ServiceAbonent serviceCallInetAdmin = new ServiceAbonent(serviceCallInet, adminAbonent, LocalDate.of(2017, 1,1), null);
        //calls
        Call callUser = new Call(userAbonent, CallType.IN, "999", 10, LocalDate.of(2017, 1,1));
        Call callAbonent = new Call(adminAbonent, CallType.IN, "999", 10, LocalDate.of(2017, 1,1));
        //payments
        Payment paymentUser = new Payment(userAbonent, LocalDate.of(2017, 1, 1), 10000);
        Payment paymentAdmin = new Payment(adminAbonent, LocalDate.of(2017, 1, 1), 20000);

        AbonentDao abonentDao = mock(AbonentDao.class);
        CallDao callDao = mock(CallDao.class);
        ServiceDao serviceDao= mock(ServiceDao.class);

        when(abonentDao.create(notNull(Abonent.class))).thenReturn(true);
        when(abonentDao.getAll()).thenReturn(
                Arrays.asList(
                        userAbonent, adminAbonent));
        when(abonentDao.update(notNull(Abonent.class))).thenReturn(true);
        when(abonentDao.getEntityById(anyInt())).thenReturn(userAbonent);
        when(serviceDao.getAll()).thenReturn(Arrays.asList(
                serviceCall, serviceInet, serviceCallInet));

        abonentService = new AbonentServiceImpl(abonentDao);
        serviceService = new ServiceServiceImpl(serviceDao);

    }

    @Test
    public void getAllStudents() {
        assertNotNull(abonentService.getAllAbonents());
        assertTrue(abonentService.getAllAbonents().size() > 0);
    }

    @Test
    public void getAllServices() {
        assertNotNull(serviceService.getAllServices());
        assertTrue(serviceService.getAllServices().size() > 0);
    }
}
