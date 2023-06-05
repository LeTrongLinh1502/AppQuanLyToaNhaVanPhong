package com.example.testdb.model;

import java.io.Serializable;

public class HopDong implements Serializable {
    private int id;
    private String maHopDong;
    private int idKhachHang;
    private String ngayBatDauThue,moTa;
    private float tienCoc;
    private int thoihan;
    private String ngayKy;

    private int maPhong;


    public HopDong(int id, String maHopDong, int idKhachHang, String ngayBatDauThue, String moTa, float tienCoc, int thoihan, String ngayKy, int maPhong) {
        this.id = id;
        this.maHopDong = maHopDong;
        this.idKhachHang = idKhachHang;
        this.ngayBatDauThue = ngayBatDauThue;
        this.moTa = moTa;
        this.tienCoc = tienCoc;
        this.thoihan = thoihan;
        this.ngayKy = ngayKy;
        this.maPhong = maPhong;
    }

    public HopDong(String maHopDong, int idKhachHang, String ngayBatDauThue, String moTa, float tienCoc, int thoihan, String ngayKy, int maPhong) {
        this.maHopDong = maHopDong;
        this.idKhachHang = idKhachHang;
        this.ngayBatDauThue = ngayBatDauThue;
        this.moTa = moTa;
        this.tienCoc = tienCoc;
        this.thoihan = thoihan;
        this.ngayKy = ngayKy;
        this.maPhong = maPhong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getNgayBatDauThue() {
        return ngayBatDauThue;
    }

    public void setNgayBatDauThue(String ngayBatDauThue) {
        this.ngayBatDauThue = ngayBatDauThue;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public float getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(float tienCoc) {
        this.tienCoc = tienCoc;
    }

    public String getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(String ngayKy) {
        this.ngayKy = ngayKy;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public int getThoihan() {
        return thoihan;
    }

    public void setThoihan(int thoihan) {
        this.thoihan = thoihan;
    }
}
