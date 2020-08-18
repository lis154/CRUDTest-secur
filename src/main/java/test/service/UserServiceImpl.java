package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.DAO.UserDAO;
import test.model.User;
import test.config.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl {
    @Autowired
    UsersRepo repo;

    public void save(User customer) {
        repo.save(customer);
    }

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public User get(Long id) {
        return repo.findById(Math.toIntExact(id)).get();
    }

    public void delete(User user) {
        repo.delete(user);
    }

    public int count(){
        return (int) repo.count();
    }

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    private final UserDAO userDAO;
//    @Autowired
//    public UserServiceImpl(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//
//    @Transactional
//    public List<User> allUser(int page) {
//        return userDAO.allUser(page);
//    }
//
////    @Transactional
////    public void add(User user) {
////        userDAO.add(user);
////    }
//
//    @Transactional
//    public void add(User user) {
//        entityManager.persist(user);
//    }
//
//    @Transactional
//    public void delete(User user) {
//        userDAO.delete(user);
//    }
//
//    @Transactional
//    public void edit(User user) {
//        userDAO.edit(user);
//    }
//
//    @Transactional
//    public User getById(int id) {
//        return userDAO.getById(id);
//    }
//
//    @Transactional
//    public int userCount(){
//        return userDAO.userCount();
//    }
}
