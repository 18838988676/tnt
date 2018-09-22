package cn.com.his.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.his.dao.baseDaoImpl.RoleMapper;
import cn.com.his.core.vo.Role;
import cn.com.his.service.service.RoleService;
import cn.com.his.core.vto.RoleVo;

@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> findAll() {
		return null;
	}

	@Override
	public int add(Role t) {
		return roleMapper.insert(t);
	}

	@Override
	public Role findById(int id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Role t) {
		return roleMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return roleMapper.delete(id);
	}

	@Override
	public List<RoleVo> findRid() {
		return roleMapper.findRid();
	}

	@Override
	public List<RoleVo> findRidByPositionid(RoleVo t) {
		return roleMapper.findRidByPositionid(t);
	}

	@Override
	public List<Role> vagueFind(String contant, int currentpage, int pagesize) {
		return roleMapper.vagueFind(contant, currentpage, pagesize);
	}

	@Override
	public Role findByEpId(Integer eid) {
		return roleMapper.findByEpId(eid);
	}

}
