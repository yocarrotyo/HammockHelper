package persistence;

import entity.Role;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


    class RoleDaoTest {

        //DECLARE THE DAO
        RoleDao dao;

        /*
        Set up the tests
         */
        @BeforeEach
        void setUpTests() {
            util.Database database = util.Database.getInstance();
            database.runSQL("cleandb.sql");

            //define the DAO
            dao = new RoleDao();

        }

        @Test
        void getByIdSuccess() {

            Role retrievedRole = dao.getById(1);
            assertEquals("Camper",retrievedRole.getRolename());
            assertEquals("rockhead929",retrievedRole.getUsername());
            retrievedRole = dao.getById(3);
            assertEquals("Camper",retrievedRole.getRolename());
            assertEquals("itsmyworld",retrievedRole.getUsername());
        }

        @Test
        void getByIdVerifyUser() {

            Role retrievedRole = dao.getById(1);
            //check that the role isn't null
            assertNotNull(retrievedRole);
            //make sure you can look up stuff about the user too
            assertEquals("John",retrievedRole.getUsername().getFname());
            retrievedRole = dao.getById(3);
            assertEquals("itsmyworld",retrievedRole.getUsername().getFname());
        }

        @Test
        void saveOrUpdateSuccess() {

            String newRolename = "Admin";
            Role roleToUpdate = dao.getById(3);
            roleToUpdate.setRolename(newRolename);
            dao.saveOrUpdate(roleToUpdate);
            Role retrievedRole = dao.getById(3);
            assertEquals(newRolename,retrievedRole.getRolename());

        }

        @Test
        void insertSuccess() {

            //grab a user to add for the new role
            UserDao userDao = new UserDao();
            User user = userDao.getById(1); //lets add the admin role to caroline hughes
            Role newRole = new Role("Admin",user);
            user.addRole(newRole);
            int id = dao.insert(newRole);
            assertNotEquals(0,id);
            Role insertedRole = dao.getById(id);
            assertNotNull(insertedRole);
            assertEquals("Caroline",insertedRole.getUsername().getFname());
            assertEquals("Admin",insertedRole.getRolename());

        }

        @Test
        void deleteSuccess() {

            dao.delete(dao.getById(5));
            assertNull(dao.getById(5));

        }

        @Test
        void getAllSuccess() {

            List<Role> roles = dao.getAll();
            assertEquals(6,roles.size());

        }
    }
