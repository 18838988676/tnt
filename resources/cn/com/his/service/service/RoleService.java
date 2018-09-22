package cn.com.his.service.service;

import java.util.List;

 
import cn.com.his.core.vo.Role;
import cn.com.his.core.vto.RoleVo;

public interface RoleService extends ABaseService<Role, Integer>{
	/**
	 * 查询角色，含rid和frid
	 * @return
	 */
	public List<RoleVo> findRid();
	
	/**
	 * 根据职务id查询角色
	 * @param t
	 * @return
	 */
	public List<RoleVo> findRidByPositionid(RoleVo t);
	
	/**
	 * 分页查询角色
	 * @param contant
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	public List<Role> vagueFind(String contant,int currentpage,int pagesize);
	
	//根据员工id查询角色
	public Role findByEpId(Integer eid);
}
