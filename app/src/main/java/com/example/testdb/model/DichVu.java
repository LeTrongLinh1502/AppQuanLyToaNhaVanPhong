package com.example.testdb.model;

import java.io.Serializable;

public class DichVu implements Serializable {
    private int id;
    private String maDV,tenDV,gia,loaiDV;

    public DichVu() {
    }

    public DichVu(int id, String maDV, String tenDV, String gia, String loaiDV) {
        this.id = id;
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.gia = gia;
        this.loaiDV = loaiDV;
    }

    public DichVu(String maDV, String tenDV, String gia, String loaiDV) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.gia = gia;
        this.loaiDV = loaiDV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getLoaiDV() {
        return loaiDV;
    }

    public void setLoaiDV(String loaiDV) {
        this.loaiDV = loaiDV;
    }
}
