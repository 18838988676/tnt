package cn.com.his.service.service;

import java.util.List;

 
import cn.com.his.core.vo.Medicalrecord;
import cn.com.his.core.vto.MedicalrecordVo;

public interface MedicalrecordService extends ABaseService<Medicalrecord, Integer>{
	/**
	 * 分页多条件查询病历
	 * @param t
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	public List<MedicalrecordVo> manyConditionsFind(MedicalrecordVo t,int currentpage,int pagesize);
	
	/**
	 * 查询病历号是否重复
	 * @param medicalrecordcode
	 * @return
	 */
	public Medicalrecord findRepetition(String medicalrecordcode);
}
