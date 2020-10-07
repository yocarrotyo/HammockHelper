package persistence;

import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.UserDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    //DECLARE THE DAO
    UserDao dao;

    /*
    Set up the tests
     */
    @BeforeEach
    void setUpTests() {
       util.Database database = util.Database.getInstance();
       database.runSQL("cleandb.sql");

       //define the DAO
        dao = new UserDao();

    }

    @Test
    void getByIdSuccess() {

        User retrievedUser = dao.getById(1);
        retrievedUser = dao.getById(1);
        assertEquals("Caroline",retrievedUser.getFname());
        assertEquals("Hughes",retrievedUser.getLname());
        retrievedUser = dao.getById(3);
        assertEquals("Arthur",retrievedUser.getFname());
        assertEquals("Read",retrievedUser.getLname());
    }

    @Test
    void saveOrUpdateSuccess() {

        String newUserLName = "Read";
        User userToUpdate = dao.getById(3);
        userToUpdate.setLname(newUserLName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(3);
        assertEquals(newUserLName,retrievedUser.getLname());

    }

    @Test
    void insertSuccess() {

        User newUser = new User("ilovebikes2020","Etan","Heller","EEHELLBOi225@yahoo.com","LETSROCK");
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("Etan",insertedUser.getFname());

    }

    @Test
    void deleteSuccess() {

        dao.delete(dao.getById(5));
        assertNull(dao.getById(5));

    }

    @Test
    void getAllSuccess() {

        List<User> users = dao.getAll();
        assertEquals(6,users.size());

    }
}
