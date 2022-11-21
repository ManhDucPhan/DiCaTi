/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Imei {
    private String id;
    private String maImei;
    private int trangThai;
    private String id_Sp;

    public Imei() {
    }

    public Imei(String id, String maImei, int trangThai, String id_Sp) {
        this.id = id;
        this.maImei = maImei;
        this.trangThai = trangThai;
        this.id_Sp = id_Sp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaImei() {
        return maImei;
    }

    public void setMaImei(String maImei) {
        this.maImei = maImei;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getId_Sp() {
        return id_Sp;
    }

    public void setId_Sp(String id_Sp) {
        this.id_Sp = id_Sp;
    }

   
    
}
