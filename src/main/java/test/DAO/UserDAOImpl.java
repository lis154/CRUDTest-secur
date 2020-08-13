package test.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.model.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<User> allUser() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
}
