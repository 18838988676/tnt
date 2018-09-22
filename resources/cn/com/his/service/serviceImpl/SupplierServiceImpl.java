package cn.com.his.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.his.dao.baseDao.SupplierMapper;
import cn.com.his.core.vo.Supplier;
import cn.com.his.service.service.SupplierService;

@Transactional
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierMapper supplierMapper;

	@Override
	public List<Supplier> findAll() {
		return supplierMapper.findAll();
	}
	
	

}
