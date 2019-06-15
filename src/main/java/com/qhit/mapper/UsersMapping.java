package com.qhit.mapper;

import com.qhit.pojo.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Date:2019/6/1
 * @Description:
 * @version:1.0
 */
@Repository
public interface UsersMapping {
    List<Users> selectUsersAll();

    List<Users> selectUsersById(Integer id);
    void insertUsers(Users users);

    List<Users> selectUsersByIdName(Users users);
}
