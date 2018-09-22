package cn.com.his.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.his.dao.baseDao.RegistertypeMapper;
import cn.com.his.core.solr.SolrCrud;
import cn.com.his.core.solr.SolrUtil;
import cn.com.his.core.vo.Registertype;
import cn.com.his.core.vo.solr.RegistertypeSolr;
import cn.com.his.service.service.RegistertypeService;

@Transactional
@Service("registertypeService")
public class RegistertypeServiceImpl implements RegistertypeService{

	@Autowired
	private RegistertypeMapper registertypeMapper;

	@Override
	public List<Registertype> findBefor() {
		return registertypeMapper.findBefor();
	}

	@Override
	public List<Registertype> findAll() {
		return registertypeMapper.findAll();
	}

	@Override
	public int add(Registertype t) {
		return registertypeMapper.insert(t);
	}

	@Override
	public Registertype findById(int id) {
		return registertypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int edit(Registertype t) {
		return registertypeMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(int id) {
		return registertypeMapper.delete(id);
	}

	@Override
	public List<RegistertypeSolr> vagueFind(String contant, int currentpage,
			int pagesize) {
		
		
		return SolrCrud.getDocment(contant, "registertypeCore", true, 1, 10);
	//	return registertypeMapper.vagueFind(contant, currentpage, pagesize);
	}
	

}
