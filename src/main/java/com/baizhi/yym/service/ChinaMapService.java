package com.baizhi.yym.service;

import com.baizhi.yym.entity.ChinaMap;

import java.util.List;

/**
 * Created by yamin on 2018/7/9.
 */
public interface ChinaMapService{
    public List<ChinaMap> queryByMan();

    public List<ChinaMap>  queryByWoman();
}
