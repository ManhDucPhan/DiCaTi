/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.HoaDon;

/**
 *
 * @author phamtuyetnga
 */
public interface HoaDonService {
     Boolean saveHoaDon(HoaDon hoaDon);
     
     ArrayList<HoaDon> getList();
     
     Integer updateHD(HoaDon hoaDon);
}
