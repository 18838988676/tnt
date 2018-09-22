package cn.com.his.service.service;

import java.util.List;

import cn.com.his.core.vo.Disease;

public interface DiseaseService{
	/**
	 * 查询疾病类型
	 * @return
	 */
	public List<Disease> findAll();
}
