/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.math.BigDecimal;
import model.SanPham;

/**
 *
 * @author phamtuyetnga
 */
public class HoaDonChiTiet {
    private SanPham sanPham;
    private String tenSP;
    private BigDecimal giaBan;
    private Integer soLuong;
    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(SanPham sanPham, String tenSP, BigDecimal giaBan, Integer soLuong) {
        this.sanPham = sanPham;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "sanPham=" + sanPham + ", tenSP=" + tenSP + ", giaBan=" + giaBan + ", soLuong=" + soLuong + '}';
    }
    
    
    
}
