package cn.com.his.service.service;

import java.util.List;

 
import cn.com.his.core.vo.Medicalrecordtemplate;
import cn.com.his.core.vto.MedicalrecordtemplateVo;

public interface MedicalrecordtemplateService extends ABaseService<Medicalrecordtemplate, Integer>{
	/**
	 * 分页多条件查询病历模板
	 * @param t
	 * @param currentpage
	 * @param pagesize
	 * @return
	 */
	public List<MedicalrecordtemplateVo> manyConditionsFind(MedicalrecordtemplateVo t,int currentpage,int pagesize);
	
	/**
	 * 查询病历模板号是否重复
	 * @param templatecode
	 * @return
	 */
	public Medicalrecordtemplate findRepetitionByCode(String templatecode);
	
	/**
	 * 模糊查询病历模板
	 * @param contant
	 * @return
	 */
	public List<MedicalrecordtemplateVo> vagueFind(String contant);
	
	/**
	 * 查询病历模板名称是否重复
	 * @param templatename
	 * @return
	 */
	public Medicalrecordtemplate findRepetitionByName(String templatename);
}
