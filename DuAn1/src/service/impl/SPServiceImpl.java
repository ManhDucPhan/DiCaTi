/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import repository.SPRepository;
import viewModel.SanPhamViewModel;
import service.SPService;

/**
 *
 * @author phamtuyetnga
 */
public class SPServiceImpl implements SPService{

    private final SPRepository sanPhamRepo = new SPRepository();
    @Override
    public ArrayList<SanPhamViewModel> getAll() {
        return sanPhamRepo.getAll();
    }
    
}
