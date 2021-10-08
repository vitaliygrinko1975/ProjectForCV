package ua.hrynko.project.servise;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ua.hrynko.projectcv.config.AppConfig;
import ua.hrynko.projectcv.db.models.Roles;
import ua.hrynko.projectcv.db.models.Users;
import ua.hrynko.projectcv.servise.interfaces.UserService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class UserServiceImpTest {
    @Autowired
    UserService userService;


    @Test
    public void testGetById(){

        Roles role = new Roles();
        role.setId(2);
        role.setName("user");

        Users expected = new Users();

        expected.setId(2);
        expected.setLogin("client");
        expected.setPassword("client");
        expected.setFirstName("Ivan");
        expected.setLastName("Ivanov");
        expected.setRole(role);


        Users actual = userService.getById(expected.getId());


        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testGetAll(){
        //given
        List<Users> expected = new ArrayList<>();

        Roles role = new Roles();
        role.setId(2);
        role.setName("user");

        Users user = new Users();
        user.setId(2);
        user.setLogin("admin");
        user.setPassword("admin");
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setRole(role);


        Users user1 = new Users();
        user.setId(2);
        user1.setLogin("client");
        user1.setPassword("client");
        user1.setFirstName("Petr");
        user1.setLastName("Petrov");
        user1.setRole(role);

        expected.add(user);
        expected.add(user1);


        //when
        List<Users> actual = userService.getAll();

        //then
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}