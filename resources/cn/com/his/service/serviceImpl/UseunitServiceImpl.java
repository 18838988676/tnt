package cn.com.his.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.his.dao.baseDaoImpl.UseunitMapper;
import cn.com.his.core.vo.Useunit;
import cn.com.his.service.service.UseunitService;

@Transactional
@Service("useunitService")
public class UseunitServiceImpl implements UseunitService {

	@Autowired
	private UseunitMapper useunitMapper;
	
	@Override
	public Useunit findOne() {
		return useunitMapper.findOne();
	}

	@Override
	public int add(Useunit t) {
		return useunitMapper.insert(t);
	}

	@Override
	public int edit(Useunit t) {
		return useunitMapper.updateByPrimaryKeySelective(t);
	}
}
