package service.interfaces;

import model.Abonent;
import model.Service;
import model.ServiceAbonent;

import java.time.LocalDate;
import java.util.List;

public interface ServiceAbonentService {

    public List<ServiceAbonent> getAllServiceAbonents();

    public ServiceAbonent getServiceAbonentById(Integer id);

    public  boolean createServiceAbonent(ServiceAbonent serviceAbonent);

    public boolean updateServiceAbonent(ServiceAbonent serviceAbonent) ;

    public boolean deleteServiceAbonent(ServiceAbonent serviceAbonent)  ;

    public List<Service> getCurrentServices(Abonent abonent, LocalDate date);
}
