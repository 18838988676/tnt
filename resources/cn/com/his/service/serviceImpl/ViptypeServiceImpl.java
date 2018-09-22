package cn.com.his.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.his.dao.baseDao.ViptypeMapper;
import cn.com.his.core.vo.Viptype;
import cn.com.his.service.service.ViptypeService;

@Transactional
@Service("viptypeService")
public class ViptypeServiceImpl implements ViptypeService{

	@Autowired
	private ViptypeMapper viptypeMapper;
	
	@Override
	public List<Viptype> findAll() {
		return viptypeMapper.findAll();
	}

}
