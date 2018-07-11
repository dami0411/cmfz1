package com.baizhi.yym.dao;

import com.baizhi.yym.entity.ChinaMap;

import java.util.List;

/**
 * Created by yamin on 2018/7/9.
 */
public interface ChinaMapDao {
    public List<ChinaMap> selectByMan();

    public List<ChinaMap>  selectByWoman();
}
