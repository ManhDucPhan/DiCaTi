/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.SanPham;
import viewModel.ViewSanPham;

/**
 *
 * @author Dell
 */
public interface SanPhamService {

    List<ViewSanPham> getAll();

    List<ViewSanPham> getAllXoa();

    Integer addSP(SanPham sp);

    Integer updateSP(SanPham sp);

    Integer deleteSP(String sp);

    Integer hoanTacSP(SanPham sp);

    List<SanPham> getThongTin(String maSp);
    
//    Integer updateSL(SanPham sanPham);
}
