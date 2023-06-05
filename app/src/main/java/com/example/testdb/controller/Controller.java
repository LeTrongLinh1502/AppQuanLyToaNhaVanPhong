package com.example.testdb.controller;

import com.example.testdb.database.ConnectionHelper;
import com.example.testdb.model.CongTy;
import com.example.testdb.model.DichVu;
import com.example.testdb.model.HoaDon;
import com.example.testdb.model.HopDong;
import com.example.testdb.model.NhanVienCongTy;
import com.example.testdb.model.NhanVienToaNha;
import com.example.testdb.model.Phong;
import com.example.testdb.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    Statement st;
    ResultSet rs;
    ResultSetMetaData rsmd;
    ConnectionHelper connectionHelper = new ConnectionHelper();
    Connection connect= connectionHelper.conclass();
    public User CheckLogin(User user) throws SQLException {
        PreparedStatement preparedStatement = connect.prepareStatement("SELECT *\n"
                + "FROM Users\n"
                + "WHERE TaiKhoan = ?\n"
                + "AND MatKhau = ?");
        preparedStatement.setString(1, user.getTaikhoan());
        preparedStatement.setString(2, user.getMatkhau());
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return new User(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
        }
        return null;
    }
    public void addCongTy(CongTy congTy){
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO CongTy(TenCongTy, DiaChi, Email, SDT,SoNV)\n"
                    + "VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, congTy.getTenCTy());
            preparedStatement.setString(2, congTy.getDiachi());
            preparedStatement.setString(3, congTy.getEmail());
            preparedStatement.setString(4, congTy.getSđt());
            preparedStatement.setInt(5, congTy.getSoNV());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<CongTy> getAllCongTy(){
        List<CongTy> ans=new ArrayList<>();
        try {
            st = connect.createStatement();
            rs = st.executeQuery("select * from CongTy");
//            PreparedStatement preparedStatement = connect.prepareStatement("SELECT *from CongTy");
//            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String ten=rs.getString(2);
                String diachi=rs.getString(3);
                String email=rs.getString(4);
                String sdt=rs.getString(5);
                int soNV= rs.getInt(6);
                CongTy congTy=new CongTy(id,ten,diachi,email,sdt,soNV);
                ans.add(congTy);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public void updateCongTy(CongTy congTy){
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("UPDATE CongTy SET TenCongTy = ?, DiaChi=? ,Email=? ,SDT=?,SoNV=? WHERE IDCongTy = ?");
            preparedStatement.setString(1, congTy.getTenCTy());
            preparedStatement.setString(2, congTy.getDiachi());
            preparedStatement.setString(3, congTy.getEmail());
            preparedStatement.setString(4, congTy.getSđt());
            preparedStatement.setInt(5, congTy.getSoNV());
            preparedStatement.setInt(6,congTy.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void deleteCongTy(int IDcongTy){
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("DELETE FROM CongTy  WHERE IDCongTy = ?");
            preparedStatement.setInt(1,IDcongTy);
            preparedStatement.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<CongTy> searchCongTyByTen(String s){
        List<CongTy> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT *FROM CongTy  WHERE TenCongTy LIKE ?");
            String tmp="%"+s+"%";
            preparedStatement.setString(1,tmp);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String ten=rs.getString(2);
                String diachi=rs.getString(3);
                String email=rs.getString(4);
                String sdt=rs.getString(5);
                int soNV= rs.getInt(6);
                CongTy congTy=new CongTy(id,ten,diachi,email,sdt,soNV);
                ans.add(new CongTy(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public int searchIdCongTyByTen(String s){
        int idCongTy = 0;
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT IDCongTy FROM CongTy  WHERE TenCongTy LIKE ?");
            preparedStatement.setString(1,s);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                idCongTy=rs.getInt(1);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return idCongTy;
    }
    public String searchTenCongTyById(int id){
        String tenCT="";
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT TenCongTy FROM CongTy  WHERE IDCongTy = ?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                tenCT=rs.getString(1);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tenCT;
    }
    public void addNVCongTy(NhanVienCongTy NVcongty){
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO NVCongTy(DiaChi, HoTen, GioiTinh, CMT,NgaySinh,Email,ChucVu,SoLanRaVao,IDCongTy,SoLanRa,SoLanVao)\n"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, NVcongty.getDiachi());
            preparedStatement.setString(2, NVcongty.getHoten());
            preparedStatement.setString(3, NVcongty.getGioitinh());
            preparedStatement.setString(4, NVcongty.getCmt());
            preparedStatement.setString(5, NVcongty.getNgaysinh());
            preparedStatement.setString(6, NVcongty.getEmail());
            preparedStatement.setString(7, NVcongty.getChucvu());
            preparedStatement.setInt(8, NVcongty.getSolanravao());
            preparedStatement.setInt(9, NVcongty.getIdCongTy());
            preparedStatement.setInt(10, NVcongty.getSolanvao());
            preparedStatement.setInt(11, NVcongty.getSolanra());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<NhanVienCongTy> getAllNVCongTy(){
        List<NhanVienCongTy> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT *from NVCongTy");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String diachi=rs.getString(2);
                String hoten=rs.getString(3);
                String gioitinh=rs.getString(4);
                String cmt=rs.getString(5);
                String ngaysinh= rs.getString(6);
                String email= rs.getString(7);
                String chucvu= rs.getString(8);
                int solanravao=rs.getInt(9);
                int idCongTy=rs.getInt(10);
                int solanvao=rs.getInt(11);
                int solanra=rs.getInt(12);
                NhanVienCongTy NVcongTy=new NhanVienCongTy(id,diachi,hoten,gioitinh,cmt,ngaysinh,
                        email,chucvu,solanravao,idCongTy,solanvao,solanra);
                ans.add(NVcongTy);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public void deleteNVCongTy(int IdNVCongTy){
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("DELETE FROM NVCongTy  WHERE ID = ?");
            preparedStatement.setInt(1,IdNVCongTy);
            preparedStatement.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateNVCongTy(NhanVienCongTy NVcongTy){
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("UPDATE NVCongTy SET HoTen = ?, DiaChi=? ,GioiTinh=? ," +
                    "CMT=?,NgaySinh = ?, Email=? ,ChucVu=? ,IDCongTy=? WHERE ID = ?");
            preparedStatement.setString(1, NVcongTy.getHoten());
            preparedStatement.setString(2, NVcongTy.getDiachi());
            preparedStatement.setString(3, NVcongTy.getGioitinh());
            preparedStatement.setString(4, NVcongTy.getCmt());
            preparedStatement.setString(5, NVcongTy.getNgaysinh());
            preparedStatement.setString(6, NVcongTy.getEmail());
            preparedStatement.setString(7, NVcongTy.getChucvu());
            preparedStatement.setInt(8, NVcongTy.getIdCongTy());
            preparedStatement.setInt(9,NVcongTy.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<NhanVienCongTy> searchNVCongTyByTen(String s){
        List<NhanVienCongTy> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT *FROM NVCongTy  WHERE HoTen LIKE ?" +
                    " OR CMT LIKE ?");
            String tmp="%"+s+"%";
            preparedStatement.setString(1,tmp);
            preparedStatement.setString(2,tmp);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String diachi=rs.getString(2);
                String hoten=rs.getString(3);
                String gioitinh=rs.getString(4);
                String cmt=rs.getString(5);
                String ngaysinh= rs.getString(6);
                String email= rs.getString(7);
                String chucvu= rs.getString(8);
                int solanravao=rs.getInt(9);
                int idCongTy=rs.getInt(10);
                int solanvao=rs.getInt(11);
                int solanra=rs.getInt(12);
                NhanVienCongTy NVcongTy=new NhanVienCongTy(id,diachi,hoten,gioitinh,cmt,ngaysinh,
                        email,chucvu,solanravao,idCongTy,solanvao,solanra);
                ans.add(NVcongTy);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public void addNVToaNha(NhanVienToaNha NVtoanha){
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO NhanVienToaNha(DiaChi, HoTen, GioiTinh, CMT,NgaySinh,Email,ChucVu,VaiTro,MucLuong)\n"
                    + "VALUES(?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, NVtoanha.getDiachi());
            preparedStatement.setString(2, NVtoanha.getHoten());
            preparedStatement.setString(3, NVtoanha.getGioitinh());
            preparedStatement.setString(4, NVtoanha.getCmt());
            preparedStatement.setString(5, NVtoanha.getNgaysinh());
            preparedStatement.setString(6, NVtoanha.getEmail());
            preparedStatement.setString(7, NVtoanha.getChucvu());
            preparedStatement.setString(8, NVtoanha.getVaitro());
            preparedStatement.setInt(9, NVtoanha.getMucluong());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<NhanVienToaNha> getAllNVToaNha(){
        List<NhanVienToaNha> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT *from NhanVienToaNha");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String diachi=rs.getString(2);
                String hoten=rs.getString(3);
                String gioitinh=rs.getString(4);
                String cmt=rs.getString(5);
                String ngaysinh= rs.getString(6);
                String email= rs.getString(7);
                String chucvu= rs.getString(8);
                String vaitro= rs.getString(9);
                int mucluong=rs.getInt(10);
                NhanVienToaNha NVtoanha=new NhanVienToaNha(id,diachi,hoten,gioitinh,cmt,ngaysinh,
                        email,chucvu,vaitro,mucluong);
                ans.add(NVtoanha);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }

    public void deleteNVToaNha(int id) {
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("DELETE FROM NhanVienToaNha  WHERE ID = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<NhanVienToaNha> searchNVToaNhaByTenCMT(String s){
        List<NhanVienToaNha> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT *FROM NhanVienToaNha  WHERE HoTen LIKE ?" +
                    " OR CMT LIKE ?");
            String tmp="%"+s+"%";
            preparedStatement.setString(1,tmp);
            preparedStatement.setString(2,tmp);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String diachi=rs.getString(2);
                String hoten=rs.getString(3);
                String gioitinh=rs.getString(4);
                String cmt=rs.getString(5);
                String ngaysinh= rs.getString(6);
                String email= rs.getString(7);
                String chucvu= rs.getString(8);
                String vaitro= rs.getString(9);
                int mucluong=rs.getInt(10);
                NhanVienToaNha NVtoanha=new NhanVienToaNha(id,diachi,hoten,gioitinh,cmt,ngaysinh,
                        email,chucvu,vaitro,mucluong);
                ans.add(NVtoanha);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public void addDichVu(DichVu dichVu){
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO DichVu(MaDichVu, TenDichVu, GiaDichVu, LoaiDichVu)\n"
                    + "VALUES(?,?,?,?)");
            preparedStatement.setString(1, dichVu.getMaDV());
            preparedStatement.setString(2, dichVu.getTenDV());
            preparedStatement.setInt(3, Integer.parseInt(dichVu.getGia()));
            preparedStatement.setString(4, dichVu.getLoaiDV());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<DichVu> getAllDichVu(){
        List<DichVu> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT *from DichVu");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String maDV=rs.getString(2);
                String tenDV=rs.getString(3);
                Integer giaDV=rs.getInt(4);
                String loaiDV=rs.getString(5);
                DichVu dichVu=new DichVu(id,maDV,tenDV,String.valueOf(giaDV),loaiDV);
                ans.add(dichVu);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public void deleteDichVu(int id) {
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("DELETE FROM DichVu  WHERE ID = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateDichVu(DichVu dichVu){
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("UPDATE DichVu SET MaDichVu = ?, TenDichVu=? ," +
                    "GiaDichVu=? ," + "LoaiDichVu=? WHERE ID = ?");
            preparedStatement.setString(1, dichVu.getMaDV());
            preparedStatement.setString(2, dichVu.getTenDV());
            preparedStatement.setInt(3, Integer.parseInt(dichVu.getGia()));
            preparedStatement.setString(4, dichVu.getLoaiDV());
            preparedStatement.setInt(5,dichVu.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<DichVu> searchDichVuByTen(String s){
        List<DichVu> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT *FROM DichVu  WHERE TenDichVu LIKE ?" +
                    " OR MaDichVu LIKE ?");
            String tmp="%"+s+"%";
            preparedStatement.setString(1,tmp);
            preparedStatement.setString(2,tmp);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String maDV=rs.getString(2);
                String tenDV=rs.getString(3);
                Integer giaDV=rs.getInt(4);
                String loaiDV=rs.getString(5);
                DichVu dichVu=new DichVu(id,maDV,tenDV,String.valueOf(giaDV),loaiDV);
                ans.add(dichVu);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }

    public List<CongTy> thongKeCongTy() {
        List<CongTy> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT * FROM CongTy ORDER BY SoNV DESC");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String ten=rs.getString(2);
                String diachi=rs.getString(3);
                String email=rs.getString(4);
                String sdt=rs.getString(5);
                int soNV= rs.getInt(6);
                CongTy congTy=new CongTy(id,ten,diachi,email,sdt,soNV);
                ans.add(congTy);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }

    public List<DichVu> thongKeDichVu() {
        List<DichVu> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT * FROM DichVu ORDER BY GiaDichVu DESC");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String maDV=rs.getString(2);
                String tenDV=rs.getString(3);
                Integer giaDV=rs.getInt(4);
                String loaiDV=rs.getString(5);
                DichVu dichVu=new DichVu(id,maDV,tenDV,String.valueOf(giaDV),loaiDV);
                ans.add(dichVu);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }

    public List<NhanVienCongTy> thongKeNVCongTy() {
        List<NhanVienCongTy> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT * FROM NVCongTy ORDER BY NgaySinh DESC");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String diachi=rs.getString(2);
                String hoten=rs.getString(3);
                String gioitinh=rs.getString(4);
                String cmt=rs.getString(5);
                String ngaysinh= rs.getString(6);
                String email= rs.getString(7);
                String chucvu= rs.getString(8);
                int solanravao=rs.getInt(9);
                int idCongTy=rs.getInt(10);
                int solanvao=rs.getInt(11);
                int solanra=rs.getInt(12);
                NhanVienCongTy NVcongTy=new NhanVienCongTy(id,diachi,hoten,gioitinh,cmt,ngaysinh,
                        email,chucvu,solanravao,idCongTy,solanvao,solanra);
                ans.add(NVcongTy);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }

    public List<NhanVienToaNha> thongKeNVToaNha() {
        List<NhanVienToaNha> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT * FROM NhanVienToaNha ORDER BY MucLuong DESC");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String diachi=rs.getString(2);
                String hoten=rs.getString(3);
                String gioitinh=rs.getString(4);
                String cmt=rs.getString(5);
                String ngaysinh= rs.getString(6);
                String email= rs.getString(7);
                String chucvu= rs.getString(8);
                String vaitro= rs.getString(9);
                int mucluong=rs.getInt(10);
                NhanVienToaNha NVtoanha=new NhanVienToaNha(id,diachi,hoten,gioitinh,cmt,ngaysinh,
                        email,chucvu,vaitro,mucluong);
                ans.add(NVtoanha);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public List<Phong> getAllPhong(){
        List<Phong> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT *from Phong");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String maPhong=rs.getString(1);
                float dientich=rs.getFloat(2);
                String tinhtrang=rs.getString(3);
                String loaiphong=rs.getString(4);
                float gia=rs.getFloat(5);
                String mota=rs.getString(6);
                String url_img=rs.getString(7);
                Phong phong=new Phong(maPhong,dientich,tinhtrang,loaiphong,gia,mota,url_img);
                ans.add(phong);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public List<Phong> searchPhongByTinhTrang(){
        List<Phong> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT *FROM Phong  WHERE TinhTrangPhong LIKE ?");
            preparedStatement.setString(1,"Chưa thuê");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String maPhong=rs.getString(1);
                float dientich=rs.getFloat(2);
                String tinhtrang=rs.getString(3);
                String loaiphong=rs.getString(4);
                float gia=rs.getFloat(5);
                String mota=rs.getString(6);
                String url_img=rs.getString(7);
                Phong phong=new Phong(maPhong,dientich,tinhtrang,loaiphong,gia,mota,url_img);
                ans.add(phong);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public int searchPhongChuaThue(){
        int ans=0;
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT COUNT(*) FROM Phong WHERE TinhTrangPhong LIKE ?");
            preparedStatement.setString(1,"Chưa thuê");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ans =rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public void addHopDong(HopDong hopDong){
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO HopDong(MaHopDong, " +
                    "IDKhachHang, NgayBatDauThue, MoTa,TienCoc_TrieuDong, ThoiHan_Thang,NgayKy,MaPhong)\n"
                    + "VALUES(?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, hopDong.getMaHopDong());
            preparedStatement.setInt(2, hopDong.getIdKhachHang());
            preparedStatement.setString(3, hopDong.getNgayBatDauThue());
            preparedStatement.setString(4, hopDong.getMoTa());
            preparedStatement.setFloat(5, hopDong.getTienCoc());
            preparedStatement.setInt(6, hopDong.getThoihan());
            preparedStatement.setString(7, hopDong.getNgayKy());
            preparedStatement.setInt(8, hopDong.getMaPhong());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public int searchIdNhanVienByCMND(String cmnd){
        int ans=0;
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT ID FROM NVCongTy  WHERE CMT LIKE ?");
            String tmp=cmnd;
            preparedStatement.setString(1,tmp);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ans=rs.getInt(1);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public String searchTenNhanVienByCMND(String cmnd){
        String ans="Không có dữ liệu";
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT HoTen FROM NVCongTy  WHERE CMT LIKE ?");
            String tmp=cmnd;
            preparedStatement.setString(1,tmp);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ans=rs.getString(1);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public void updateTinhTrangPhong(int maphong){
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("UPDATE Phong SET TinhTrangPhong = ? WHERE MaPhong = ?");
            preparedStatement.setString(1, "Đã thuê");
            preparedStatement.setInt(2, maphong);
            preparedStatement.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public String searchTenNhanVienById(int id){
        String ans="";
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT HoTen FROM NVCongTy  WHERE ID LIKE ?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ans=rs.getString(1);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public List<HoaDon> getAllHoaDon(){
        List<HoaDon> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT *from HoaDon");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String maHD=rs.getString(2);
                int idKhachHang=rs.getInt(3);
                String handong=rs.getString(4);
                String tinhtrang=rs.getString(5);
                String loaihoadon= rs.getString(6);
                float tongtien= rs.getFloat(7);
                String ngayxuat= rs.getString(8);
                String phuongthucthanhtoan= rs.getString(9);
                HoaDon hoaDon=new HoaDon(id,maHD,idKhachHang,handong,tinhtrang,loaihoadon,
                        tongtien,ngayxuat,phuongthucthanhtoan);
                ans.add(hoaDon);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }

    public List<HopDong> getAllHopDong() {
        List<HopDong> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT *from HopDong");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String maHD=rs.getString(2);
                int idKhachHang=rs.getInt(3);
                String ngaybatdauthue=rs.getString(4);
                String mota=rs.getString(5);
                float tiencoc= rs.getFloat(6);
                int thoihan=rs.getInt(7);
                String ngayky= rs.getString(8);
                int maphong=rs.getInt(9);
                HopDong hopDong=new HopDong(id,maHD,idKhachHang,ngaybatdauthue,mota,tiencoc,
                        thoihan,ngayky,maphong);
                ans.add(hopDong);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public void updateTinhTrangHoaDon(String maHoaDon,String phuongthuc){
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("UPDATE HoaDon SET TinhTrang = ?,PhuongThucThanhToan = ? WHERE MaHoaDon = ?");
            preparedStatement.setString(1, "Đã thanh toán");
            preparedStatement.setString(2, phuongthuc);
            preparedStatement.setString(3, maHoaDon);
            preparedStatement.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<HoaDon> searchHoaDonByIDKhachHang(int idNhanVien) {
        List<HoaDon> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT *FROM HoaDon  WHERE IDKhachHang LIKE ?");
            preparedStatement.setInt(1,idNhanVien);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String maHD=rs.getString(2);
                int idKhachHang=rs.getInt(3);
                String handong=rs.getString(4);
                String tinhtrang=rs.getString(5);
                String loaihoadon= rs.getString(6);
                float tongtien= rs.getFloat(7);
                String ngayxuat= rs.getString(8);
                String phuongthucthanhtoan= rs.getString(9);
                HoaDon hoaDon=new HoaDon(id,maHD,idKhachHang,handong,tinhtrang,loaihoadon,
                        tongtien,ngayxuat,phuongthucthanhtoan);
                ans.add(hoaDon);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }

    public List<HopDong> searchHopDongByIDKhachHang(int idNhanVien) {
        List<HopDong> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connect.prepareStatement("SELECT *FROM HopDong  WHERE IDKhachHang LIKE ?");
            preparedStatement.setInt(1,idNhanVien);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String maHD=rs.getString(2);
                int idKhachHang=rs.getInt(3);
                String ngaybatdauthue=rs.getString(4);
                String mota=rs.getString(5);
                float tiencoc= rs.getFloat(6);
                int thoihan=rs.getInt(7);
                String ngayky= rs.getString(8);
                int maphong=rs.getInt(9);
                HopDong hopDong=new HopDong(id,maHD,idKhachHang,ngaybatdauthue,mota,tiencoc,
                        thoihan,ngayky,maphong);
                ans.add(hopDong);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public List<HoaDon> searchHoaDonByTinhTrang(){
        List<HoaDon> ans=new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT *FROM HoaDon  WHERE TinhTrang LIKE ?");
            preparedStatement.setString(1,"Chưa thanh toán");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id=rs.getInt(1);
                String maHD=rs.getString(2);
                int idKhachHang=rs.getInt(3);
                String handong=rs.getString(4);
                String tinhtrang=rs.getString(5);
                String loaihoadon= rs.getString(6);
                float tongtien= rs.getFloat(7);
                String ngayxuat= rs.getString(8);
                String phuongthucthanhtoan= rs.getString(9);
                HoaDon hoaDon=new HoaDon(id,maHD,idKhachHang,handong,tinhtrang,loaihoadon,
                        tongtien,ngayxuat,phuongthucthanhtoan);
                ans.add(hoaDon);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
}
