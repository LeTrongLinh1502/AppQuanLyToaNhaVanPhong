package com.example.testdb.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String taikhoan,matkhau;

    public User() {
    }

    public User(int id, String taikhoan, String matkhau) {
        this.id = id;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public User(String taikhoan, String matkhau) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
