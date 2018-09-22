package cn.com.his.service.service;

import java.util.List;

 
import cn.com.his.core.vo.Patienttype;

public interface PatienttypeService extends ABaseService<Patienttype, Integer>{
	/**
	 * 分页查询病人类别
	 * @param contant
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	List<Patienttype> vagueFind(String contant,int currentpage,int pagesize);
}
