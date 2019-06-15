package com.qhit.test;

import com.qhit.App;
import com.qhit.mapper.UsersMapping;
import com.qhit.pojo.Users;
import com.qhit.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Date:2019/6/1
 * @Description:
 * @version:1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class UsersTest {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersMapping usersMapping;

    @Test
    public void selectUsers() {
        List<Users> users = usersMapping.selectUsersAll();
        for (Users user : users) {
            System.out.println(user.getName());
        }
    }

    @Test
    public void selectUserList() {
        List<Users> users = usersService.selectUsers();
        for (Users user : users) {
            System.out.println(user.getName());
        }

        usersService.selectUsers();
    }
    @Test
    public void selectUser() {
        System.out.println("第一次查询");
        List<Users> users = usersService.selectUsersById(1);
        for (Users user : users) {
            System.out.println(user.getName());
        }
        System.out.println("第二次查询");
        List<Users> users1 = usersService.selectUsersById(2);
        for (Users user : users1) {
            System.out.println(user.getName());
        }
        System.out.println("第三次查询");
        List<Users> users2 = usersService.selectUsersById(1);
        for (Users user : users2) {
            System.out.println(user.getName());
        }

    }

    @Test
    public void selectUserIdName() {
        System.out.println("第一次查询");
        List<Users> users = usersService.selectUsersByIdName(new Users(4,"asdsda",null));
        System.out.println(users.size());
        for (Users user : users) {
            System.out.println(user.getId());
        }
        System.out.println("第二次查询");
        List<Users> users1 = usersService.selectUsersByIdName(new Users(2,"asdsda",null));
        System.out.println(users1.size());
        for (Users user : users1) {
            System.out.println(user.getId());
        }
        System.out.println("第三次查询");
        List<Users> users2 = usersService.selectUsersByIdName(new Users(3,"asdsda",null));
        System.out.println(users2.size());
        for (Users user : users2) {
            System.out.println(user.getId());
        }

    }
}
