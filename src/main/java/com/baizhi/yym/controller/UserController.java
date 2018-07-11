package com.baizhi.yym.controller;

import com.baizhi.yym.dto.UserDto;
import com.baizhi.yym.entity.User;
import com.baizhi.yym.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by yamin on 2018/7/8.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/allExportUser")
    public void allExportUser(HttpServletRequest request, HttpServletResponse response){
        Workbook workBook = new HSSFWorkbook();
        userService.exportUser(workBook);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-mm-ss");
        String format = sdf.format(date);
        format = format+".xlsx";
        String aa = null;
        try {
            aa = new String(format.getBytes("UTF-8"),"ISO-8859-1");
            response.setHeader("content-disposition","attachment;filename="+aa);
            response.setContentType("application/vnd.ms-excel");
            workBook.write(response.getOutputStream());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/queryAllUser")
    public List<User> queryAllUser(){
       return  userService.queryAllUser();
    }
    @RequestMapping("/userCombotree")
    public void userCombotree(String titles,String fileds,HttpServletResponse response){
        Workbook workbook = new HSSFWorkbook();
        userService.userCombotree(titles,fileds,workbook);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-mm-ss");
        String format = sdf.format(date);
        format = format+".xlsx";
        String b = null;
        try {
            b = new String(format.getBytes("UTF-8"),"ISO-8859-1");
            response.setHeader("content-disposition","attachment;filename="+b);
            response.setContentType("application/vnd.ms-excel");
            workbook.write(response.getOutputStream());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/importUser")
    public void importUser(MultipartFile multipartFile){

        userService.importUser(multipartFile);
    }

    @RequestMapping("/userImport")
    public void userImport(String titles,String fileds,HttpServletResponse response){
        Workbook workbook = new HSSFWorkbook();
        userService.importUserForUpload(titles,fileds,workbook);
        //userService.userCombotree(titles,fileds,workbook);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-mm-ss");
        String format = sdf.format(date);
        format = format+".xlsx";
        String b = null;
        try {
            b = new String(format.getBytes("UTF-8"),"ISO-8859-1");
            response.setHeader("content-disposition","attachment;filename="+b);
            response.setContentType("application/vnd.ms-excel");
            workbook.write(response.getOutputStream());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/queryAllUserSplit")
    public UserDto queryAllUserSplit(Integer page, Integer rows){
            return userService.queryUserBySplit(page,rows);
    }

}
