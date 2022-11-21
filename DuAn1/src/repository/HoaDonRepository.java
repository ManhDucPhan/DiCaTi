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
import model.HoaDon;
import ultility.DBContext;

/**
 *
 * @author phamtuyetnga
 */
public class HoaDonRepository {

    private DBContext dBContext;

    public Boolean saveHoaDon(HoaDon hoaDon) {

        int checkInsert = 0;

        String sql = "INSERT INTO HoaDon(MaHD,NgayTao, TrangThai) VALUES(?,?,?)";
        try ( Connection con = dBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, hoaDon.getMaHD());
            ps.setObject(2, hoaDon.getNgayTao());
            ps.setObject(3, hoaDon.getTrangThai());
            checkInsert = ps.executeUpdate();
            return checkInsert > 0;

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
    
    
      public ArrayList<HoaDon> getListHoaDon() {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon";
        try ( Connection con = DBContext.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHD(rs.getString(2));
                hoaDon.setNgayTao(rs.getDate(4));
                hoaDon.setTrangThai(rs.getInt(12));

                list.add(hoaDon);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return list;
    }
      
      public Integer updateHoaDon(HoaDon hoaDon) throws SQLException {

        Connection con = DBContext.getConnection();
        String sql = "update HoaDon set TrangThai = 1 where MaHD = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setObject(1, hoaDon.getMaHD());

        int affectedRows = ps.executeUpdate();

        ps.close();
        con.close();

        return affectedRows;
    }
}
