package cn.com.his.service.service;

import java.util.List;

import cn.com.his.core.vo.Chargetype;

public interface ChargetypeService extends ABaseService<Chargetype, Integer>{
	/**
	 * 分页查询收费类别
	 * @param contant
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	public List<Chargetype> vagueFind(String contant,int currentpage,int pagesize);
}
