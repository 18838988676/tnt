package cn.com.his.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.his.dao.baseDao.PatienttypeMapper;
import cn.com.his.core.vo.Patienttype;
import cn.com.his.service.service.PatienttypeService;

@Transactional
@Service("patienttypeService")
public class PatienttypeServiceImpl implements PatienttypeService{

	@Autowired
	private PatienttypeMapper patienttypeMapper;
	
	@Override
	public List<Patienttype> findAll() {
		return patienttypeMapper.findAll();
	}

	@Override
	public int add(Patienttype t) {
		return patienttypeMapper.insert(t);
	}

	@Override
	public Patienttype findById(int id) {
		return patienttypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Patienttype t) {
		return patienttypeMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return patienttypeMapper.delete(id);
	}

	@Override
	public List<Patienttype> vagueFind(String contant, int currentpage,
			int pagesize) {
		return patienttypeMapper.vagueFind(contant, currentpage, pagesize);
	}

}
