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
import model.Imei;
import ultility.DBContext;
import viewModel.ImeiViewModel;

/**
 *
 * @author Admin
 */
public class ImeiRepository {

    public ArrayList<ImeiViewModel> getAll() throws SQLException {
        ArrayList<ImeiViewModel> listimei = new ArrayList<>();
        String sql = "select MaImei,TrangThai ,Id_Sp from IMEI";
        Connection conn = DBContext.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            ImeiViewModel ivm = new ImeiViewModel();
            ivm.setMaImei(rs.getString(1));
            ivm.setTrangThai(rs.getInt(2));
            ivm.setId_Sp(rs.getString(3));
            
            listimei.add(ivm);
        }
        return listimei;
    }

    public boolean addImei(Imei imei) throws SQLException {
        String sql = "insert into IMEI values(NEWID(), ?,?, (select Id from SanPham where TenSP = ?))";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement stm = conn.prepareStatement(sql);) {
            stm.setString(1, imei.getMaImei());
            stm.setInt(2, imei.getTrangThai());
            stm.setString(3, imei.getId_Sp());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public boolean update(Imei imei) throws SQLException {
        String sql = "update IMEI set TrangThai = ?, Id_Sp = (SELECT ID FROM SANPHAM WHERE TenSP = ?) where MaImei = ?";
        try ( Connection conn = DBContext.getConnection();  PreparedStatement stm = conn.prepareStatement(sql);) {
            stm.setInt(1, imei.getTrangThai());
            stm.setString(2, imei.getId_Sp());
            stm.setString(3, imei.getMaImei());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    public ArrayList<ImeiViewModel> getAllXoa() throws SQLException {
        ArrayList<ImeiViewModel> listivm = new ArrayList<>();
        String sql = "select MaImei ,Id_Sp from IMEI where TrangThai = '4'   ";
        Connection conn = DBContext.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            ImeiViewModel ivm = new ImeiViewModel();
            ivm.setMaImei(rs.getString(1));
//            ivm.setTrangThai(rs.getInt(2));
            ivm.setId_Sp(rs.getString(2));
            listivm.add(ivm);
        }
        return  listivm;
    }

   

    

//    public boolean updateTT3(ImeiViewModel ivms) throws SQLException {
//        String sql = "UPDATE CHIP SET TrangThai = 0,Id_Sp WHERE MaChip =? ";
//        try ( Connection conn = DBContext.getConnection();  PreparedStatement stm = conn.prepareStatement(sql);) {
//            stm.setString(1, ivms.getMaImei());
//            stm.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;

    
     public boolean delete(String imei) throws SQLException {
        
        String sql = "update IMEI set TrangThai = '4' where MaImei = ?";
         try {Connection con = DBContext.getConnection(); PreparedStatement stm = con.prepareStatement(sql);
             stm.setString(1, imei);
             stm.executeUpdate();
         } catch (Exception e) {
              e.printStackTrace();
            return false;
         }
         return true;
    }

    public boolean hoanTac(Imei imei) throws SQLException {
        
        String sql = "update IMEI set TrangThai = '0' where MaImei = ?";
        try {Connection con = DBContext.getConnection();PreparedStatement stm = con.prepareStatement(sql);
             stm.setString(1, imei.getMaImei());
             stm.executeUpdate();           
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;


    }
}
