package cn.com.his.service.service;

import java.util.List;

import cn.com.his.core.vo.Attributedetail;

public interface AttributedetailService extends ABaseService<Attributedetail, Integer>{
	/**
	 * 根据属性id查询属性明细
	 * @param id
	 * @return
	 */
	public List<Attributedetail> findByAttributeid(int id);
	
	/**
	 * 分页查询属性明细
	 * @param contant
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	public List<Attributedetail> vagueFind(String contant,int currentpage,int pagesize);
}
