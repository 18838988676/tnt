package cn.com.his.service.service;

import java.util.List;

import cn.com.his.core.vo.Charge;
import cn.com.his.core.vto.ChargeVo;

public interface ChargeService {
	/**
	 * 查询最后一个收费
	 * @return
	 */
	public ChargeVo findLast();
	
	/**
	 * 收费
	 * @param t
	 * @return
	 */
	public int add(Charge t);
	
	/**
	 * 分页多条件查询收费历史
	 * @param t
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	public List<ChargeVo> manyConditionsFindHistory(ChargeVo t,int currentpage,int pagesize);
	
	/**
	 * 删除收费历史
	 * @param id
	 * @return
	 */
	public int delete(int id);
}
