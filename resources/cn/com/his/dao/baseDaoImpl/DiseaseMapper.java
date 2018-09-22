package cn.com.his.dao.baseDaoImpl;

import java.util.List;

import cn.com.his.core.vo.Disease;

public interface DiseaseMapper {
    /**
     * 查询疾病类型
     * @return
     */
    List<Disease> findAll();
}