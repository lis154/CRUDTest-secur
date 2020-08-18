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
       // List<User> resultList = query.getResultList();
        List<User> resultList = query.setFirstResult(10*(page-1)).setMaxResults(10).getResultList();
        return resultList;
    }

    @Transactional
    @Override
    public void add(User user) {
        getEntityManager().persist(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        EntityManager em =  getEntityManager();
        User user = em.find(User.class, id);
        getEntityManager().remove(user);
    }

    @Transactional
    @Override
    public void edit(User user) {
        getEntityManager().merge(user);
    }

    @Transactional
    @Override
    public User getById(int id) {
        return getEntityManager().find(User.class, id);
    }

    @Transactional
    @Override
    public int userCount() {
        Query query = entityManager.createQuery("SELECT COUNT(*) FROM User " );

        Query query1 = entityManager.createQuery("select count(ut) From User ut");
        int rez = ((Number) query.getSingleResult()).intValue();
        System.out.println(rez);
        return rez;
    }


}
