package dao;

import entity.User;

import java.util.List;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 10:27
 * 描述:
 */
public interface UserDao {
    int insert(User user);

    int delete(Integer id);

    int update(User user);

    List<User> queryAll();

    User queryUserById(Integer id);

    User queryUserByNameAndPassword(User user);
}
