package com.qhit.service.impl;

import com.qhit.mapper.UsersMapping;
import com.qhit.pojo.Users;
import com.qhit.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date:2019/6/1
 * @Description:
 * @version:1.0
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapping usersMapping;

    @Override
    //@Cacheable:对当前查询的对象做缓存处理
//    @Cacheable(value="users")
    public List<Users> selectUsers() {
        List<Users> users = usersMapping.selectUsersAll();
        return users;
    }

    @Override
    public void insertUsers(Users users) {
        usersMapping.insertUsers(users);
    }


    @Override
    @Cacheable(value = "users",key = "#id")
    public List<Users> selectUsersById(Integer id) {
        List<Users> users = usersMapping.selectUsersById(id);
        return users;
    }

    @Override
    @Cacheable(value = "users",key = "#users.id")
    public List<Users> selectUsersByIdName(Users users) {
        List<Users> users1 = usersMapping.selectUsersByIdName(users);
        return users1;
    }

}
