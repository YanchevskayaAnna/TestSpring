package servlets;
import dao.SQLDao.*;
import exception.TableIsEmptyException;
import model.*;
import service.*;
import service.interfaces.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = {"/showallabonents"})
public class UserServlet extends HttpServlet {


    private  AbonentService abonentService;
    private  ServiceService serviceService;
    private  UserService userService;
    private  ServiceAbonentService serviceAbonentService;
    private  CallService callService;
    private  PaymentService paymentService;
    private  EntityManagerFactory emFactory;

    @Override
    public void init() throws ServletException {
        emFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        userService = new UserServiceImpl(new SQLUserDaoImpl(emFactory));
        abonentService = new AbonentServiceImpl(new SQLAbonentDaoImpl(emFactory));
        serviceService = new ServiceServiceImpl(new SQLServiceDaoImpl(emFactory));
        serviceAbonentService = new ServiceAbonentServiceImpl(new SQLServiceAbonentDaoImpl(emFactory));
        callService = new CallServiceImpl(new SQLCallDaoImpl(emFactory));
        paymentService = new PaymentServiceImpl(new SQLPaymentDaoImpl(emFactory));
        initDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("abonents", userService.getAllAbonentsWithInfo(userService.getUserByName("user1")));
            req.getRequestDispatcher("WEB-INF/pages/showallabonents.jsp").forward(req, resp);
        } catch (TableIsEmptyException e) {
            e.printStackTrace();
            req.setAttribute("errorTitle", "ERROR");
            req.setAttribute("errorMsg", e);
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
        }
    }

    public void initDB(){

        List<Service> serviceList = new ArrayList<>(Arrays.asList(
                new Service("Call", 100),
                new Service("Inet", 50),
                new Service("Call&Inet", 110)));

        serviceList.stream().forEach(service -> {
            serviceService.createService(service);
        });

        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("user1", "1qaz2wsx3edc", UserType.USER),
                new User("user2", "1qaz2wsx3edc", UserType.USER),
                new User("admin", "1qaz2wsx3edc", UserType.ADMIN)));

        userList.stream().forEach(user -> {
            userService.createUser(user);
            //Abonent
            Abonent abonent = new Abonent("abonent_" + user.getLogin(), user);
            abonentService.createAbonent(abonent);

            //Calls
            Call call1 = new Call(abonent, CallType.IN, "+380672173946", 32, LocalDate.of(2017,1,1));
            callService.createCall(call1);
            Call call2 = new Call(abonent, CallType.OUT, "+380672173946", 32, LocalDate.of(2017,1,1));
            callService.createCall(call2);

            //Payments
            Payment payment1 = new Payment(abonent, LocalDate.of(2017,2,1), 100);
            paymentService.createPayment(payment1);

            Payment payment2 = new Payment(abonent,  LocalDate.of(2017,3,1), 100);
            paymentService.createPayment(payment2);

            //Servises
            serviceList.stream().forEach(service -> {
                ServiceAbonent serviceAbonent = new ServiceAbonent(service, abonent, LocalDate.of(2017,1,1), null);
                serviceAbonentService.createServiceAbonent(serviceAbonent);});

        });
    }

}

