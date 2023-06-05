package com.example.testdb.model;

import java.io.Serializable;

public class CongTy implements Serializable {
    private int id;
    private String tenCTy,diachi,email,sđt;
    private int soNV;

    public CongTy() {
    }

    public CongTy(int id, String tenCTy, String diachi, String email, String sđt, int soNV) {
        this.id = id;
        this.tenCTy = tenCTy;
        this.diachi = diachi;
        this.email = email;
        this.sđt = sđt;
        this.soNV = soNV;
    }

    public CongTy(String tenCTy, String diachi, String email, String sđt, int soNV) {
        this.tenCTy = tenCTy;
        this.diachi = diachi;
        this.email = email;
        this.sđt = sđt;
        this.soNV = soNV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenCTy() {
        return tenCTy;
    }

    public void setTenCTy(String tenCTy) {
        this.tenCTy = tenCTy;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSđt() {
        return sđt;
    }

    public void setSđt(String sđt) {
        this.sđt = sđt;
    }

    public int getSoNV() {
        return soNV;
    }

    public void setSoNV(int soNV) {
        this.soNV = soNV;
    }
}
