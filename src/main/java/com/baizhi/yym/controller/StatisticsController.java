package com.baizhi.yym.controller;

import com.baizhi.yym.entity.ChinaMap;
import com.baizhi.yym.service.ChinaMapService;
import com.baizhi.yym.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by yamin on 2018/7/9.
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;
    @Autowired
    private ChinaMapService chinaMapService;
    @RequestMapping("/activeUser")
    public Map<String, Object> activeUser(){
        return statisticsService.queryByWeek();
    }

    @RequestMapping("/queryByMan")
    public List<ChinaMap> queryByMan(){
        return chinaMapService.queryByMan();
    }
    @RequestMapping("/queryByWoman")
    public List<ChinaMap> queryByWoman(){
        return chinaMapService.queryByWoman();
    }
}
