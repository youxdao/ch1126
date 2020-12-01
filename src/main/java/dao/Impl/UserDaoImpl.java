package dao.Impl;

import dao.BaseDao;
import dao.UserDao;
import entity.User;

import java.util.List;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 10:28
 * 描述:
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int insert(User user) {
        String sql="INSERT INTO `user` (`username`,`password`,`email`) VALUES (?,?,?) ";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public int delete(Integer id) {
        String sql="DELETE FROM `user` WHERE `id` = ? ";
        return update(sql,id);
    }

    @Override
    public int update(User user) {
        String sql="UPDATE `user` SET `username` = ?,`password` = ?,`email` = ? WHERE `id`=?";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getId());
    }

    @Override
    public List<User> queryAll() {
        String sql="SELECT `id`,`username`,`password`,`email` FROM `user`";
        return queryForList(User.class,sql);
    }

    @Override
    public User queryUserById(Integer id) {
        String sql="SELECT `id`,`username`,`password`,`email` FROM `user` WHERE `id` = ? ";
        return queryForOne(User.class,sql,id);
    }

    @Override
    public User queryUserByNameAndPassword(User user) {
        String sql="SELECT `id`,`username`,`password`,`email` FROM `user` WHERE `username`=? AND `password`=? ";
        return queryForOne(User.class,sql,user.getUsername(),user.getPassword());
    }
}
