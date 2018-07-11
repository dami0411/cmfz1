package com.baizhi.yym.dto;

import com.baizhi.yym.entity.Banner;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yamin on 2018/7/6.
 */
public class BannerDto implements Serializable {
    private Integer total;
    private List<Banner> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Banner> getRows() {
        return rows;
    }

    public void setRows(List<Banner> rows) {
        this.rows = rows;
    }

    public BannerDto(Integer total, List<Banner> rows) {
        this.total = total;
        this.rows = rows;
    }

    public BannerDto() {

    }

    @Override
    public String toString() {
        return "BannerDto{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
