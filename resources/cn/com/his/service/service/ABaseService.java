package cn.com.his.service.service;

import java.io.Serializable;
import java.util.List;

public interface ABaseService<T, PK extends Serializable> {
	/**
	 * 查询全部
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 添加
	 * @param t
	 * @return
	 */
	public int add(T t);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public T findById(int id);
	
	/**
	 * 修改
	 * @param t
	 * @return
	 */
	public int edit(T t);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(int id);
}
