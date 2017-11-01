package service.interfaces;

import model.Abonent;
import model.Service;

import java.time.LocalDate;
import java.util.List;

public interface ServiceService {

    public List<Service> getAllServices();

    public Service getServiceById(Integer id);

    public  boolean createService(Service service);

    public boolean updateService(Service service);

    public boolean deleteService(Service service);

    public List<Abonent> getAllAbonentsWithService(Service service);

    public List<Abonent> getAllAbonentsWithServiceOnDate(Service service, LocalDate date);
}
