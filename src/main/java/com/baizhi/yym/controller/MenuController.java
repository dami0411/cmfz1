package com.baizhi.yym.controller;

import com.baizhi.yym.entity.Menu;
import com.baizhi.yym.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yamin on 2018/7/4.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @RequestMapping("/queryAllMenu")
    @ResponseBody
    public List<Menu> queryAllMenu(){
        return  menuService.queryAllMenu();
    }
}
