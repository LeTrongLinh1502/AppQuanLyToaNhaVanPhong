package com.example.testdb.model;

import java.io.Serializable;

public class Phong implements Serializable ,Comparable<Phong>{
    private String maPhong;
    private float dientich;
    private String tinhTrangPhong,loaiPhong;
    private float giaPhong;
    private String mota,url_img;

    public Phong() {
    }


    public Phong(String maPhong, float dientich, String tinhTrangPhong, String loaiPhong, float giaPhong, String mota, String url_img) {
        this.maPhong = maPhong;
        this.dientich = dientich;
        this.tinhTrangPhong = tinhTrangPhong;
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
        this.mota = mota;
        this.url_img = url_img;
    }

    public Phong(float dientich, String tinhTrangPhong, String loaiPhong, float giaPhong, String mota, String url_img) {
        this.dientich = dientich;
        this.tinhTrangPhong = tinhTrangPhong;
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
        this.mota = mota;
        this.url_img = url_img;
    }

    public float getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(float giaPhong) {
        this.giaPhong = giaPhong;
    }


    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public float getDientich() {
        return dientich;
    }

    public void setDientich(float dientich) {
        this.dientich = dientich;
    }

    public String getTinhTrangPhong() {
        return tinhTrangPhong;
    }

    public void setTinhTrangPhong(String tinhTrangPhong) {
        this.tinhTrangPhong = tinhTrangPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    @Override
    public int compareTo(Phong phong) {
        return Integer.compare((int) phong.giaPhong,(int) giaPhong);
    }
}
