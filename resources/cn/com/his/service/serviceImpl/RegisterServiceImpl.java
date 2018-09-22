package cn.com.his.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.his.dao.baseDaoImpl.RegisterMapper;
import cn.com.his.core.vo.Register;
import cn.com.his.service.service.RegisterService;
import cn.com.his.core.vto.RegisterVo;

@Transactional
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterMapper registerMapper;
	
	@Override
	public List<RegisterVo> findAll() {
		return registerMapper.findAll();
	}

	@Override
	public RegisterVo findLast() {
		return registerMapper.findLast();
	}

	@Override
	public RegisterVo countInfo() {
		return registerMapper.countInfo();
	}	

	@Override
	public int add(Register t) {
		return registerMapper.insert(t);
	}

	@Override
	public List<RegisterVo> pageFindToday(int currentpage, int pagesize) {
		return registerMapper.pageFindToday(currentpage, pagesize);
	}

	@Override
	public List<RegisterVo> vagueFind(RegisterVo t) {
		return registerMapper.vagueFind(t);
	}

	@Override
	public List<RegisterVo> manyConditionsFindhistory(RegisterVo vo,int currentpage,int pagesize) {
		return registerMapper.manyConditionsFindhistory(vo,currentpage,pagesize);
	}

	@Override
	public RegisterVo findByid(int id) {
		return registerMapper.findByid(id);
	}

	@Override
	public int delete(int id) {
		return registerMapper.delete(id);
	}

	@Override
	public int updatestatus(Register t) {
		return registerMapper.updatestatus(t);
	}
}
