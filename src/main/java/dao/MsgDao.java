package dao;

import entity.Msg;

import java.util.List;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 10:27
 * 描述:
 */
public interface MsgDao {
    int insert(Msg msg);

    int delete(Integer id);

    int update(Msg msg);

    List<Msg> queryAll();

    Msg queryMsgById(Integer id);

    List<Msg> queryMsgByToUid(Integer id);
}
