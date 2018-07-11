package com.baizhi.yym.service;

import com.baizhi.yym.dao.MenuDao;
import com.baizhi.yym.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yamin on 2018/7/4.
 */
@Service("menuService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> queryAllMenu() {
       return  menuDao.selectAllMenu();
    }
}
