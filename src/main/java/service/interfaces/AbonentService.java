package service.interfaces;

import model.Abonent;

import java.time.LocalDate;
import java.util.List;

public interface AbonentService {

    public List<Abonent> getAllAbonents();

    public Abonent getAbonentById(Integer id);

    public boolean createAbonent(Abonent abonent);

    public boolean updateAbonent(Abonent abonent);

    public boolean deleteAbonent(Abonent abonent);

    public int calculateBalance (Abonent abonent, LocalDate date);

    public int calculateDebts(Abonent abonent, LocalDate date);

    public Abonent getAbonentByName(String nameAbonent);

}
