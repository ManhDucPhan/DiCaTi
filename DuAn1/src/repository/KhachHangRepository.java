/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.KhachHang;
import ultility.DBContext;
import viewModel.KhachHangViewModel;

/**
 *
 * @author phamtuyetnga
 */
public class KhachHangRepository {
     private DBContext dbContex;
    public ArrayList<KhachHangViewModel> getAll() throws SQLException{
        ArrayList<KhachHangViewModel> list = new ArrayList<>();
        
        String sql = "select MaKH, HoTen, SDT, NgaySinh, DiaChi, GioiTinh, TrangThai, GhiChu, SoLanMua from KhachHang";
        Connection connection = dbContex.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            KhachHangViewModel kh = new KhachHangViewModel();
            kh.setMaKhachHang(rs.getString(1));
            kh.setHoTenKhachHang(rs.getString(2));
            kh.setSdt(rs.getString(3));
            kh.setNgaySinh(rs.getDate(4));
            kh.setDiaChi(rs.getString(5));
            kh.setGioiTinh(rs.getInt(6));
            kh.setTrangThai(rs.getInt(7));
            kh.setGhiCHu(rs.getString(8));
            kh.setSoLanMua(rs.getInt(9));
            list.add(kh);
            
        }
        return list;
    }
    public ArrayList<KhachHangViewModel> getAllKhXoa() throws SQLException{
        ArrayList<KhachHangViewModel> list = new ArrayList<>();
        
        String sql = "select MaKH, HoTen, SDT, NgaySinh, DiaChi, GioiTinh, TrangThai, GhiChu, SoLanMua from KhachHang where TrangThai=0";
        Connection connection = dbContex.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            KhachHangViewModel kh = new KhachHangViewModel();
            kh.setMaKhachHang(rs.getString(1));
            kh.setHoTenKhachHang(rs.getString(2));
            kh.setSdt(rs.getString(3));
            kh.setNgaySinh(rs.getDate(4));
            kh.setDiaChi(rs.getString(5));
            kh.setGioiTinh(rs.getInt(6));
            kh.setTrangThai(rs.getInt(7));
            kh.setGhiCHu(rs.getString(8));
            kh.setSoLanMua(rs.getInt(9));
            list.add(kh);
            
        }
        return list;
    }
    
    
    public boolean addKH(KhachHang kh) throws SQLException{
        String sql = "INSERT INTO KhachHang(MaKH, HoTen, SDT, NgaySinh, DiaChi, GioiTinh, TrangThai, GhiChu, SoLanMua) VALUES(?,?,?,?,?,?,?,?,?)";
        Connection connection = dbContex.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, kh.getMaKhachHang());
        ps.setString(2, kh.getHoTenKhachHang());
        ps.setString(3, kh.getSdt());
        ps.setObject(4, kh.getNgaySinh());
        ps.setString(5, kh.getDiaChi());
        ps.setInt(6, kh.getGioiTinh());
        ps.setInt(7, kh.getTrangThai());
        ps.setString(8, kh.getGhiCHu());
        ps.setInt(9, kh.getSoLanMua());

        return ps.executeUpdate()>0;
    }
    public boolean suaKH(KhachHang kh) throws SQLException{
        String sql = "UPDATE KhachHang  set HoTen=?, SDT=?, NgaySinh=?, DiaChi =?, GioiTinh=?, TrangThai=?, GhiChu=?, SoLanMua=? WHERE MaKH = ?";
        Connection connection = dbContex.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(9, kh.getMaKhachHang());
        ps.setString(1, kh.getHoTenKhachHang());
        ps.setString(2, kh.getSdt());
        ps.setObject(3, kh.getNgaySinh());
        ps.setString(4, kh.getDiaChi());
        ps.setInt(5, kh.getGioiTinh());
        ps.setInt(6, kh.getTrangThai());
        ps.setString(7, kh.getGhiCHu());
        ps.setInt(8, kh.getSoLanMua());

        return ps.executeUpdate()>0;
    }
    public boolean xoaKH(String ma) throws SQLException{
        String sql = "UPDATE KhachHang  set  TrangThai=? WHERE MaKH = ?";

        Connection connection = dbContex.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        
        ps.setString(2, ma);
        ps.setInt(1, 0);


        return ps.executeUpdate() > 0;
    }
     public KhachHang timKiemKH(String ma) throws SQLException {
        String sql = "select  HoTen, SDT, NgaySinh, DiaChi, GioiTinh, TrangThai, GhiChu, SoLanMua from KhachHang where MaKH =?";
        Connection connection = dbContex.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, ma);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
           KhachHang kh = new KhachHang();
            kh.setMaKhachHang(ma);
            kh.setHoTenKhachHang(rs.getString(1));
            kh.setSdt(rs.getString(2));
            kh.setNgaySinh(rs.getDate(3));
            kh.setDiaChi(rs.getString(4));
            kh.setGioiTinh(rs.getInt(5));
            kh.setTrangThai(rs.getInt(6));
            kh.setGhiCHu(rs.getString(7));
            kh.setSoLanMua(rs.getInt(8));
            
            return kh;
        }
        return null;
    }
}
