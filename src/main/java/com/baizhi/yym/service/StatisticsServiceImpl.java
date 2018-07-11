package com.baizhi.yym.service;

import com.baizhi.yym.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yamin on 2018/7/9.
 */
@Service("statisticsService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private UserDao userDao;

    @Override
    public Map<String, Object> queryByWeek() {
        Map<String,Object> map = new HashMap<String,Object>();
        Integer oneWeek = userDao.selectOneWeek();
        Integer twoWeek = userDao.selectTwoWeek();
        Integer threeWeek = userDao.selectThreeWeek();
        List<Integer> list = new ArrayList<Integer>();
        list.add(0,oneWeek);
        list.add(1,twoWeek);
        list.add(2,threeWeek);
        map.put("count",list);
        String[] str = new String[]{"第一周","第二周","第三周"};
        map.put("intervals",str);
        return map;
    }
}
