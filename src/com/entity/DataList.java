package com.entity;

import java.util.List;

/**
 * Created by LinXu on 2017/3/9.
 */
public class DataList {
    private String className;
    private List<TeaSignInfo> list;
    public DataList(){}

    public DataList(String className, List<TeaSignInfo> list) {
        this.className = className;
        this.list = list;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<TeaSignInfo> getList() {
        return list;
    }

    public void setList(List<TeaSignInfo> list) {
        this.list = list;
    }
}
