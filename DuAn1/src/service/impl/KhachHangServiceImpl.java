/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.KhachHang;
import repository.KhachHangRepository;
import service.KhachHangService;
import viewModel.KhachHangViewModel;

/**
 *
 * @author phamtuyetnga
 */
public class KhachHangServiceImpl implements KhachHangService {

    private KhachHangRepository khachHnagRepository = new KhachHangRepository();

    @Override
    public ArrayList<KhachHangViewModel> getAllKhachHang() {
        try {
            return khachHnagRepository.getAll();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean themKhachHang(KhachHang kh) {
        try {
            return khachHnagRepository.addKH(kh);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean suaKhachHang(KhachHang kh) {
        try {
            return khachHnagRepository.suaKH(kh);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean xoaKhachHang(String ma) {
        try {
            return khachHnagRepository.xoaKH(ma);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public KhachHang timKiemKhachHang(String ma) {
        try {
            return khachHnagRepository.timKiemKH(ma);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public ArrayList<KhachHangViewModel> getAllKhDaXoa() {
        try {
            return khachHnagRepository.getAllKhXoa();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
