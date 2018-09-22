package cn.com.his.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.his.core.vo.Department;
import cn.com.his.dao.baseDaoImpl.DepartmentMapper;
import cn.com.his.service.service.DepartmentService;


@Transactional
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public List<Department> findAll() {
		return departmentMapper.findAll();
	}

	@Override
	public List<Department> findIsRgs() {
		return departmentMapper.findIsRgs();
	}

	@Override
	public List<Department> findDptByPid(Integer id) {
		return departmentMapper.findDptByPid(id);
	}

	@Override
	public Department findById(int id) {
		return departmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int add(Department t) {
		return departmentMapper.insert(t);
	}

	@Override
	public int edit(Department t) {
		return departmentMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return departmentMapper.delete(id);
	}

	@Override
	public List<Department> vagueFind(String contant, int currentpage,
			int pagesize) {
		return departmentMapper.vagueFind(contant, currentpage, pagesize);
	}

	@Override
	public Department findLastCode() {
		return departmentMapper.findLastCode();
	}

}
