package service;

import dao.interfaces.ServiceAbonentDao;
import model.Abonent;
import model.Service;
import model.ServiceAbonent;
import service.interfaces.ServiceAbonentService;

import java.time.LocalDate;
import java.util.List;

public class ServiceAbonentServiceImpl implements ServiceAbonentService{

    private ServiceAbonentDao serviceAbonentDao;

    public ServiceAbonentServiceImpl(ServiceAbonentDao serviceAbonentDao) {
        this.serviceAbonentDao = serviceAbonentDao;
    }

    public List<ServiceAbonent> getAllServiceAbonents() {
        return serviceAbonentDao.getAll();
    }

    public ServiceAbonent getServiceAbonentById(Integer id)  {
        return serviceAbonentDao.getEntityById(id);
    }

    public  boolean createServiceAbonent(ServiceAbonent serviceAbonent)   {
        return serviceAbonentDao.create(serviceAbonent);
    }

    public boolean updateServiceAbonent(ServiceAbonent serviceAbonent)   {
        return serviceAbonentDao.update(serviceAbonent);
}

    public boolean deleteServiceAbonent(ServiceAbonent serviceAbonent)   {
        return serviceAbonentDao.delete(serviceAbonent);
    }

    @Override
    public List<Service> getCurrentServices(Abonent abonent, LocalDate date) {
        return serviceAbonentDao.getCurrentServices(abonent, date);
    }

}
