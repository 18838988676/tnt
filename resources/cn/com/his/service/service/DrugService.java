package cn.com.his.service.service;

import java.util.List;

 
import cn.com.his.core.vo.Drug;
import cn.com.his.core.vto.DrugVo;

public interface DrugService extends ABaseService<Drug, Integer>{
	/**
	 * 分页多条件查询药品
	 * @param t
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	public List<DrugVo> manyConditionsFind(DrugVo t,int currentpage,int pagesize);
	
	/**
	 * 模糊查询药品
	 * @param contant
	 * @return
	 */
	public List<DrugVo> vagueFind(String contant);
	
	/**
	 * 修改库存
	 * @param t
	 * @return
	 */
	public int updateInventoryquantity(Drug t);
}
