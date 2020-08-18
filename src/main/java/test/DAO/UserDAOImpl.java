package test.DAO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
@Transactional
public class UserDAOImpl implements UserDAO{

    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public List<User> allUser(int page) {
        Query query = getEntityManager().createQuery("select c from User c");
        List<User> resultList = query.getResultList();
        return resultList;
    }

    @Transactional
    @Override
    public void add(User user) {
        getEntityManager().persist(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        getEntityManager().remove(user);
    }

    @Transactional
    @Override
    public void edit(User user) {

    }

    @Transactional
    @Override
    public User getById(int id) {
        return getEntityManager().find(User.class, id);
    }

    @Transactional
    @Override
    public int userCount() {
        Query query = entityManager.createNativeQuery("SELECT COUNT(*) FROM User " );
        int rez = query.getFirstResult();
        return rez;
    }

//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//
//    public List<User> allUser(int page) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("from User").setFirstResult(10*(page-1)).setMaxResults(10).list();
//    }
//
//    public void add(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.persist(user);
//    }
//
//    public void delete(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(user);
//    }
//
//    public void edit(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(user);
//    }
//
//    public User getById(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(User.class, id);
//    }
//
//    public int userCount(){
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("select count(*) from User", Number.class).getSingleResult().intValue();
//    }
}
