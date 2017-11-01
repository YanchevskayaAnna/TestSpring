package service;


import dao.interfaces.UserDao;
import exception.TableIsEmptyException;
import model.Abonent;
import model.User;
import model.UserType;
import model.auxiliary.AbonentInfo;
import service.interfaces.UserService;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    public User getUserById(Integer id)  {
        return userDao.getEntityById(id);
    }

    public boolean createUser(User user)   {
        return userDao.create(user);
    }

    public boolean updateUsert(User user)   {
        return userDao.update(user);
    }

    public boolean deleteUser(User user)   {
        return userDao.delete(user);
    }

    @Override
    public List<User> getAllUsersWithUserType(UserType usertype) {
        return userDao.getAllUsersWithUserType(usertype);
    }

    @Override
    public List<Abonent> getAllAbonents(User user) throws TableIsEmptyException {
        return userDao.getAllAbonents(user);
    }

    @Override
    public List<AbonentInfo> getAllAbonentsWithInfo(User user) throws TableIsEmptyException {
        return userDao.getAllAbonentsWithInfo(user);
    }

    @Override
    public User getUserByName(String nameUser){
        return userDao.getUserByName(nameUser);
    }

}
