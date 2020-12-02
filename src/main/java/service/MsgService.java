package service;

import entity.Msg;

import java.util.List;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 14:50
 * 描述:
 */
public interface MsgService {

    List<Msg> queryMsgByToUid(Integer id);

    Msg queryMsgById(Integer id);

    int insert(Msg msg);

    int delete(Integer id);

    int update(Msg msg);
}
