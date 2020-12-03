package service.Impl;

import dao.Impl.UserDaoImpl;
import dao.UserDao;
import entity.User;
import service.UserService;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 10:54
 * 描述:
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    //注册
    @Override
    public int register(User user) {
        return userDao.insert(user);
    }

    //登录
    @Override
    public User login(User user) {
        return userDao.queryUserByNameAndPassword(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public User queryUserByEmail(String email) {
        return userDao.queryUserByEmail(email);
    }

    @Override
    public User queryUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }


}
