package test.DAO;

import test.model.User;

import java.util.List;

public interface UserDAO {

    List<User> allUser(int page);
    void add(User user);
    void delete(int id);
    void edit(User user);
    User getById(int id);
    public int userCount();
}
