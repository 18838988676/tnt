package cn.com.his.service.service;

import java.util.List;

 
import cn.com.his.core.vo.Department;

public interface DepartmentService extends ABaseService<Department, Integer>{
	/**
	 * 查询是否允许挂号
	 * @return
	 */
	public List<Department> findIsRgs();
	
	/**
     * 根据职务id查询科室部门
     * @param id
     * @return
     */
	public List<Department> findDptByPid(Integer id);
	
	/**
     * 查询最后一个部门的编号
     * @return
     */
    public Department findLastCode();
	
	/**
	 * 多条件模糊查询科室
	 * @param contant
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	public List<Department> vagueFind(String contant,int currentpage,int pagesize);
}
