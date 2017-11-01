package dao.interfaces;

import model.Abonent;
import model.Call;
import model.User;

import java.time.LocalDate;
import java.util.Map;

public interface CallDao extends AbstractDAO<Call> {

    public Double getAverageDuration(Abonent abonent);
    public Double getAverageDuration(Abonent abonent, LocalDate dateFrom, LocalDate dateTo);
    public Map<Abonent, Integer> getAverageDuration();
    public Map<Abonent, Integer> getAverageDuration(LocalDate dateFrom, LocalDate dateTo);
    public Map<User, Integer> getAverageDurationUser();
    public Map<User, Integer> getAverageDurationUser(LocalDate dateFrom, LocalDate dateTo);

}
