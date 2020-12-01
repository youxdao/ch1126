package service;

import entity.User;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 10:50
 * 描述:
 */
public interface UserService {
    int register(User user);

    User login(User user);
}
