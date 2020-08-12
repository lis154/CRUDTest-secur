package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import test.DAO.UserDAO;
import test.DAO.UserDAOImpl;
import test.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;
    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> allUser() {
        return userDAO.allUser();
    }

    public void add(User user) {
        userDAO.add(user);
    }

    public void delete(User user) {
        userDAO.delete(user);
    }

    public void edit(User user) {
        userDAO.edit(user);
    }

    public User getById(int id) {
        return userDAO.getById(id);
    }
}
