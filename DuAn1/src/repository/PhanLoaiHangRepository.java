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
import ultility.DBContext;
import viewModel.KichThuocViewModel;
import viewModel.PhanLoaiHangViewModel;

/**
 *
 * @author ADMIN
 */
public class PhanLoaiHangRepository {
    
    public ArrayList<PhanLoaiHangViewModel> getAll() throws SQLException {
        ArrayList<PhanLoaiHangViewModel> listChip = new ArrayList<>();
        String sql = "SELECT MaLH, TenLH FROM PhanLoaiHang WHERE TrangThai = '0'";
        Connection conn = DBContext.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            PhanLoaiHangViewModel chip = new PhanLoaiHangViewModel();
            chip.setMa(rs.getString(1));
            chip.setTen(rs.getString(2));
            listChip.add(chip);
        }
        return listChip;
    }

    public boolean create(PhanLoaiHangViewModel dl) throws SQLException {
        String sql = "INSERT INTO PhanLoaiHang (MaLH, TenLH, TrangThai) VALUES (?,?,0)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement stm = conn.prepareStatement(sql);) {
           stm.setString(1, dl.getMa());
           stm.setString(2, dl.getTen());
           stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
     public boolean update(PhanLoaiHangViewModel dl) throws SQLException {
        String sql = "UPDATE PhanLoaiHang SET TenLH = ? WHERE MaLH =? ";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement stm = conn.prepareStatement(sql);) {
           stm.setString(1, dl.getTen());
           stm.setString(2, dl.getMa());
           stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
     public ArrayList<PhanLoaiHangViewModel> getAllXoa() throws SQLException {
        ArrayList<PhanLoaiHangViewModel> listdl = new ArrayList<>();
        String sql = "SELECT MaLH, TenLH FROM PhanLoaiHang WHERE TrangThai = '1' ";
        Connection conn = DBContext.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            PhanLoaiHangViewModel dl = new PhanLoaiHangViewModel();
            dl.setMa(rs.getString(1));
            dl.setTen(rs.getString(2));
            listdl.add(dl);
        }
        return listdl;
    }
     public boolean updateTT(PhanLoaiHangViewModel dl) throws SQLException {
        String sql = "UPDATE PhanLoaiHang SET TrangThai = '1' WHERE MaLH =? ";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement stm = conn.prepareStatement(sql);) {
           //stm.setString(1, chip.getTen());
           stm.setString(1, dl.getMa());
           stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
     public boolean updateTT3(PhanLoaiHangViewModel dl) throws SQLException {
        String sql = "UPDATE PhanLoaiHang SET TrangThai = '0' WHERE MaLH =? ";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement stm = conn.prepareStatement(sql);) {
           stm.setString(1, dl.getMa());
           stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
}
