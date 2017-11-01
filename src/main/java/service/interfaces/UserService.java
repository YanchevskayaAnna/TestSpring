package service.interfaces;

import exception.TableIsEmptyException;
import model.Abonent;
import model.User;
import model.UserType;
import model.auxiliary.AbonentInfo;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(Integer id);

    public boolean createUser(User user);

    public boolean updateUsert(User user);

    public boolean deleteUser(User user);

    public List<User> getAllUsersWithUserType(UserType usertype);

    public List<Abonent> getAllAbonents(User user) throws TableIsEmptyException;

    public List<AbonentInfo> getAllAbonentsWithInfo(User user) throws TableIsEmptyException;

    public User getUserByName(String nameUser);
}
