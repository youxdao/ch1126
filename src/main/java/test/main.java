package test;

import dao.Impl.UserDaoImpl;
import dao.UserDao;
import entity.User;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 10:42
 * 描述:
 */
public class main {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void insert() {
        User user = new User("user1", "123", "123@qq.com");
        userDao.insert(user);
    }

    @Test
    public void update() {
        User user = new User(1, "user1", "456", "123@qq.com");
        userDao.update(user);
    }

    @Test
    public void delete() {
        userDao.delete(1);
    }

    @Test
    public void queryForOne() {
        User qUser = userDao.queryUserById(2);
        System.out.println(qUser.toString());
    }

    @Test
    public void queryAll() {
        List<User> qList = userDao.queryAll();
        System.out.println(qList.toString());
    }

    @Test
    public void login() {

        User user = userDao.queryUserByNameAndPassword(new User("user", "123", null));
        System.out.println(user.toString());
    }

    @Test
    public void test(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
