package service.Impl;

import dao.Impl.MagDaoImpl;
import dao.MsgDao;
import entity.Msg;
import service.MsgService;

import java.util.List;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 14:55
 * 描述:
 */
public class MsgServiceImpl implements MsgService {
    MsgDao msgDao=new MagDaoImpl();
    @Override
    public List<Msg> queryMsgByToUid(Integer id) {
        return msgDao.queryMsgByToUid(id);
    }

    @Override
    public Msg queryMsgById(Integer id) {
        return msgDao.queryMsgById(id);
    }

    @Override
    public int insert(Msg msg) {
        return msgDao.insert(msg);
    }

    @Override
    public int delete(Integer id) {
        return msgDao.delete(id);
    }

    @Override
    public int update(Msg msg) {
        return msgDao.update(msg);
    }
}
