package cn.com.his.service.service;

import java.util.List;

 

import cn.com.his.core.vo.Registertype;
import cn.com.his.core.vo.solr.RegistertypeSolr;

public interface RegistertypeService extends ABaseService<Registertype, Integer>{
	/**
	 * 查询前三个挂号类别
	 * @return
	 */
	public List<Registertype> findBefor();
	
	/**
	 * 分页查询挂号类别
	 * @param contant
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	public List<RegistertypeSolr> vagueFind(String contant,int currentpage,int pagesize);
}
