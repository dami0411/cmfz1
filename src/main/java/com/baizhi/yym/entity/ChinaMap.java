package com.baizhi.yym.entity;

import java.io.Serializable;

/**
 * Created by yamin on 2018/7/9.
 */
public class ChinaMap implements Serializable{
    private String name;
    private Integer value;

    @Override
    public String toString() {
        return "ChinaMap{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ChinaMap() {
    }

    public ChinaMap(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}
