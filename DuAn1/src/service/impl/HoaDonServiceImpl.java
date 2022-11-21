/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import repository.HoaDonRepository;
import service.HoaDonService;

/**
 *
 * @author phamtuyetnga
 */
public class HoaDonServiceImpl implements HoaDonService{

    private final HoaDonRepository hoaDonRepo = new HoaDonRepository();
    @Override
    public Boolean saveHoaDon(HoaDon hoaDon) {
        return hoaDonRepo.saveHoaDon(hoaDon);
    }

    @Override
    public ArrayList<HoaDon> getList() {
        return hoaDonRepo.getListHoaDon();
    }

    @Override
    public Integer updateHD(HoaDon hoaDon) {
        try {
            return hoaDonRepo.updateHoaDon(hoaDon);
        } catch (SQLException ex) {
           return null;
        }
    }
    
}
