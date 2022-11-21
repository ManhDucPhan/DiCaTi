/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SanPham;
import repository.SanPhamRepository;
import service.SanPhamService;
import viewModel.ViewSanPham;

/**
 *
 * @author Dell
 */
public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository sanPhanRepo = new SanPhamRepository();

    @Override
    public List<ViewSanPham> getAll() {
        try {
            return sanPhanRepo.getAll();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<ViewSanPham> getAllXoa() {
        try {
            return sanPhanRepo.getAllXoa();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Integer addSP(SanPham sp) {
        try {
            return sanPhanRepo.addSP(sp);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Integer updateSP(SanPham sp) {
        try {
            return sanPhanRepo.updateSP(sp);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Integer deleteSP(String sp) {
        try {
            return sanPhanRepo.deleteSP(sp);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Integer hoanTacSP(SanPham sp) {
        try {
            return sanPhanRepo.hoanTacSP(sp);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<SanPham> getThongTin(String maSp) {
        try {
            return sanPhanRepo.getThongTin(maSp);
        } catch (Exception ex) {
            return null;
        }
    }

//    @Override
//    public Integer updateSL(SanPham sanPham) {
//        try {
//            return sanPhanRepo.updateSoLuong(sanPham);
//        } catch (SQLException ex) {
//            return null;
//        }
//    }

}
