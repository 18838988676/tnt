package cn.com.his.service.service;

import java.util.List;

import cn.com.his.core.vo.Prescriptiondetail;
import cn.com.his.core.vto.PrescriptiondetailVo;

public interface PrescriptiondetailService {
	/**
	 * 根据处方id查询处方明细
	 * @param id
	 * @return
	 */
	public List<PrescriptiondetailVo> findByPrescriptionid(int id);
	
	/**
	 * 根据处方id查询中药明细
	 * @param id
	 * @return
	 */
	public List<PrescriptiondetailVo> findZyByPrescriptionId(int id);
	
	/**
	 * 根据处方id查询西药明细
	 * @param id
	 * @return
	 */
	public List<PrescriptiondetailVo> findXyByPrescriptionId(int id);
	
	/**
	 * 根据挂号id查询处方明细
	 * @param id
	 * @return
	 */
	public List<Prescriptiondetail> findByRegisterid(int id);
	
	/**
	 * 添加处方明细
	 * @param t
	 * @return
	 */
	public int add(Prescriptiondetail t);
	
	/**
	 * 根据处方id删除处方明细
	 * @param id
	 * @return
	 */
	public int deleteByPrescriptionid(int id);
}
