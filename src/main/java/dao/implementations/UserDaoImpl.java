package dao.implementations;

import Util.EntityManagerUtil;
import dao.interfaces.UserDao;
import entity.User;
import exceptions.NotFoundInDBException;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


public class UserDaoImpl extends AbstractGenericDao implements UserDao {

    final static Logger logger = Logger.getLogger(UserDaoImpl.class.getName());

    public UserDaoImpl() {
        super();
        setEntityClass(User.class);
    }

    public User findByLogin(String login) throws NotFoundInDBException {
        logger.info("Find user by login in the DB...");
        User user;
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("Select user FROM User user WHERE user.login = :login");
        query.setParameter("login", login);
        try{
            user = (User) findOne(query);
            logger.info("User has been found in the DB.");
        } catch (NoResultException e)
        {
            e.printStackTrace();
            logger.error("User has not been found in the DB.");
            throw new NotFoundInDBException();
        }finally {

            entityManager.close();
        }

        return user;
    }

}
