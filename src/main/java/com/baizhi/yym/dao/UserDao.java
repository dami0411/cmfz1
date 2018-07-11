package com.baizhi.yym.dao;

import com.baizhi.yym.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yamin on 2018/7/8.
 */
public interface UserDao {

    public List<User> selectAll();

    public void insertUser(User user);

    public List<User> selectAllSplit();

    //public Integer selectByProvinceAndSex();
    public Integer selectOneWeek();
    public Integer selectTwoWeek();
    public Integer selectThreeWeek();

    public List<User> selectAllBySplit(@Param("start")Integer start, @Param("rows")Integer rows);

    public Integer selectUserCount();
}
