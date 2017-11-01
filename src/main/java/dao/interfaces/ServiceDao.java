package dao.interfaces;


import model.Abonent;
import model.Service;

import java.time.LocalDate;
import java.util.List;

public interface ServiceDao extends AbstractDAO<Service> {

    public List<Abonent> getAllAbonentsWithService(Service service);
    public List<Abonent> getAllAbonentsWithServiceOnDate(Service service, LocalDate date);
}
