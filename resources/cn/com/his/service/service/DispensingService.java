package cn.com.his.service.service;

import java.util.List;

import cn.com.his.core.vo.Dispensing;
import cn.com.his.core.vto.DispensingVo;

public interface DispensingService {
	/**
	 * 分页多条件查询发药信息
	 * @param t 
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	public List<DispensingVo> manyConditionsFind(DispensingVo t,int currentpage,int pagesize);
	
	/**
	 * 添加发药记录
	 * @param t
	 * @return
	 */
	public int add(Dispensing t);
	
	/**
	 * 修改发药状态
	 * @param t
	 * @return
	 */
	public int updatedispensingstatus(Dispensing t);
	
	/**
	 * 发退药
	 * @param rid
	 * @return
	 */
	public Dispensing findByRegisterId(int rid);
	
	/**
	 * 删除发药信息
	 * @param id
	 * @return
	 */
	public int delete(int id);
}
