package cn.com.his.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.his.dao.baseDaoImpl.DiseaseMapper;
import cn.com.his.core.vo.Disease;
import cn.com.his.service.service.DiseaseService;

@Transactional
@Service("/diseaseService")
public class DiseaseServiceImpl implements DiseaseService {

	@Autowired
	private DiseaseMapper diseaseMapper;
	
	@Override
	public List<Disease> findAll() {
		return diseaseMapper.findAll();
	}

}
