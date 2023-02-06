package com.example.myapplication;

public class ItemList {

    private  int tv_idx;
    private int iv_icon;
    private String tv_id;
    private String tv_pwd;

    public ItemList(int tv_idx,int iv_icon, String tv_id, String tv_pwd) {
        this.tv_idx = tv_idx;
        this.iv_icon = iv_icon;
        this.tv_id = tv_id;
        this.tv_pwd = tv_pwd;
    }

    public int getTv_idx() {
        return tv_idx;
    }

    public void setTv_idx(int tv_idx) {
        this.tv_idx = tv_idx;
    }

    public int getIv_icon() {
        return iv_icon;
    }

    public void setIv_icon(int iv_icon) {
        this.iv_icon = iv_icon;
    }

    public String getTv_id() {
        return tv_id;
    }

    public void setTv_id(String tv_id) {
        this.tv_id = tv_id;
    }

    public String getTv_pwd() {
        return tv_pwd;
    }

    public void setTv_pwd(String tv_pwd) {
        this.tv_pwd = tv_pwd;
    }
}
