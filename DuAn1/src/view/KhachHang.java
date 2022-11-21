/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import service.KhachHangService;
import service.impl.KhachHangServiceImpl;
import viewModel.KhachHangViewModel;

/**
 *
 * @author phamtuyetnga
 */
public class KhachHang extends javax.swing.JPanel {
    
    public KhachHang() {
        initComponents();
        loadTable(khachHangSevice.getAllKhachHang());
        loadTableDaXoa(khachHangSevice.getAllKhDaXoa());
    }
    private KhachHangService khachHangSevice = new KhachHangServiceImpl();
    
    private void loadTable(ArrayList<KhachHangViewModel> list) {
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có dữ liệu", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (list == null) {
            JOptionPane.showMessageDialog(this, "Lỗi dữ liệu", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tblThongTin.getModel();
        model.setColumnCount(0);
        model.addColumn("MÃ KH");
        model.addColumn("HỌ TÊN KH");
        model.addColumn("SĐT");
        model.addColumn("NGÀY SINH");
        model.addColumn("ĐỊA CHỈ");
        model.addColumn("GIỚI TÍNH");
        model.addColumn("TRẠNG THÁI");
        model.addColumn("GHI CHÚ");
        model.addColumn("SỐ LẦN MUA");
        
        model.setRowCount(0);
        for (KhachHangViewModel kh : list) {
            model.addRow(new Object[]{
                kh.getMaKhachHang(),
                kh.getHoTenKhachHang(),
                kh.getSdt(),
                kh.getNgaySinh(),
                kh.getDiaChi(),
                kh.getGioiTinh() == 1 ? "Nam" : "Nữ",
                kh.getTrangThai() == 1 ? "Mới" : "Thân quen",
                kh.getGhiCHu(),
                kh.getSoLanMua()
            });
        }
        
    }
    
    private void loadTableDaXoa(ArrayList<KhachHangViewModel> list) {
        
        DefaultTableModel model = (DefaultTableModel) tblKhachHangDaXoa.getModel();
        model.setColumnCount(0);
        model.addColumn("MÃ KH");
        model.addColumn("HỌ TÊN KH");
        model.addColumn("SĐT");
        model.addColumn("NGÀY SINH");
        model.addColumn("ĐỊA CHỈ");
        model.addColumn("GIỚI TÍNH");
        model.addColumn("TRẠNG THÁI");
        model.addColumn("GHI CHÚ");
        model.addColumn("SỐ LẦN MUA");
        
        model.setRowCount(0);
        for (KhachHangViewModel kh : list) {
            model.addRow(new Object[]{
                kh.getMaKhachHang(), kh.getHoTenKhachHang(), kh.getSdt(), kh.getNgaySinh(),
                kh.getDiaChi(), kh.getGioiTinh(), kh.getTrangThai(), kh.getGhiCHu(), kh.getSoLanMua()
            });
        }
        
    }
    
    private boolean checkSDT() {
        String sdt = txtSoDienThoai.getText().trim();
        String pater = "([0-9]{10,11})";
        if (sdt.matches(pater)) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean checkRong() {
        if (txtMaKhachHang.getText().trim().isEmpty() && txtHoTen.getText().trim().isEmpty() && txtSoDienThoai.getText().trim().isEmpty()
                && txtNgaySinh.getText().trim().isEmpty() && txtDiaChi.getText().trim().isEmpty() && txtGhiChu.getText().trim().isEmpty()
                && txtSoLuongMua.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DỮ LIỆU CÁC Ô KHÔNG ĐƯỢC ĐỂ RỖNG!", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtMaKhachHang.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DỮ LIỆU CÁC Ô KHÔNG ĐƯỢC ĐỂ RỖNG!", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtHoTen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DỮ LIỆU Ô HỌ TÊN KHÔNG ĐƯỢC ĐỂ RỖNG!", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtSoDienThoai.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DỮ LIỆU Ô SĐT KHÔNG ĐƯỢC ĐỂ RỖNG!", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (checkSDT() == false) {
            JOptionPane.showMessageDialog(this, "DỮ LIỆU Ô SĐT SAI ĐỊNH DẠNG!", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtNgaySinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DỮ LIỆU Ô NGÀY SINH KHÔNG ĐƯỢC ĐỂ RỖNG!", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtDiaChi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DỮ LIỆU Ô ĐỊA CHỈ KHÔNG ĐƯỢC ĐỂ RỖNG!", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (rdThanQuen.isSelected() == false && rdMoi.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "DỮ LIỆU Ô TRẠNG THÁI KHÔNG ĐƯỢC ĐỂ RỖNG!", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtGhiChu.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DỮ LIỆU Ô GHI CHÚ KHÔNG ĐƯỢC ĐỂ RỖNG!", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txtSoLuongMua.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DỮ LIỆU Ô SỐ LƯỢNG MUA KHÔNG ĐƯỢC ĐỂ RỖNG!", "THÔNG BÁO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pan2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSoLuongMua = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rdnam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        tbnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        rdThanQuen = new javax.swing.JRadioButton();
        rdMoi = new javax.swing.JRadioButton();
        txtMaKhachHang = new javax.swing.JTextField();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblThongTin = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHangDaXoa = new javax.swing.JTable();
        btnHoanTac = new javax.swing.JButton();
        tbnSua1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        pan2.setBackground(new java.awt.Color(36, 47, 65));
        pan2.setForeground(new java.awt.Color(255, 255, 255));
        pan2.setPreferredSize(new java.awt.Dimension(1500, 779));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã Khách Hàng");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Họ Tên");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Số Điện Thoại");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ngày Sinh");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Địa Chỉ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Giới Tính");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Trạng Thái");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Số Lượng Mua");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ghi Chú");

        rdnam.setBackground(new java.awt.Color(97, 212, 195));
        buttonGroup1.add(rdnam);
        rdnam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdnam.setForeground(new java.awt.Color(255, 255, 255));
        rdnam.setText("Nam");

        rdNu.setBackground(new java.awt.Color(97, 212, 195));
        buttonGroup1.add(rdNu);
        rdNu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdNu.setForeground(new java.awt.Color(255, 255, 255));
        rdNu.setText("Nữ");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add (2).png"))); // NOI18N
        btnThem.setPreferredSize(new java.awt.Dimension(100, 30));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        tbnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tbnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update (2).png"))); // NOI18N
        tbnSua.setPreferredSize(new java.awt.Dimension(100, 30));
        tbnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delele.png"))); // NOI18N
        btnXoa.setPreferredSize(new java.awt.Dimension(100, 30));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        rdThanQuen.setBackground(new java.awt.Color(97, 212, 195));
        buttonGroup2.add(rdThanQuen);
        rdThanQuen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdThanQuen.setForeground(new java.awt.Color(255, 255, 255));
        rdThanQuen.setText("Thân Quen");
        rdThanQuen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdThanQuenActionPerformed(evt);
            }
        });

        rdMoi.setBackground(new java.awt.Color(97, 212, 195));
        buttonGroup2.add(rdMoi);
        rdMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdMoi.setForeground(new java.awt.Color(255, 255, 255));
        rdMoi.setText("Mới");

        tblThongTin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongTinMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblThongTin);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Thông Tin Khách Hàng", jPanel3);

        tblKhachHangDaXoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKhachHangDaXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangDaXoaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhachHangDaXoa);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Khách hàng Đã Xóa", jPanel4);

        btnHoanTac.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHoanTac.setText("Hoàn tác");
        btnHoanTac.setPreferredSize(new java.awt.Dimension(100, 30));
        btnHoanTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanTacActionPerformed(evt);
            }
        });

        tbnSua1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tbnSua1.setText("Tìm kiếm");
        tbnSua1.setPreferredSize(new java.awt.Dimension(100, 30));
        tbnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSua1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KHÁCH HÀNG");

        javax.swing.GroupLayout pan2Layout = new javax.swing.GroupLayout(pan2);
        pan2.setLayout(pan2Layout);
        pan2Layout.setHorizontalGroup(
            pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan2Layout.createSequentialGroup()
                .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pan2Layout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(tbnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnHoanTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan2Layout.createSequentialGroup()
                        .addGap(481, 481, 481)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pan2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(46, 46, 46)
                        .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pan2Layout.createSequentialGroup()
                                .addComponent(rdnam, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(rdNu, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pan2Layout.createSequentialGroup()
                                .addComponent(rdMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(rdThanQuen))
                            .addComponent(txtSoLuongMua, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61)
                        .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        pan2Layout.setVerticalGroup(
            pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan2Layout.createSequentialGroup()
                .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pan2Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdnam)
                            .addComponent(rdNu))
                        .addGap(30, 30, 30)
                        .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdMoi)
                            .addComponent(rdThanQuen))
                        .addGap(30, 30, 30)
                        .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuongMua, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pan2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pan2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(tbnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHoanTac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pan2, javax.swing.GroupLayout.PREFERRED_SIZE, 1375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pan2, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
//        if (checkRong()) {
//            try {
//                model.KhachHang kh = new model.KhachHang();
//                kh.setMaKhachHang(txtMaKhachHang.getText().trim());
//                kh.setHoTenKhachHang(txtHoTen.getText().trim());
//                kh.setSdt(txtSoDienThoai.getText().trim());
//                SimpleDateFormat ngaySinh = new SimpleDateFormat("yyyy-MM-dd");
//
//                kh.setNgaySinh(ngaySinh.parse(txtNgaySinh.getText().trim()));
//
//                kh.setDiaChi(txtDiaChi.getText().trim());
//                kh.setGioiTinh(rdnam.isSelected() ? "Nam" : "Nữ");
//                kh.setTrangThai(rdThanQuen.isSelected() ? "Mới" : "Thân quen");
//                kh.setGhiCHu(txtGhiChu.getText().trim());
//                kh.setSoLanMua(Integer.parseInt(txtSoLuongMua.getText().trim()));
//
//                khachHangSevice.themKhachHang(kh);
//                JOptionPane.showMessageDialog(this, "Thêm thành công");
//                loadTable(khachHangSevice.getAllKhachHang());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        if (checkRong()) {
            try {
                model.KhachHang kh = new model.KhachHang();
                kh.setMaKhachHang(txtMaKhachHang.getText().trim());
                kh.setHoTenKhachHang(txtHoTen.getText().trim());
                kh.setSdt(txtSoDienThoai.getText().trim());
                SimpleDateFormat ngaySinh = new SimpleDateFormat("yyyy-MM-dd");
                
                kh.setNgaySinh(ngaySinh.parse(txtNgaySinh.getText().trim()));
                
                kh.setDiaChi(txtDiaChi.getText().trim());
                kh.setGioiTinh(rdnam.isSelected() ? 0 : 1);
                kh.setTrangThai(rdThanQuen.isSelected() ? 0 : 1);
                kh.setGhiCHu(txtGhiChu.getText().trim());
                kh.setSoLanMua(Integer.parseInt(txtSoLuongMua.getText().trim()));
                
                khachHangSevice.themKhachHang(kh);
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                loadTable(khachHangSevice.getAllKhachHang());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Xác nhận xoá", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (khachHangSevice.xoaKhachHang(txtMaKhachHang.getText().trim())) {
                JOptionPane.showMessageDialog(this, "XOÁ THÀNH CÔNG");
                loadTable(khachHangSevice.getAllKhachHang());
                loadTableDaXoa(khachHangSevice.getAllKhDaXoa());
            } else {
                JOptionPane.showMessageDialog(this, "XOÁ THẤT BẠI");
            }
        }

//        khachHangSevice.xoaKhachHang(txtMaKhachHang.getText());
//        loadTable(khachHangSevice.getAllKhachHang());
//        loadTableDaXoa(khachHangSevice.getAllKhDaXoa());
//        JOptionPane.showMessageDialog(this, "Xoá Thành Công");
// int row = tblThongTin.getSelectedRow();
//        if (row < 0) {
//            JOptionPane.showMessageDialog(this, "Mời chọn bản ghi cần xoá");
//            return;
//        }
//
//        String sp = tblThongTin.getValueAt(row, 0).toString();
//        khachHangSevice.xoaKhachHang(sp);
//        JOptionPane.showMessageDialog(this, "Xoá thành công");
//        loadTable(khachHangSevice.getAllKhachHang());
//        loadTableDaXoa(khachHangSevice.getAllKhDaXoa());

    }//GEN-LAST:event_btnXoaActionPerformed

    private void rdThanQuenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdThanQuenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdThanQuenActionPerformed

    private void tbnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSuaActionPerformed
        if (checkRong()) {
            try {
                model.KhachHang kh = new model.KhachHang();
                kh.setMaKhachHang(txtMaKhachHang.getText().trim());
                kh.setHoTenKhachHang(txtHoTen.getText().trim());
                kh.setSdt(txtSoDienThoai.getText().trim());
                SimpleDateFormat ngaySinh = new SimpleDateFormat("yyyy-MM-dd");
                
                kh.setNgaySinh(ngaySinh.parse(txtNgaySinh.getText().trim()));
                
                kh.setDiaChi(txtDiaChi.getText().trim());
                kh.setGioiTinh(rdnam.isSelected() ? 0 : 1);
                kh.setTrangThai(rdThanQuen.isSelected() ? 0 : 1);
                kh.setGhiCHu(txtGhiChu.getText().trim());
                kh.setSoLanMua(Integer.parseInt(txtSoLuongMua.getText().trim()));
                
                khachHangSevice.suaKhachHang(kh);
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                loadTable(khachHangSevice.getAllKhachHang());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tbnSuaActionPerformed

    private void btnHoanTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanTacActionPerformed

    }//GEN-LAST:event_btnHoanTacActionPerformed
    
    private void clickTableDaXoa(int row, JTable table) {
        txtMaKhachHang.setText(table.getValueAt(row, 0).toString());
        txtHoTen.setText(table.getValueAt(row, 1).toString());
        txtSoDienThoai.setText(table.getValueAt(row, 2).toString());
        txtNgaySinh.setText(table.getValueAt(row, 3).toString());
        txtDiaChi.setText(table.getValueAt(row, 4).toString());
        if (table.getValueAt(row, 5).equals(0)) {
            rdnam.setSelected(true);
        } else if (table.getValueAt(row, 5).equals(1)) {
            rdNu.setSelected(true);
        }
        if (table.getValueAt(row, 5).equals(0) == false && table.getValueAt(row, 5).equals(1) == false) {
            rdnam.setSelected(false);
            rdNu.setSelected(false);
        }
        if (table.getValueAt(row, 6).equals(0)) {
            rdThanQuen.setSelected(true);
        } else if (table.getValueAt(row, 6).equals(1)) {
            rdMoi.setSelected(true);
        } else {
            rdThanQuen.setSelected(false);
            rdMoi.setSelected(false);
        }
        txtGhiChu.setText(table.getValueAt(row, 7).toString());
        txtSoLuongMua.setText(table.getValueAt(row, 8).toString());
    }
    private void tblKhachHangDaXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangDaXoaMouseClicked
        int row = tblKhachHangDaXoa.getSelectedRow();
        clickTableDaXoa(row, tblKhachHangDaXoa);
    }//GEN-LAST:event_tblKhachHangDaXoaMouseClicked

    private void tblThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinMouseClicked
        int index = tblThongTin.getSelectedRow();
        txtMaKhachHang.setText(tblThongTin.getValueAt(index, 0).toString());
        txtHoTen.setText(tblThongTin.getValueAt(index, 1).toString());
        txtSoDienThoai.setText(tblThongTin.getValueAt(index, 2).toString());
        txtNgaySinh.setText(tblThongTin.getValueAt(index, 3).toString());
        txtDiaChi.setText(tblThongTin.getValueAt(index, 4).toString());
        if (tblThongTin.getValueAt(index, 5).toString().equals("Nam")) {
            rdnam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        
        if (tblThongTin.getValueAt(index, 6).toString().equals("Mới")) {
            rdMoi.setSelected(true);
        } else {
            rdThanQuen.setSelected(true);
        }
        txtGhiChu.setText(tblThongTin.getValueAt(index, 7).toString());
        txtSoLuongMua.setText(tblThongTin.getValueAt(index, 8).toString());
    }//GEN-LAST:event_tblThongTinMouseClicked

    private void tbnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSua1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbnSua1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoanTac;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JPanel pan2;
    private javax.swing.JRadioButton rdMoi;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JRadioButton rdThanQuen;
    private javax.swing.JRadioButton rdnam;
    private javax.swing.JTable tblKhachHangDaXoa;
    private javax.swing.JTable tblThongTin;
    private javax.swing.JButton tbnSua;
    private javax.swing.JButton tbnSua1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSoLuongMua;
    // End of variables declaration//GEN-END:variables
}
