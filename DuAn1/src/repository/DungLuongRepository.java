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
import model.DungLuong;
import ultility.DBContext;
import viewModel.DungLuongViewModel;

/**
 *
 * @author phamtuyetnga
 */
public class DungLuongRepository {
      public ArrayList<DungLuongViewModel> getAll() throws SQLException {
        ArrayList<DungLuongViewModel> listChip = new ArrayList<>();
        String sql = "SELECT MaDL, TenDL FROM DungLuong WHERE TrangThai = '0'";
        Connection conn = DBContext.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            DungLuongViewModel chip = new DungLuongViewModel();
            chip.setMa(rs.getString(1));
            chip.setTen(rs.getString(2));
            listChip.add(chip);
        }
        return listChip;
    }

    public boolean create(DungLuongViewModel dl) throws SQLException {
        String sql = "INSERT INTO DungLuong (MaDL, TenDL, TrangThai) VALUES (?,?,0)";
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
     public boolean update(DungLuongViewModel dl) throws SQLException {
        String sql = "UPDATE DungLuong SET TenDL = ? WHERE MaDL =? ";
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
     public ArrayList<DungLuongViewModel> getAllXoa() throws SQLException {
        ArrayList<DungLuongViewModel> listdl = new ArrayList<>();
        String sql = "SELECT MaDL, TenDL FROM DungLuong WHERE TrangThai = '1' ";
        Connection conn = DBContext.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            DungLuongViewModel dl = new DungLuongViewModel();
            dl.setMa(rs.getString(1));
            dl.setTen(rs.getString(2));
            listdl.add(dl);
        }
        return listdl;
    }
     public boolean updateTT(DungLuongViewModel dl) throws SQLException {
        String sql = "UPDATE DungLuong SET TrangThai = '1' WHERE MaDL =? ";
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
     public boolean updateTT3(DungLuongViewModel dl) throws SQLException {
        String sql = "UPDATE DungLuong SET TrangThai = '0' WHERE MaDL =? ";
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
