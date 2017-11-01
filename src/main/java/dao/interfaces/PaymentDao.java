package dao.interfaces;

import model.Payment;
import model.User;

import java.time.LocalDate;
import java.util.Map;

public interface PaymentDao extends AbstractDAO<Payment> {
    public Map<User, Integer> getAveragePayment();
    public Double getAllPayments (LocalDate dateFrom, LocalDate dateTo);
}
