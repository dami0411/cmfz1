package com.baizhi.yym.testDao;

import com.baizhi.yym.AppEnter;
import com.baizhi.yym.entity.Menu;
import com.baizhi.yym.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by yamin on 2018/7/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppEnter.class)
public class TestMenu {
    @Autowired
    private MenuService menuService;
    @Test
    public void queryAll(){
        List<Menu> list = menuService.queryAllMenu();
        for (Menu menu : list) {
            System.out.println(menu);
        }
    }

}
