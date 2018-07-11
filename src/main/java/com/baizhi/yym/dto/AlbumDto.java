package com.baizhi.yym.dto;

import com.baizhi.yym.entity.Album;

import java.util.List;

/**
 * Created by yamin on 2018/7/7.
 */
public class AlbumDto {
    private Integer total;
    private List<Album> rows;

    @Override
    public String toString() {
        return "AlbumDto{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Album> getRows() {
        return rows;
    }

    public void setRows(List<Album> rows) {
        this.rows = rows;
    }

    public AlbumDto(Integer total, List<Album> rows) {

        this.total = total;
        this.rows = rows;
    }

    public AlbumDto() {
    }
}
