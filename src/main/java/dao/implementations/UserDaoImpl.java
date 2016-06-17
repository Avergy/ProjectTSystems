package dao.implementations;

import dao.interfaces.UserDao;
import entity.User;

import javax.persistence.Query;
import java.util.List;


public class UserDaoImpl extends AbstractGenericDao implements UserDao {
    public UserDaoImpl() {
        super();
        setEntityClass(User.class);
    }

    public User findByLogin(String login) {
        Query query = entityManager.createQuery("Select user FROM User user WHERE user.login = :login");
        query.setParameter("login", login);
        List list = query.getResultList();
        if (list.isEmpty())
            return null;
        return (User) list.get(0);
    }

    public User findByEmail(String email) {
        Query query = entityManager.createQuery("Select user FROM User user WHERE user.email = :email");
        query.setParameter("email", email);
        List list = query.getResultList();
        if (list.isEmpty())
            return null;
        return (User) list.get(0);
    }
}
