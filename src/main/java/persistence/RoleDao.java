package persistence;

import entity.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.SessionFactoryProvider;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RoleDao {


    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets role by id.
     *
     * @param id the id
     * @return the by id
     */
    public Role getById(int id) {

        Session session = sessionFactory.openSession();
        Role role = session.get(Role.class, id);
        session.close();
        return role;
    }

    /**
     * Save or update a role
     *
     * @param role the role to update
     */
    public void saveOrUpdate(Role role) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(role);
        transaction.commit();
        session.close();

    }


    /**
     * Insert int.
     *
     * @param role the role
     * @return the int
     */
    public int insert(Role role) {

        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(role); //update the id to whatever value the database gave it.
        transaction.commit();
        session.close();
        return id;

    }

    /**
     * Delete.
     *
     * @param role the role
     */
    public void delete(Role role) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(role);
        transaction.commit();
        session.close();

    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<Role> getAll() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Role> query = builder.createQuery(Role.class);
        Root<Role> root = query.from(Role.class);
        List<Role> books = session.createQuery(query).getResultList();
        session.close();
        return books;

    }
}

