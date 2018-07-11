package com.baizhi.yym.service;

import com.baizhi.yym.dao.ChinaMapDao;
import com.baizhi.yym.entity.ChinaMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yamin on 2018/7/9.
 */
@Service("ChinaMapService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ChinaMapServiceImpl implements ChinaMapService {
    @Autowired
    private ChinaMapDao chinaMapDao;
    @Override
    public List<ChinaMap> queryByMan() {
        return chinaMapDao.selectByMan();
    }

    @Override
    public List<ChinaMap>  queryByWoman() {
        return chinaMapDao.selectByWoman();
    }
}
