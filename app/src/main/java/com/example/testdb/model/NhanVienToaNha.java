package com.example.testdb.model;

import java.io.Serializable;

public class NhanVienToaNha implements Serializable {
    private int id;
    private String diachi,hoten,gioitinh,cmt,ngaysinh,email,chucvu,vaitro;
    private int mucluong;

    public NhanVienToaNha() {
    }

    public NhanVienToaNha(int id, String diachi, String hoten, String gioitinh, String cmt, String ngaysinh, String email, String chucvu, String vaitro, int mucluong) {
        this.id = id;
        this.diachi = diachi;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.cmt = cmt;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.chucvu = chucvu;
        this.vaitro = vaitro;
        this.mucluong = mucluong;
    }

    public NhanVienToaNha(String diachi, String hoten, String gioitinh, String cmt, String ngaysinh, String email, String chucvu, String vaitro, int mucluong) {
        this.diachi = diachi;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.cmt = cmt;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.chucvu = chucvu;
        this.vaitro = vaitro;
        this.mucluong = mucluong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }

    public int getMucluong() {
        return mucluong;
    }

    public void setMucluong(int mucluong) {
        this.mucluong = mucluong;
    }
}
