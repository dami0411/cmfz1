package com.baizhi.yym.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yamin on 2018/7/6.
 */
public class Chapter implements Serializable {
    private String id;
    private String title;
    private String url;
    private Double size;
    private String length;
    private Integer times;
    @JSONField(format = "yyyy/MM/dd")
    private Date createTime;
    private Album album;

    public Chapter() {
    }

    public Chapter(String id, String title, String url, Double size, String length, Integer times, Date createTime, Album album) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.size = size;
        this.length = length;
        this.times = times;
        this.createTime = createTime;
        this.album = album;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", size=" + size +
                ", length='" + length + '\'' +
                ", times=" + times +
                ", createTime=" + createTime +
                ", album=" + album +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
