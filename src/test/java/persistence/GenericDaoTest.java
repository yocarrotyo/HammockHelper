package persistence;

import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GenericDaoTest {

    //DECLARE THE DAO
    GenericDao roleDao;
    GenericDao siteDao;
    GenericDao userDao;
    GenericDao parkDao;
    GenericDao revDao;

    /*
    Set up the tests
     */
    @BeforeEach
    void setUpTests() {
        //define the DAO
        roleDao = new GenericDao(Role.class);
        siteDao = new GenericDao(Campsite.class);
        parkDao = new GenericDao(Park.class);
        userDao = new GenericDao(User.class);


        util.Database database = util.Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    @Test
    void getByIdSuccess() {

        Role retrievedRole = (Role) roleDao.getById(1);
        assertEquals("Camper",retrievedRole.getRolename());
        assertEquals("rockhead929",retrievedRole.getUser().getUsername());
        retrievedRole = (Role) roleDao.getById(3);
        assertEquals("Camper",retrievedRole.getRolename());
        assertEquals("itsmyworld",retrievedRole.getUser().getUsername());
    }

    @Test
    void getByIdVerifyUser() {

        Role retrievedRole = (Role) roleDao.getById(4);
        //check that the role isn't null
        assertNotNull(retrievedRole);
        //make sure you can look up stuff about the role too
        assertEquals("Arthur",retrievedRole.getUser().getFname());
        retrievedRole = (Role) roleDao.getById(6);
        assertEquals("Nicki",retrievedRole.getUser().getFname());
    }

    @Test
    void getByIdVerifyCampsite() {

        Campsite retrievedSite = (Campsite) siteDao.getById(1);
        //check that the role isn't null
        assertNotNull(retrievedSite);
        //make sure you can look up stuff about the site too
        assertEquals(1,retrievedSite.getCapacity());
        retrievedSite = (Campsite) siteDao.getById(2);
        assertEquals(0,retrievedSite.getCapacity());
    }

    @Test
    void saveOrUpdateSuccess() {

        String newRolename = "Admin";
        Role roleToUpdate = (Role) roleDao.getById(3);
        roleToUpdate.setRolename(newRolename);
        roleDao.saveOrUpdate(roleToUpdate);
        Role retrievedRole = (Role) roleDao.getById(3);
        assertEquals(newRolename,retrievedRole.getRolename());

    }


    @Test
    void insertSuccess() {

        //grab a user to add for the new role
        GenericDao userDao = new GenericDao(User.class);
        User user = (User) userDao.getById(1); //lets add the admin role to caroline hughes

        Role newRole = new Role("Admin",user);
        user.addRole(newRole);
        int id = roleDao.insert(newRole);
        assertNotEquals(0,id);
        Role insertedRole = (Role) roleDao.getById(id);
        assertNotNull(insertedRole);

        //check that the users set on the
        assertEquals("Caroline",insertedRole.getUser().getFname());
        assertEquals("Admin",insertedRole.getRolename());

    }

    @Test
    void insertReviewSuccess() {

        //grab a user to add for the new role
        revDao = new GenericDao(Review.class);

        Review newReview = new Review();
        newReview.setCapacity(1);
        newReview.setSiteno("13");
        newReview.setConfidence(0);
        newReview.setParkid(5);
        int id = roleDao.insert(newReview);
        assertNotEquals(0,id);
        Review insertedReview = (Review) revDao.getById(id);
        assertNotNull(insertedReview);

        assertEquals(5,insertedReview.getParkid());

    }


    @Test
    void deleteSuccess() {

        roleDao.delete(roleDao.getById(5));
        assertNull(roleDao.getById(5));

    }

    @Test
    void getAllSuccess() {

        List<Role> roles = roleDao.getAll();
        assertEquals(6,roles.size());

    }

    @Test
    void getByPropertySuccess() {

        List<Park> retrievedParks = parkDao.getByProperty("parkname","Blue Mound");
        Park onePark = retrievedParks.get(0);
        String name = onePark.getParkname();
        assertEquals("Blue Mound",name);

    }

    @Test
    void getBy2PropertiesLikeAndEqSuccess() {

        String siteno = String.valueOf('2');
        int parkid = 6;
        List<Campsite> siteList = siteDao.getBy2PropertiesLikeAndEq("siteno",siteno,"parkid",parkid);
        Campsite oneSite = siteList.get(0);
        int capacity = oneSite.getCapacity();
        assertEquals(1,capacity);

    }

    @Test
    void getBy2PropertiesEqAndGtSuccess() {

        int parkid = 6;
        List<Campsite> siteList = siteDao.getBy2PropertiesEqAndGt("parkid",parkid,"capacity","0");
        Campsite oneSite = siteList.get(1);
        int capacity = oneSite.getCapacity();
        assertEquals(2,capacity);

    }
}
