package cn.com.his.dao.baseDaoImpl;

import cn.com.his.core.vo.Useunit;

public interface UseunitMapper {
	/**
	 * 添加使用单位
	 * @param record
	 * @return
	 */
	int insert(Useunit record);
	
	/**
	 * 查询第一条使用单位的数据
	 * @return
	 */
    Useunit findOne();
    
    /**
     * 修改使用单位
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Useunit record);
}