/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;
import java.util.ArrayList;
import java.util.List;
import model.Imei;
import viewModel.ImeiViewModel;

/**
 *
 * @author Admin
 */
public interface ImeiService {
    ArrayList<ImeiViewModel> getAll();

    ArrayList<ImeiViewModel> getAllXoa();

    boolean addImei(Imei imei );

    boolean update(Imei imei);

    boolean delete(String imei);

    boolean hoanTac(Imei imei);
}
