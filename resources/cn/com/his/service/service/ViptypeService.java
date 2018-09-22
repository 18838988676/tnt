package cn.com.his.service.service;

import java.util.List;

import cn.com.his.core.vo.Viptype;

public interface ViptypeService{
	/**
	 * 查询会员类别
	 * @return
	 */
	public List<Viptype> findAll();
}
