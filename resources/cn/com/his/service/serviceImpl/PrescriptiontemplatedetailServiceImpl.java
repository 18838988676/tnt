package cn.com.his.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.his.dao.baseDaoImpl.PrescriptiontemplatedetailMapper;
import cn.com.his.core.vo.Prescriptiontemplatedetail;
import cn.com.his.service.service.PrescriptiontemplatedetailService;
import cn.com.his.core.vto.PrescriptiontemplatedetailVo;

@Transactional
@Service("prescriptiontemplatedetailService")
public class PrescriptiontemplatedetailServiceImpl implements
		PrescriptiontemplatedetailService {

	@Autowired
	private PrescriptiontemplatedetailMapper prescriptiontemplatedetailMapper;
	
	@Override
	public List<PrescriptiontemplatedetailVo> findByTemplateid(int id) {
		return prescriptiontemplatedetailMapper.findByTemplateid(id);
	}

	@Override
	public int add(Prescriptiontemplatedetail t) {
		return prescriptiontemplatedetailMapper.insert(t);
	}

	@Override
	public int deleteByPrescriptionid(int id) {
		return prescriptiontemplatedetailMapper.deleteByPrescriptionid(id);
	}

}
