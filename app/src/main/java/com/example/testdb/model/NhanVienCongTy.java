package com.example.testdb.model;

import java.io.Serializable;

public class NhanVienCongTy implements Serializable {
    private int id;
    private String diachi,hoten,gioitinh,cmt,ngaysinh,email,chucvu;
    private int solanravao,idCongTy,solanvao,solanra;



    public NhanVienCongTy(int id, String diachi, String hoten, String gioitinh, String cmt, String ngaysinh, String email, String chucvu, int solanravao, int idCongTy, int solanvao, int solanra) {
        this.id = id;
        this.diachi = diachi;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.cmt = cmt;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.chucvu = chucvu;
        this.solanravao = solanravao;
        this.idCongTy = idCongTy;
        this.solanvao = solanvao;
        this.solanra = solanra;
    }

    public NhanVienCongTy(String diachi, String hoten, String gioitinh, String cmt, String ngaysinh, String email, String chucvu, int solanravao, int idCongTy, int solanvao, int solanra) {
        this.diachi = diachi;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.cmt = cmt;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.chucvu = chucvu;
        this.solanravao = solanravao;
        this.idCongTy = idCongTy;
        this.solanvao = solanvao;
        this.solanra = solanra;
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

    public int getSolanravao() {
        return solanravao;
    }

    public void setSolanravao(int solanravao) {
        this.solanravao = solanravao;
    }

    public int getIdCongTy() {
        return idCongTy;
    }

    public void setIdCongTy(int idCongTy) {
        this.idCongTy = idCongTy;
    }

    public int getSolanvao() {
        return solanvao;
    }

    public void setSolanvao(int solanvao) {
        this.solanvao = solanvao;
    }

    public int getSolanra() {
        return solanra;
    }

    public void setSolanra(int solanra) {
        this.solanra = solanra;
    }
}
