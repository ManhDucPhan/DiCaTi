/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

/**
 *
 * @author Admin
 */
public class ImeiViewModel {

    private String maImei;
    private int trangThai;
    private String id_Sp;

    public ImeiViewModel() {
    }

    public ImeiViewModel(String maImei, int trangThai, String id_Sp) {
        this.maImei = maImei;
        this.trangThai = trangThai;
        this.id_Sp = id_Sp;
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

    

    public String TrangThai2() {
        if (trangThai == 0) {
            return "Online";
        } else if (trangThai == 1) {
            return "Offline";
        } else if (trangThai == 2) {
            return "Đang chờ hàng về";
        } else {
            return "Ngừng bán";
        }
    }
}
