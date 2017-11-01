package service;

import dao.interfaces.ServiceDao;
import model.Abonent;
import model.Service;
import service.interfaces.ServiceService;

import java.time.LocalDate;
import java.util.List;

public class ServiceServiceImpl implements ServiceService{

    private ServiceDao serviceDao;

    public ServiceServiceImpl(ServiceDao serviceDAO) {
        this.serviceDao = serviceDAO;
    }

    public List<Service> getAllServices() {
        return serviceDao.getAll();
    }

    public Service getServiceById(Integer id)  {
        return serviceDao.getEntityById(id);
    }

    public  boolean createService(Service service)   {
        return serviceDao.create(service);
    }

    public boolean updateService(Service service)   {
        return serviceDao.update(service);
}

    public boolean deleteService(Service service)   {
        return serviceDao.delete(service);
    }

    @Override
    public List<Abonent> getAllAbonentsWithService(Service service) {
        return serviceDao.getAllAbonentsWithService(service);
    }

    @Override
    public List<Abonent> getAllAbonentsWithServiceOnDate(Service service, LocalDate date) {
        return serviceDao.getAllAbonentsWithServiceOnDate(service, date);
    }

}
