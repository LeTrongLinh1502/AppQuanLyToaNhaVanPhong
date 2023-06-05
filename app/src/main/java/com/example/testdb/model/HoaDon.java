package com.example.testdb.model;

import java.io.Serializable;

public class HoaDon implements Serializable,Comparable<HoaDon> {
    private int id;
    private String maHoaDon;
    private int idKhachHang;
    private String hanDong,tinhTrang,loaiHoaDon;
    private float tongTien;
    private String ngayXuat,phuongThucThanhToan;

    public HoaDon() {
    }

    public HoaDon(int id, String maHoaDon, int idKhachHang, String hanDong, String tinhTrang, String loaiHoaDon, float tongTien, String ngayXuat, String phuongThucThanhToan) {
        this.id = id;
        this.maHoaDon = maHoaDon;
        this.idKhachHang = idKhachHang;
        this.hanDong = hanDong;
        this.tinhTrang = tinhTrang;
        this.loaiHoaDon = loaiHoaDon;
        this.tongTien = tongTien;
        this.ngayXuat = ngayXuat;
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public HoaDon(String maHoaDon, int idKhachHang, String hanDong, String tinhTrang, String loaiHoaDon, float tongTien, String ngayXuat, String phuongThucThanhToan) {
        this.maHoaDon = maHoaDon;
        this.idKhachHang = idKhachHang;
        this.hanDong = hanDong;
        this.tinhTrang = tinhTrang;
        this.loaiHoaDon = loaiHoaDon;
        this.tongTien = tongTien;
        this.ngayXuat = ngayXuat;
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getHanDong() {
        return hanDong;
    }

    public void setHanDong(String hanDong) {
        this.hanDong = hanDong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getLoaiHoaDon() {
        return loaiHoaDon;
    }

    public void setLoaiHoaDon(String loaiHoaDon) {
        this.loaiHoaDon = loaiHoaDon;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    @Override
    public int compareTo(HoaDon hoaDon) {
        return Integer.compare((int) hoaDon.tongTien,(int) tongTien);
    }
}
