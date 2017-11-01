package service;


import dao.interfaces.AbonentDao;
import model.Abonent;
import service.interfaces.AbonentService;

import java.time.LocalDate;
import java.util.List;

public class AbonentServiceImpl implements AbonentService{

    private AbonentDao abonentDAO;

    public AbonentServiceImpl(AbonentDao abonentDAO) {
        this.abonentDAO = abonentDAO;
    }

    public List<Abonent> getAllAbonents()    {
        return abonentDAO.getAll();
    }

    public Abonent getAbonentById(Integer id)  {
        return abonentDAO.getEntityById(id);
    }

    public boolean createAbonent(Abonent abonent)   {
        return abonentDAO.create(abonent);
    }

    public boolean updateAbonent(Abonent abonent)   {
        return abonentDAO.update(abonent);
    }

    public boolean deleteAbonent(Abonent abonent)   {
        return abonentDAO.delete(abonent);
    }

    @Override
    public int calculateBalance(Abonent abonent, LocalDate date) {
        return abonentDAO.calculateBalance(abonent, date);
    }

    @Override
    public int calculateDebts(Abonent abonent, LocalDate date) {
        return abonentDAO.calculateDebts(abonent, date);
    }

    @Override
    public Abonent getAbonentByName(String nameAbonent) {
        return abonentDAO.getAbonentByName(nameAbonent);
    }

}
