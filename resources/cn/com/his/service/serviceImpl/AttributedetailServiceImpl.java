package cn.com.his.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.his.dao.baseDao.AttributedetailMapper;

import cn.com.his.core.vo.Attributedetail;
import cn.com.his.service.service.AttributedetailService;
 
@Transactional
@Service("attributedetailService")
public class AttributedetailServiceImpl implements AttributedetailService{

	@Autowired
	private AttributedetailMapper attributedetailMapper;

	@Override
	public List<Attributedetail> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Attributedetail t) {
		return attributedetailMapper.insert(t);
	}

	@Override
	public Attributedetail findById(int id) {
		return attributedetailMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Attributedetail t) {
		return attributedetailMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return attributedetailMapper.delete(id);
	}
	
	@Override
	public List<Attributedetail> findByAttributeid(int id) {
		return attributedetailMapper.findByAttributeid(id);
	}

	@Override
	public List<Attributedetail> vagueFind(String contant, int currentpage,
			int pagesize) {
		return attributedetailMapper.vagueFind(contant, currentpage, pagesize);
	}
}
