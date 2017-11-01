package service;


import dao.interfaces.CallDao;
import model.Abonent;
import model.Call;
import model.User;
import service.interfaces.CallService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class CallServiceImpl implements CallService{

    private CallDao callDAO;

    public CallServiceImpl(CallDao callDAO) {
        this.callDAO = callDAO;
    }

    public List<Call> getAllCalls() {
        return callDAO.getAll();
    }

    public Call getCallById(Integer id)  {
        return callDAO.getEntityById(id);
    }

    public boolean createCall(Call call)   {
        return callDAO.create(call);
    }

    public boolean updateCall(Call call)   {
        return callDAO.update(call);
    }

    public boolean deleteCall(Call call)   {
        return callDAO.delete(call);
    }

    public Map<Abonent, Integer> getAverageDuration(){
        return callDAO.getAverageDuration();
    }

    public Map<Abonent, Integer> getAverageDuration(LocalDate dateFrom, LocalDate dateTo){
        return callDAO.getAverageDuration(dateFrom, dateTo);
    }

    public Map<User, Integer> getAverageDurationUser(){
        return callDAO.getAverageDurationUser();
    }

    public Map<User, Integer> getAverageDurationUser(LocalDate dateFrom, LocalDate dateTo){
        return callDAO.getAverageDurationUser(dateFrom, dateTo);
    }

    public Double getAverageDuration(Abonent abonent){
        return  callDAO.getAverageDuration(abonent);
    }
    public Double getAverageDuration(Abonent abonent, LocalDate dateFrom, LocalDate dateTo){
        return  callDAO.getAverageDuration(abonent, dateFrom, dateTo);
    }
}
