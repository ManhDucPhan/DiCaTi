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
import java.util.List;
import ultility.DBContext;
import viewModel.DungLuongViewModel;
import viewModel.ManHinhViewModel;

/**
 *
 * @author Admin
 */
public class ManHinhRepository {
    public ArrayList<ManHinhViewModel> getAll() throws SQLException {
        ArrayList<ManHinhViewModel> listMH = new ArrayList<>();
        String sql = "SELECT MaMH, TenMH FROM ManHinh WHERE TrangThai = '0'";
        Connection conn = DBContext.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            ManHinhViewModel chip = new ManHinhViewModel();
            chip.setMa(rs.getString(1));
            chip.setTen(rs.getString(2));
            listMH.add(chip);
        }
        return listMH;
    }

    public boolean create(ManHinhViewModel mh) throws SQLException {
        String sql = "INSERT INTO ManHinh (MaMH, TenMH, TrangThai) VALUES (?,?,0)";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement stm = conn.prepareStatement(sql);) {
           stm.setString(1, mh.getMa());
           stm.setString(2, mh.getTen());
           stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
     public boolean update(ManHinhViewModel mh) throws SQLException {
        String sql = "UPDATE ManHinh SET TenMH = ? WHERE MaMH =? ";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement stm = conn.prepareStatement(sql);) {
           stm.setString(1, mh.getTen());
           stm.setString(2, mh.getMa());
           stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
     public ArrayList<ManHinhViewModel> getAllXoa() throws SQLException {
        ArrayList<ManHinhViewModel> listdl = new ArrayList<>();
        String sql = "SELECT MaMH, TenMH FROM ManHinh WHERE TrangThai = '1' ";
        Connection conn = DBContext.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            ManHinhViewModel mh = new ManHinhViewModel();
            mh.setMa(rs.getString(1));
            mh.setTen(rs.getString(2));
            listdl.add(mh);
        }
        return listdl;
    }
     public boolean updateTT(ManHinhViewModel mh )throws SQLException {
        String sql = "UPDATE ManHinh SET TrangThai = '1' WHERE MaMH =? ";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement stm = conn.prepareStatement(sql);) {
           //stm.setString(1, chip.getTen());
           stm.setString(1, mh.getMa());
           stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
     public boolean updateTT3(ManHinhViewModel mh) throws SQLException {
        String sql = "UPDATE ManHinh SET TrangThai = '0' WHERE MaMH =? ";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement stm = conn.prepareStatement(sql);) {
           stm.setString(1, mh.getMa());
           stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
}
