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
        retrievedUser = dao.getById(4);
    }

    @Test
    void saveOrUpdateSuccess() {

        String newUserLName = "McPherson";
        User userToUpdate = dao.getById(3);
        userToUpdate.setLname(newUserLName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(3);
        assertEquals(newUserLName,retrievedUser.getLname());

    }

    @Test
    void insertSuccess() {

        User newUser = new User("chihiro963","Caroline","Hughes","hughe297@gmail.com","5Mith5");
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = dao.getById(id);
        assertEquals("Caroline",insertedUser.getFname());

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
