package com.baizhi.yym.dto;

import com.baizhi.yym.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yamin on 2018/7/10.
 */
public class UserDto implements Serializable{
    private Integer total;
    private List<User> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<User> getRows() {
        return rows;
    }

    public void setRows(List<User> rows) {
        this.rows = rows;
    }

    public UserDto() {
    }

    public UserDto(Integer total, List<User> rows) {
        this.total = total;
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
