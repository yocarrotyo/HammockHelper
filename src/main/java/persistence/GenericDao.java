package persistence;

import entity.Park;
import entity.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.List;

/** A generic dao */
public class GenericDao<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new generic DAO
     * @param type entity type, for example, campsite
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    private Session getSession() {

        return SessionFactoryProvider.getSessionFactory().openSession();

    }

    public <T>T getById(int id) {

        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;

    }

    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public List<T> getAll() {
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();

    }

    /*
     * Get entity using "like" operator on just one property/column
     *
     * @param propertyName the property to search on
     * @param value         the value for the property
     */
    public List<T> getByProperty(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for thing with {} like {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);

        //create an expression for each of the properties to check against
        Expression<String> propertyPath = root.get(propertyName);
        logger.debug("the value of propertyPath is: ",  propertyPath);
        //build a where clause for the query
        Predicate queryRestriction = builder.like(propertyPath,"%" + value + "%");

        query.where(queryRestriction);

        List<T> entities = session.createQuery( query ).getResultList();
        session.close();
        return entities;
    }
    /**
     * Get entity by two different properties (like) using AND logic
     * sample usage: getByPropertyLike("lastname", "C")
     *
     * @param propertyName1 the first property to search on
     * @param value1        the value for property 1
     * @param propertyName2 an additional property to search on
     * @param value2        the value for property 2
     * @return the by property like
     */
    public List<T> getBy2PropertiesLike(String propertyName1, String value1, String propertyName2, String value2) {
        Session session = getSession();

        logger.debug("Searching for thing with {} like {} and {} like {}",  propertyName1, value1, propertyName2, value2);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);

        //create an expression for each of the properties to check against
        Expression<String> propertyPath1 = root.get(propertyName1);
        Expression<String> propertyPath2 = root.get(propertyName2);

        //build a compound where clause for the query
        Predicate queryRestriction = builder.like(propertyPath1,"%" + value1 + "%");
        queryRestriction = builder.and(queryRestriction, builder.like(propertyPath2,"%" + value1 + "%"));

        query.where(queryRestriction);

        List<T> entities = session.createQuery( query ).getResultList();
        session.close();
        return entities;
    }

    /*
     *Get entity using two properties where one is a string column and the other is a number
     * @param propertyName1 the first property to search on. This should be the string column.
     * @param value1        the value for property 1
     * @param propertyName2 an additional property to search on. This should be the number column.
     * @param value2        the value for property 2
     * @return the by property like
     */
    public List<T> getBy2PropertiesLikeAndEq(String propertyName1, String value1, String propertyName2, int value2) {
        Session session = getSession();

        logger.debug("Searching for thing with {} like {} and {} like {}",  propertyName1, value1, propertyName2, value2);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);

        //create an expression for each of the properties to check against
        Expression<String> propertyPath1 = root.get(propertyName1);
        Expression<String> propertyPath2 = root.get(propertyName2);

        //build a compound where clause for the query
        Predicate queryRestriction = builder.like(propertyPath1,"%" + value1 + "%");
        queryRestriction = builder.and(queryRestriction, builder.equal(propertyPath2,"%" + value1 + "%"));

        query.where(queryRestriction);

        List<T> entities = session.createQuery( query ).getResultList();
        session.close();
        return entities;

    }

    public int insert(Role newRole) {

        return 0;
    }


    //save or update

    //insert

}

