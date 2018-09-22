package cn.com.his.dao.baseDao;

import java.util.List;

import cn.com.his.core.vo.Viptype;

public interface ViptypeMapper {
    /**
     * 查询会员类别
     * @return
     */
    List<Viptype> findAll();
}