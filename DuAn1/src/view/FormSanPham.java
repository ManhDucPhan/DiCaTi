/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import service.ChipService;
import service.DungLuongService;
import service.KichThuocService;
import service.ManHinhService;
import service.MauSacService;
import service.PhanLoaiHangService;
import service.PinService;
import service.RamService;
import service.SanPhamService;
import service.XuatXuService;
import service.impl.ChipServiceImpl;
import service.impl.DungLuongServiceImpl;
import service.impl.KichThuocServiceImpl;
import service.impl.ManHinhServiceImpl;
import service.impl.MauSacServiceImpl;
import service.impl.PhanLoaiHangServiceImpl;
import service.impl.PinServiceImpl;
import service.impl.RamServiceImpl;
import service.impl.SanPhamServiceImpl;
import service.impl.XuatXuServiceImpl;
import viewModel.ChipViewModel;
import viewModel.DungLuongViewModel;
import viewModel.KichThuocViewModel;
import viewModel.ManHinhViewModel;
import viewModel.MauSacViewModel;
import viewModel.PhanLoaiHangViewModel;
import viewModel.PinViewModel;
import viewModel.RamViewModel;
import viewModel.ViewSanPham;
import viewModel.XuatXuViewModel;

/**
 *
 * @author phamtuyetnga
 */
public class FormSanPham extends javax.swing.JPanel {

    public FormSanPham() {
        initComponents();
        loadTb();
        loadTbXoa();
        loadCbChip();
        loadCbDl();
        loadCbKt();
        loadCbMh();
        loadCbMs();
        loadCbPl();
        loadCbPin();
        loadCbRam();
        loadCbXx();
    }

    private final SanPhamService sanPhamSer = new SanPhamServiceImpl();
    private final ChipService chipSer = new ChipServiceImpl();
    private final DungLuongService dungLuongSer = new DungLuongServiceImpl();
    private final KichThuocService kichThuocSer = new KichThuocServiceImpl();
    private final ManHinhService manHinhSer = new ManHinhServiceImpl();
    private final MauSacService mauSacSer = new MauSacServiceImpl();
    private final PhanLoaiHangService phanLoaiHangSer = new PhanLoaiHangServiceImpl();
    private final PinService pinSer = new PinServiceImpl();
    private final RamService ramSer = new RamServiceImpl();
    private final XuatXuService xuatXuSer = new XuatXuServiceImpl();

    public void loadTb() {
        List<ViewSanPham> listSp = sanPhamSer.getAll();

        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (ViewSanPham x : listSp) {
            model.addRow(new Object[]{x.getMaSp(), x.getTenSp(), x.getPhanLoai(), x.getRam(), x.getPin(), x.getDungLuong(), x.getManHinh(), x.getSoLuong(), x.getGiaSp()});
        }
    }

    public void loadTbXoa() {
        List<ViewSanPham> listSp = sanPhamSer.getAllXoa();

        DefaultTableModel model = (DefaultTableModel) tblSp1.getModel();
        model.setRowCount(0);
        for (ViewSanPham x : listSp) {
            model.addRow(new Object[]{x.getMaSp(), x.getTenSp(), x.getPhanLoai(), x.getRam(), x.getPin(), x.getDungLuong(), x.getManHinh(), x.getSoLuong(), x.getGiaSp()});
        }
    }

    public void loadCbChip() {
        cbChip.removeAllItems();
        for (ChipViewModel x : chipSer.getAll()) {
            cbChip.addItem(x.getTen());
        }
    }

    public void loadCbDl() {
        cbDungLuong.removeAllItems();
        for (DungLuongViewModel x : dungLuongSer.getAll()) {
            cbDungLuong.addItem(x.getTen());
        }
    }

    public void loadCbKt() {
        cbKichThuoc.removeAllItems();
        for (KichThuocViewModel x : kichThuocSer.getAll()) {
            cbKichThuoc.addItem(x.getTen());
        }
    }

    public void loadCbMh() {
        cbxManHinh.removeAllItems();
        for (ManHinhViewModel x : manHinhSer.getAll()) {
            cbxManHinh.addItem(x.getTen());
        }
    }

    public void loadCbMs() {
        cbxMauSac.removeAllItems();
        for (MauSacViewModel x : mauSacSer.getAll()) {
            cbxMauSac.addItem(x.getTen());
        }
    }

    public void loadCbPl() {
        cbxPhanLoai.removeAllItems();
        for (PhanLoaiHangViewModel x : phanLoaiHangSer.getAll()) {
            cbxPhanLoai.addItem(x.getTen());
        }
    }

    public void loadCbPin() {
        cbxPin.removeAllItems();
        for (PinViewModel x : pinSer.getAll()) {
            cbxPin.addItem(x.getTen());
        }
    }

    public void loadCbRam() {
        cbxRam.removeAllItems();
        for (RamViewModel x : ramSer.getAll()) {
            cbxRam.addItem(x.getTen());
        }
    }

    public void loadCbXx() {
        cbxXuatXu.removeAllItems();
        for (XuatXuViewModel x : xuatXuSer.getAll()) {
            cbxXuatXu.addItem(x.getTen());
        }
    }

    public void loadTf(int i) {
        List<model.SanPham> list = sanPhamSer.getThongTin(tblSanPham.getValueAt(i, 0).toString());
        if (tblSanPham.getRowCount() > 0) {
            txtMaSp.setText(tblSanPham.getValueAt(i, 0).toString());
            txtTenSP.setText(tblSanPham.getValueAt(i, 1).toString());
            String giaBan = tblSanPham.getValueAt(i, 8).toString();
            String[] splitss = giaBan.split(".0000$");
            StringBuilder stringBuilder = new StringBuilder();
            for (String x : splitss) {
                stringBuilder.append(x);
            }
            txtGiaBna.setText(stringBuilder.toString());
            txtTonKho.setText(tblSanPham.getValueAt(i, 7).toString());
            for (model.SanPham sanPham : list) {
                String giaNhap = sanPham.getGiaNhap().toString();
                String[] splits = giaNhap.split(".0000$");
                StringBuilder stringBuilder1 = new StringBuilder();
                for (String x : splits) {
                    stringBuilder1.append(x);
                }
                txtGiaNhap.setText(stringBuilder1.toString());
                txtNamBH.setText(sanPham.getNamBH().toString());
                txtMoTa.setText(sanPham.getMoTa());
                cbChip.setSelectedItem(sanPham.getId_Chip());
                cbxMauSac.setSelectedItem(sanPham.getId_MauSac());
                cbKichThuoc.setSelectedItem(sanPham.getId_KhichThuoc());
                cbxXuatXu.setSelectedItem(sanPham.getId_XuatXu());
            }
            cbDungLuong.setSelectedItem(tblSanPham.getValueAt(i, 5).toString());
            cbxManHinh.setSelectedItem(tblSanPham.getValueAt(i, 6).toString());
            cbxPhanLoai.setSelectedItem(tblSanPham.getValueAt(i, 2).toString());
            cbxPin.setSelectedItem(tblSanPham.getValueAt(i, 4).toString());
            cbxRam.setSelectedItem(tblSanPham.getValueAt(i, 3).toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem2 = new javax.swing.JTextField();
        btnHoanTac = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSp1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtTimKiem1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        cbChip = new javax.swing.JComboBox<>();
        btnChip = new javax.swing.JButton();
        btnPhanLoaiHang = new javax.swing.JButton();
        cbxPhanLoai = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbDungLuong = new javax.swing.JComboBox<>();
        btnDungLuong = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        cbKichThuoc = new javax.swing.JComboBox<>();
        btnKichThuoc = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cbxManHinh = new javax.swing.JComboBox<>();
        btnManHinh = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        cbxPin = new javax.swing.JComboBox<>();
        btnPin = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        cbxRam = new javax.swing.JComboBox<>();
        btnRam = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        cbxXuatXu = new javax.swing.JComboBox<>();
        btnXuatXu = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        cbxMauSac = new javax.swing.JComboBox<>();
        btnMauSac = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtGiaBna = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtTonKho = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtNamBH = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        btnAdd = new javax.swing.JButton();
        btnXoA = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        txtMaSp = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(36, 47, 65));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("    SẢN PHẨM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1035, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Tìm kiếm ");

        txtTimKiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiem2ActionPerformed(evt);
            }
        });
        txtTimKiem2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiem2KeyReleased(evt);
            }
        });

        btnHoanTac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update (2).png"))); // NOI18N
        btnHoanTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanTacActionPerformed(evt);
            }
        });

        tblSp1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Loại", "Ram", "Pin", "Dung lượng", "Màn hình", "Số lượng", "Giá SP"
            }
        ));
        tblSp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSp1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSp1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHoanTac, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnHoanTac)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1217, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Đã xóa", jPanel5);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Tìm kiếm :");

        txtTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiem1ActionPerformed(evt);
            }
        });
        txtTimKiem1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiem1KeyReleased(evt);
            }
        });

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Loại", "RAM", "Pin", "Dung Lượng", "Màn hình", "Số lượng", "Giá bán"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        jLabel13.setText("Chip");

        cbChip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChipActionPerformed(evt);
            }
        });

        btnChip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/share_26px.png"))); // NOI18N
        btnChip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChipActionPerformed(evt);
            }
        });

        btnPhanLoaiHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/share_26px.png"))); // NOI18N
        btnPhanLoaiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanLoaiHangActionPerformed(evt);
            }
        });

        jLabel16.setText("Phân loại hàng");

        jLabel14.setText("Dung lượng");

        btnDungLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/share_26px.png"))); // NOI18N
        btnDungLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDungLuongActionPerformed(evt);
            }
        });

        jLabel15.setText("Kích thước");

        cbKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKichThuocActionPerformed(evt);
            }
        });

        btnKichThuoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/share_26px.png"))); // NOI18N
        btnKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKichThuocActionPerformed(evt);
            }
        });

        jLabel17.setText("Màn hình");

        btnManHinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/share_26px.png"))); // NOI18N
        btnManHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManHinhActionPerformed(evt);
            }
        });

        jLabel18.setText("Pin");

        btnPin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/share_26px.png"))); // NOI18N
        btnPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPinActionPerformed(evt);
            }
        });

        jLabel19.setText("Ram");

        btnRam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/share_26px.png"))); // NOI18N
        btnRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRamActionPerformed(evt);
            }
        });

        jLabel20.setText("Xuất xứ");

        btnXuatXu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/share_26px.png"))); // NOI18N
        btnXuatXu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatXuActionPerformed(evt);
            }
        });

        jLabel21.setText("Màu sắc");

        btnMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/share_26px.png"))); // NOI18N
        btnMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMauSacActionPerformed(evt);
            }
        });

        jLabel12.setText("Tên sản phẩm");

        jLabel22.setText("Giá nhập");

        jLabel23.setText("Giá bán");

        jLabel24.setText("Tồn kho");

        jLabel25.setText("Năm bảo hành");

        txtNamBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamBHActionPerformed(evt);
            }
        });

        jLabel26.setText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add (2).png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnXoA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delele.png"))); // NOI18N
        btnXoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoAActionPerformed(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update (2).png"))); // NOI18N
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        jLabel27.setText("Mã sản phẩm");

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update (2).png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbChip, 0, 150, Short.MAX_VALUE)
                                        .addComponent(btnChip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel16))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(btnDungLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(83, 83, 83)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(cbDungLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(114, 114, 114)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxRam, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnRam, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(btnPhanLoaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(cbxPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbxPin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbxManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(56, 56, 56)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbxMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(cbxXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtGiaBna, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtNamBH))
                            .addComponent(jLabel25)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnXoA, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaBna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)
                                .addComponent(jLabel21)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnXoA)
                            .addComponent(btnCapNhat)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMauSac)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel26)
                                            .addComponent(cbChip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbDungLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(btnChip, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(cbxPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbxPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(btnManHinh)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel20)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(btnDungLuong)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel18))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(btnKichThuoc)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel19)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(cbxRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbxXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)))))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAdd))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnPin)
                                            .addComponent(btnPhanLoaiHang)
                                            .addComponent(btnRam)
                                            .addComponent(btnXuatXu))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jButton13)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChipActionPerformed
        // TODO add your handling code here:
        new FormChip().setVisible(true);
    }//GEN-LAST:event_btnChipActionPerformed

    private void btnPhanLoaiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanLoaiHangActionPerformed
        // TODO add your handling code here:
        new FormPhanLoaiHang().setVisible(true);
    }//GEN-LAST:event_btnPhanLoaiHangActionPerformed

    private void btnDungLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDungLuongActionPerformed
        // TODO add your handling code here:
        new FormDungLuong().setVisible(true);
    }//GEN-LAST:event_btnDungLuongActionPerformed

    private void btnKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKichThuocActionPerformed
        // TODO add your handling code here:
        new FormKichThuoc().setVisible(true);
    }//GEN-LAST:event_btnKichThuocActionPerformed

    private void btnManHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManHinhActionPerformed
        // TODO add your handling code here:
        new FormManHinh().setVisible(true);
    }//GEN-LAST:event_btnManHinhActionPerformed

    private void btnPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPinActionPerformed
        // TODO add your handling code here:
        new FormPin().setVisible(true);
    }//GEN-LAST:event_btnPinActionPerformed

    private void btnRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRamActionPerformed
        // TODO add your handling code here:
        new FormRam().setVisible(true);
    }//GEN-LAST:event_btnRamActionPerformed

    private void btnXuatXuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatXuActionPerformed
        // TODO add your handling code here:
        new FormXuatXu().setVisible(true);
    }//GEN-LAST:event_btnXuatXuActionPerformed

    private void btnMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMauSacActionPerformed
        // TODO add your handling code here:
        new FormMauSac().setVisible(true);
    }//GEN-LAST:event_btnMauSacActionPerformed

    private void txtNamBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamBHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamBHActionPerformed

    private void btnXoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoAActionPerformed
        int row = tblSanPham.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Mời chọn bản ghi cần xoá");
            return;
        }

        String sp = tblSanPham.getValueAt(row, 0).toString();
        sanPhamSer.deleteSP(sp);
        JOptionPane.showMessageDialog(this, "Xoá thành công");
        loadTb();
        loadTbXoa();
    }//GEN-LAST:event_btnXoAActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void txtTimKiem2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiem2KeyReleased

        DefaultTableModel model = (DefaultTableModel) tblSp1.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        tblSp1.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(txtTimKiem2.getText().toUpperCase()));
    }//GEN-LAST:event_txtTimKiem2KeyReleased

    private void btnHoanTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanTacActionPerformed

        model.SanPham sp = new model.SanPham();
        sp.setMaSP(tblSp1.getValueAt(tblSp1.getSelectedRow(), 0).toString());
        sanPhamSer.hoanTacSP(sp);
        JOptionPane.showMessageDialog(this, "Hoàn tác thành công");
        loadTb();
        loadTbXoa();
    }//GEN-LAST:event_btnHoanTacActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        model.SanPham sp = new model.SanPham();
        sp.setMaSP(txtMaSp.getText());
        sp.setTenSP(txtTenSP.getText());
        sp.setGiaNhap(BigDecimal.valueOf(Long.parseLong(txtGiaNhap.getText())));
        sp.setGiaBan(BigDecimal.valueOf(Long.parseLong(txtGiaBna.getText())));
        sp.setSoLuongTon(Integer.parseInt(txtTonKho.getText()));
        sp.setMoTa(txtMoTa.getText());
        sp.setTrangThai(0);
        sp.setNamBH(Integer.parseInt(txtNamBH.getText()));
        sp.setId_DLuong(cbDungLuong.getSelectedItem().toString());
        sp.setId_MauSac(cbxMauSac.getSelectedItem().toString());
        sp.setId_XuatXu(cbxXuatXu.getSelectedItem().toString());
        sp.setId_PhanLoai(cbxPhanLoai.getSelectedItem().toString());
        sp.setId_Pin(cbxPin.getSelectedItem().toString());
        sp.setId_Chip(cbChip.getSelectedItem().toString());
        sp.setId_Ram(cbxRam.getSelectedItem().toString());
        sp.setId_ManHinh(cbxManHinh.getSelectedItem().toString());
        sp.setId_KhichThuoc(cbKichThuoc.getSelectedItem().toString());
        sanPhamSer.addSP(sp);
        JOptionPane.showMessageDialog(this, "Thêm thành công");
        loadTb();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        model.SanPham sp = new model.SanPham();
        sp.setMaSP(txtMaSp.getText());
        sp.setTenSP(txtTenSP.getText());
        sp.setGiaNhap(BigDecimal.valueOf(Long.parseLong(txtGiaNhap.getText())));
        sp.setGiaBan(BigDecimal.valueOf(Long.parseLong(txtGiaBna.getText())));
        sp.setSoLuongTon(Integer.parseInt(txtTonKho.getText()));
        sp.setMoTa(txtMoTa.getText());
        sp.setNamBH(Integer.parseInt(txtNamBH.getText()));
        sp.setId_DLuong(cbDungLuong.getSelectedItem().toString());
        sp.setId_MauSac(cbxMauSac.getSelectedItem().toString());
        sp.setId_XuatXu(cbxXuatXu.getSelectedItem().toString());
        sp.setId_PhanLoai(cbxPhanLoai.getSelectedItem().toString());
        sp.setId_Pin(cbxPin.getSelectedItem().toString());
        sp.setId_Chip(cbChip.getSelectedItem().toString());
        sp.setId_Ram(cbxRam.getSelectedItem().toString());
        sp.setId_ManHinh(cbxManHinh.getSelectedItem().toString());
        sp.setId_KhichThuoc(cbKichThuoc.getSelectedItem().toString());
        sanPhamSer.updateSP(sp);
        JOptionPane.showMessageDialog(this, "Sửa thành công");
        loadTb();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void txtTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiem1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        tblSanPham.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(txtTimKiem1.getText().toUpperCase()));
    }//GEN-LAST:event_txtTimKiem1ActionPerformed

    private void txtTimKiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiem2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblSp1.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        tblSp1.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(txtTimKiem2.getText().toUpperCase()));
    }//GEN-LAST:event_txtTimKiem2ActionPerformed

    private void tblSp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSp1MouseClicked
        int i = tblSp1.getSelectedRow();
        loadTf(i);
    }//GEN-LAST:event_tblSp1MouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int i = tblSanPham.getSelectedRow();
        loadTf(i);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void cbChipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbChipActionPerformed

    private void txtTimKiem1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiem1KeyReleased
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        tblSanPham.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(txtTimKiem1.getText().toUpperCase()));
    }//GEN-LAST:event_txtTimKiem1KeyReleased

    private void cbKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKichThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKichThuocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnChip;
    private javax.swing.JButton btnDungLuong;
    private javax.swing.JButton btnHoanTac;
    private javax.swing.JButton btnKichThuoc;
    private javax.swing.JButton btnManHinh;
    private javax.swing.JButton btnMauSac;
    private javax.swing.JButton btnPhanLoaiHang;
    private javax.swing.JButton btnPin;
    private javax.swing.JButton btnRam;
    private javax.swing.JButton btnXoA;
    private javax.swing.JButton btnXuatXu;
    private javax.swing.JComboBox<String> cbChip;
    private javax.swing.JComboBox<String> cbDungLuong;
    private javax.swing.JComboBox<String> cbKichThuoc;
    private javax.swing.JComboBox<String> cbxManHinh;
    private javax.swing.JComboBox<String> cbxMauSac;
    private javax.swing.JComboBox<String> cbxPhanLoai;
    private javax.swing.JComboBox<String> cbxPin;
    private javax.swing.JComboBox<String> cbxRam;
    private javax.swing.JComboBox<String> cbxXuatXu;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblSp1;
    private javax.swing.JTextField txtGiaBna;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaSp;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtNamBH;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem1;
    private javax.swing.JTextField txtTimKiem2;
    private javax.swing.JTextField txtTonKho;
    // End of variables declaration//GEN-END:variables
}
