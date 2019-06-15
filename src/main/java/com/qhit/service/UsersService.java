package com.qhit.service;

import com.qhit.pojo.Users;

import java.util.List;

/**
 * @Date:2019/6/1
 * @Description:
 * @version:1.0
 */
public interface UsersService {
    List<Users> selectUsers();
    void insertUsers(Users users);
    List<Users> selectUsersById(Integer id);
    List<Users> selectUsersByIdName(Users users);
}
