package com.baizhi.yym.service;

import com.baizhi.yym.dto.AlbumDto;
import com.baizhi.yym.dto.UserDto;
import com.baizhi.yym.entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by yamin on 2018/7/8.
 */
public interface UserService {
    public void exportUser(Workbook workBook);
    public void importUser(MultipartFile multipartFile);
    public List<User> queryAllUser();
    public void userCombotree(String titles,String fileds,Workbook workbook);

    public void importUserForUpload(String titles,String fileds,Workbook workbook);

    public UserDto queryUserBySplit(Integer page, Integer rows);

}
