package service;


import dao.interfaces.PaymentDao;
import model.Payment;
import model.User;
import service.interfaces.PaymentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PaymentServiceImpl implements PaymentService{

    private PaymentDao paymentDAO;

    public PaymentServiceImpl(PaymentDao paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public List<Payment> getAllPayments() {
        return paymentDAO.getAll();
    }

    public Payment getPaymentById(Integer id)  {
        return paymentDAO.getEntityById(id);
    }

    public boolean createPayment(Payment payment)   {
        return paymentDAO.create(payment);
    }

    public boolean updatePayment(Payment payment)   {
        return paymentDAO.update(payment);
    }

    public boolean deletePayment(Payment payment)   {
        return paymentDAO.delete(payment);
    }

    @Override
    public Map<User, Integer> getAveragePayment() {
        return paymentDAO.getAveragePayment();
    }

    @Override
    public Double getAllPayments(LocalDate dateFrom, LocalDate dateTo) {
        return paymentDAO.getAllPayments(dateFrom, dateTo);
    }

}
