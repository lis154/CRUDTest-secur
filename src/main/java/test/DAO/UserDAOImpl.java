package test.DAO;

import org.springframework.stereotype.Repository;
import test.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDAOImpl implements UserDAO{
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, User> users = new HashMap<>();

    static {
        User user1 = new User(AUTO_ID.getAndIncrement(), "Dima", "engenear", 30);
        User user2= new User(AUTO_ID.getAndIncrement(), "Kolya", "engenear", 35);
        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
    }

    public List<User> allUser() {
        return new ArrayList<>(users.values());
    }

    public void add(User user) {
        user.setId(AUTO_ID.getAndIncrement());
        users.put(user.getId(), user);
    }

    public void delete(User user) {
        users.remove(user.getId());
    }

    public void edit(User user) {
        users.put(user.getId(), user);
    }

    public User getById(int id) {
        return users.get(id);
    }
}
