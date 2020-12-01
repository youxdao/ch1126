package dao.Impl;

import dao.BaseDao;
import dao.MsgDao;
import entity.Msg;

import java.util.List;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 10:28
 * 描述:
 */
public class MagDaoImpl extends BaseDao implements MsgDao {
    @Override
    public int insert(Msg msg) {
        String sql = "INSERT INTO `msg` (`fromUid`,`toUid`,`mTitle`,`mContent`,`readFlag`,`createTime`) VALUES(?,?,?,?,?,?) ";
        return update(sql, msg.getFromUId(), msg.getToUId(), msg.getMtitle(), msg.getmContent(), msg.getReadFlag(), msg.getCreateTime());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM `msg` WHERE `id`=? ";
        return update(sql, id);
    }

    @Override
    public int update(Msg msg) {
        String sql = "UPDATE SET `fromUid`=?,`toUid`=?,`mTitle`=?,`mContent`=?,`readFlag`=?,`createTime`=? WHERE `id` =? ";
        return update(sql, msg.getFromUId(), msg.getToUId(), msg.getMtitle(), msg.getmContent(), msg.getReadFlag(), msg.getCreateTime(), msg.getId());
    }

    @Override
    public List<Msg> queryAll() {
        String sql = "SELECT `id`,`fromUid`,`toUid`,`mTitle`,`mContent`,`readFlag`,`createTime` FROM `msg` ";
        return queryForList(Msg.class,sql);
    }

    @Override
    public Msg queryMsgById(Integer id) {
        String sql = "SELECT `id`,`fromUid`,`toUid`,`mTitle`,`mContent`,`readFlag`,`createTime` FROM `msg` WHERE `id`=? ";
        return queryForOne(Msg.class,sql,id);
    }

    @Override
    public List<Msg> queryMsgByToUid(Integer id) {
        String sql = "SELECT `id`,`fromUid`,`toUid`,`mTitle`,`mContent`,`readFlag`,`createTime` FROM `msg` WHERE `toUid`=? ";
        return queryForList(Msg.class,sql,id);
    }
}
