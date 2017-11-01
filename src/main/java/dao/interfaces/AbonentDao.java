package dao.interfaces;

import model.Abonent;

import java.time.LocalDate;

public interface AbonentDao extends AbstractDAO<Abonent> {

    int calculateBalance(Abonent abonent, LocalDate date);

    public int calculateDebts(Abonent abonent, LocalDate date);

    public Abonent getAbonentByName(String nameAbonent);
}
