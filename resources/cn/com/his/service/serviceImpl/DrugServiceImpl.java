package cn.com.his.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.his.dao.baseDaoImpl.DrugMapper;
import cn.com.his.core.vo.Drug;
import cn.com.his.service.service.DrugService;
import cn.com.his.core.vto.DrugVo;

@Transactional
@Service("drugService")
public class DrugServiceImpl implements DrugService {

	@Autowired
	private DrugMapper drugMapper;

	@Override
	public int add(Drug t) {
		int i;
		drugMapper.insert(t);
		i = t.getId();
		return i;
	}

	@Override
	public List<DrugVo> manyConditionsFind(DrugVo t,int currentpage,int pagesize) {
		return drugMapper.manyConditionsFind(t,currentpage,pagesize);
	}

	@Override
	public List<DrugVo> vagueFind(String contant) {
		return drugMapper.vagueFind(contant);
	}

	@Override
	public Drug findById(int id) {
		return drugMapper.findByid(id);
	}

	@Override
	public int edit(Drug t) {
		return drugMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int updateInventoryquantity(Drug t) {
		return drugMapper.updateInventoryquantity(t);
	}

	@Override
	public int delete(int id) {
		return drugMapper.delete(id);
	}

	@Override
	public List<Drug> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
