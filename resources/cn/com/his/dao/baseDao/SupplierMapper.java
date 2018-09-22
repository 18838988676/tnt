package cn.com.his.dao.baseDao;

import java.util.List;

import cn.com.his.core.vo.Supplier;

public interface SupplierMapper {
	/**
	 * 查询供货商信息
	 * @return
	 */
    List<Supplier> findAll();
}