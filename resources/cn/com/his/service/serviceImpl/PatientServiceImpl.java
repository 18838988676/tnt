package cn.com.his.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.his.dao.baseDaoImpl.PatientMapper;
import cn.com.his.core.vo.Patient; 
import cn.com.his.service.service.PatientService;
import cn.com.his.core.vto.PatientVo;

@Transactional
@Service("patientService")
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientMapper patientMapper;
	
	@Override
	public List<PatientVo> findAll() {
		return patientMapper.findAll();
	}

	@Override
	public int add(Patient t) {
		return patientMapper.insert(t);
	}

	@Override
	public List<PatientVo> vagueFind(PatientVo t) {
		return patientMapper.vagueFind(t);
	}
}
