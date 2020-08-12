package test.DAO;

import test.model.User;

import java.util.List;

public interface UserDAO {

    List<User> allUser();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);
}
