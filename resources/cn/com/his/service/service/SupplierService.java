package cn.com.his.service.service;

import java.util.List;

import cn.com.his.core.vo.Supplier;

public interface SupplierService {
	/**
	 * 查询供应商
	 * @return
	 */
	public List<Supplier> findAll();
}
