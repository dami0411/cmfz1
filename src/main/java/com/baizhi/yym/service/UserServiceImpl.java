package com.baizhi.yym.service;

import com.baizhi.yym.dao.UserDao;
import com.baizhi.yym.dto.AlbumDto;
import com.baizhi.yym.dto.UserDto;
import com.baizhi.yym.entity.Album;
import com.baizhi.yym.entity.User;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by yamin on 2018/7/8.
 */
@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void exportUser(Workbook workBook) {
        //创建xslx文件
        //构建样式
        CellStyle cellStyle = workBook.createCellStyle();
        CellStyle dateStyle = workBook.createCellStyle();
        DataFormat dataFormat = workBook.createDataFormat();
        short format = dataFormat.getFormat("yyyy/MM/dd");
        dateStyle.setDataFormat(format);
        //居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        Font font = workBook.createFont();
        font.setBold(true);
        //字体颜色
        font.setColor(Font.COLOR_RED);
        //字体类型
        font.setFontName("楷书");
        cellStyle.setFont(font);
        //创建表
        Sheet sheet = workBook.createSheet("user");
        sheet.setColumnWidth(10,25*256);
        //标题
        String[] titles = {"编号","头像","法名","姓名","性别","省份","城市","签名","电话","密码","盐","创建时间","状态"};
        //创建行
        Row row = sheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            //创建单元格
            Cell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(titles[i]);
        }
        List<User> list = userDao.selectAll();
        for (int i = 1;i <=list.size(); i++) {
            Row sheetRow = sheet.createRow(i);
            sheetRow.createCell(0).setCellValue(list.get(i-1).getId());
            sheetRow.createCell(1).setCellValue(list.get(i-1).getPhoto());
            sheetRow.createCell(2).setCellValue(list.get(i-1).getDharmaName());
            sheetRow.createCell(3).setCellValue(list.get(i-1).getName());
            sheetRow.createCell(4).setCellValue(list.get(i-1).getSex());
            sheetRow.createCell(5).setCellValue(list.get(i-1).getProvince());
            sheetRow.createCell(6).setCellValue(list.get(i-1).getCity());
            sheetRow.createCell(7).setCellValue(list.get(i-1).getSign());
            sheetRow.createCell(8).setCellValue(list.get(i-1).getPhoneNum());
            sheetRow.createCell(9).setCellValue(list.get(i-1).getPassword());
            sheetRow.createCell(10).setCellValue(list.get(i-1).getSalt());
            Cell cell = sheetRow.createCell(11);
            cell.setCellStyle(dateStyle);
            cell.setCellValue(list.get(i-1).getCreateTime());
            sheetRow.createCell(12).setCellValue(list.get(i-1).getStatus());
        }
    }

    @Override
    public void importUser(MultipartFile multipartFile){
        try {
            InputStream inputStream = multipartFile.getInputStream();
            String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            Workbook workBook = null;
           /* if(extension.equals("xls")){
                workBook =  new HSSFWorkbook(inputStream);
            }else{
                workBook =  new XSSFWorkbook(inputStream);
            }*/
            workBook =  new HSSFWorkbook(inputStream);
            Sheet sheet = workBook.getSheetAt(0);
            for (int i = 1; i <=sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
               // String id = row.getCell(0).getStringCellValue();
                String photo = row.getCell(1).getStringCellValue();
                String dharmaName = row.getCell(2).getStringCellValue();
                String name = row.getCell(3).getStringCellValue();
                String sex = row.getCell(4).getStringCellValue();
                String province = row.getCell(5).getStringCellValue();
                String city = row.getCell(6).getStringCellValue();
                String sign = row.getCell(7).getStringCellValue();
               /* double cellValue = row.getCell(9).getNumericCellValue();
                String password = String.valueOf(cellValue);
                if(password.contains(".0")){
                    password = password.replace(".0","");
                }*/
                String phoneNum = row.getCell(8).getStringCellValue();
                String password = row.getCell(9).getStringCellValue();
                String salt = row.getCell(10).getStringCellValue();
                Date createTime = row.getCell(11).getDateCellValue();
                String status = row.getCell(12).getStringCellValue();
                String id = UUID.randomUUID().toString();
                User user = new User(id,photo,dharmaName,name,sex,province,city,sign,phoneNum,password,salt,createTime,status);
                userDao.insertUser(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.selectAll();
    }

    @Override
    public void userCombotree(String titles, String fileds, Workbook workbook) {
        Sheet sheet = workbook.createSheet("myuser");
        String[] texts = titles.split(",");
        String[] params = fileds.split(",");
        Row row = sheet.createRow(0);
        for (int i = 0; i < texts.length; i++) {
            row.createCell(i).setCellValue(texts[i]);
        }
        List<User> list = userDao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            Class<? extends User> aClass = list.get(i).getClass();
            System.out.println(list.get(i));
            Row row1 = sheet.createRow(i + 1);
            for (int j = 0; j < params.length; j++){
                String methodName = "get"+params[j].substring(0,1).toUpperCase()+params[j].substring(1);
                Object obj = null;
                try {
                    obj= aClass.getDeclaredMethod(methodName,null).invoke(list.get(i),null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(obj instanceof Date){
                    DataFormat dataFormat = workbook.createDataFormat();
                    short format = dataFormat.getFormat("yyyy/MM/dd");
                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setDataFormat(format);
                    Cell rowCell = row1.createCell(j);
                    rowCell.setCellStyle(cellStyle);
                    rowCell.setCellValue((Date)obj);
                }else{
                    row1.createCell(j).setCellValue(String.valueOf(obj));
                }
            }
        }
    }

    @Override
    public void importUserForUpload(String titles,String fileds,Workbook workbook) {
        Sheet sheet = workbook.createSheet("myuser");
        String[] texts = titles.split(",");
        String[] params = fileds.split(",");
        Row row = sheet.createRow(0);
        for (int i = 0; i < texts.length; i++) {
            row.createCell(i).setCellValue(texts[i]);
        }

    }

    @Override
    public UserDto queryUserBySplit(Integer page, Integer rows) {
        List<User> userList = userDao.selectAllBySplit((page-1)*rows,rows);
        UserDto dto = new UserDto();
        dto.setTotal(userDao.selectUserCount());
        dto.setRows(userList);
        return dto;
    }
}
