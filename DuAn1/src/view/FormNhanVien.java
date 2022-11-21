/*
............/´¯/)........... (\¯'\
............/....//........... ...\\....\
.........../....//............ ....\\....\
...../´¯/..../´¯\.........../¯ '\....\¯'\
.././.../..../..../.|_......_| .\....\....\...\.\..
(.(....(....(..../.)..)..(..(. \....)....)....).)
.\................\/.../....\. ..\/................/
..\................. /........\..................../
....\..............(.......... ..)................/           


 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChucVu;
import model.NhanVien;
import repository.NhanVienRepository;
import service.ChucVuService;
import service.NhanVienService;
import service.impl.ChucVuServiceImp;
import service.impl.NhanVienServiceImp;
import viewModel.ViewModeChucVu;
import viewModel.ViewModeNhanVien;

/**
 *
 * @author Admin
 */
public class FormNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form PanelNhanVien
     */
   
    public FormNhanVien(){
        initComponents();
        load(nhanVienSe.getList());
        load1(nhanVienSe.getList1());
        comBoBox();
    }
    private NhanVienService nhanVienSe=new NhanVienServiceImp();
    private ChucVuService chucVuSe=new ChucVuServiceImp();
    ArrayList<ViewModeNhanVien> listNhanVien=nhanVienSe.getList();
    private void comBoBox(){
        ArrayList< ChucVu> listChucVu=nhanVienSe.getAllcv();
        cbxChucVu.removeAll();
        for ( ChucVu x : listChucVu) {
            cbxChucVu.addItem(x);
        }
    }
   private void load(ArrayList<ViewModeNhanVien> listNhanVien){
       
        DefaultTableModel model= (DefaultTableModel) tblNhanVien.getModel();
        model.setColumnCount(0);
        model.addColumn("MÃ NHÂN VIÊN");
        model.addColumn("TÊN");
        model.addColumn("TÊN ĐÊM");
        model.addColumn("HỌ");
        model.addColumn("NGÀY SINH");
        model.addColumn("GIỚI TÍNH");
        model.addColumn("CHỨC VỤ");
        model.addColumn("ĐỊA CHỈ");
        model.addColumn("SỐ ĐIỆN THOẠI");
        model.addColumn("MẬT KHẨU");
        model.addColumn("GHI CHÚ");
        model.setRowCount(0);
        for (ViewModeNhanVien x : listNhanVien) {
           model.addRow(new Object[]{x.getMaNv(),x.getTenNv(),x.getTenDem(),x.getHo(),x.getNgaySinh(),x.getGioiTinh()==1?"Nam":"Nữ",
           x.getChucVu(),x.getDiaChi(),x.getSdt(),x.getMatKhau(),x.getGhiChu()});
       }
   }
   private void load1(ArrayList<ViewModeNhanVien> listNhanVien){
       
       DefaultTableModel model= (DefaultTableModel) tblNhanVien1.getModel();
        model.setColumnCount(0);
        model.addColumn("MÃ NHÂN VIÊN");
        model.addColumn("TÊN");
        model.addColumn("TÊN ĐÊM");
        model.addColumn("HỌ");
        model.addColumn("NGÀY SINH");
        model.addColumn("GIỚI TÍNH");
        model.addColumn("CHỨC VỤ");
        model.addColumn("ĐỊA CHỈ");
        model.addColumn("SỐ ĐIỆN THOẠI");
        model.addColumn("MẬT KHẨU");
        model.addColumn("GHI CHÚ");
        model.setRowCount(0);
        for (ViewModeNhanVien x : listNhanVien) {
           model.addRow(new Object[]{x.getMaNv(),x.getTenNv(),x.getTenDem(),x.getHo(),x.getNgaySinh(),x.getGioiTinh()==1?"Nam":"Nữ",
           x.getChucVu(),x.getDiaChi(),x.getSdt(),x.getMatKhau(),x.getGhiChu()});
       }
   }
   private NhanVien them(){
      
            NhanVien nv=new NhanVien();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
            nv.setMaNv(txtMaNhanVien.getText());
            nv.setTenNv(txtTen.getText());
            nv.setTenDem(txtTenDem.getText());
            nv.setHo(txtHo.getText());
            nv.setNgaySinh(txtNgaySinh.getText());
            int gioiTinh=rdNam.isSelected()?1:0;
            nv.setGioiTinh(gioiTinh);
             ChucVu cv=( ChucVu) cbxChucVu.getModel().getSelectedItem();
            nv.setChucvu(cv);
            nv.setDiaChi(txtDiaChi.getText());
            nv.setSdt(txtSoDienThoai.getText());
           
            nv.setMatKhau(txtMatKhau.getText());
           
            nv.setGhiChu(txtGhiChu.getText());
           return nv;
          
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNhanVien1 = new javax.swing.JTable();
        btnXoa1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiemNhanVienNghiViec = new javax.swing.JTextField();
        PanelKH = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTenDem = new javax.swing.JTextField();
        txtHo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        txtMaNhanVien = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbxChucVu = new javax.swing.JComboBox<ChucVu>();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        txtNgaySinh = new com.github.lgooddatepicker.components.DatePicker();
        txtTimKiem = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));

        tblNhanVien1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblNhanVien1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVien1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNhanVien1);

        btnXoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update (2).png"))); // NOI18N
        btnXoa1.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa1.setPreferredSize(new java.awt.Dimension(100, 30));
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        jLabel2.setText("TÌM KIẾM :");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        txtTimKiemNhanVienNghiViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemNhanVienNghiViecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(805, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemNhanVienNghiViec, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKiemNhanVienNghiViec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(322, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhân Viên Nghỉ Việc", jPanel1);

        PanelKH.setBackground(new java.awt.Color(36, 47, 65));
        PanelKH.setForeground(new java.awt.Color(255, 255, 255));
        PanelKH.setPreferredSize(new java.awt.Dimension(1300, 800));

        jLabel4.setText("Mã Nhân Viên");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        txtTen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel5.setText("Tên");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Tên Đệm");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        txtTenDem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtHo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel7.setText("Họ");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Ngày Sinh");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Giới Tính");
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Địa Chỉ");
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Số Điện Thoại");
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        rdNam.setBackground(new java.awt.Color(36, 47, 65));
        buttonGroup1.add(rdNam);
        rdNam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdNam.setForeground(new java.awt.Color(255, 255, 255));
        rdNam.setText("Nam");

        rdNu.setBackground(new java.awt.Color(36, 47, 65));
        buttonGroup1.add(rdNu);
        rdNu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdNu.setForeground(new java.awt.Color(255, 255, 255));
        rdNu.setText("Nữ");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add (2).png"))); // NOI18N
        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setPreferredSize(new java.awt.Dimension(100, 30));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delele.png"))); // NOI18N
        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setPreferredSize(new java.awt.Dimension(100, 30));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update (2).png"))); // NOI18N
        btnsua.setBackground(new java.awt.Color(255, 255, 255));
        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsua.setPreferredSize(new java.awt.Dimension(100, 30));
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        txtMaNhanVien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel13.setText("Mật Khẩu");
        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));

        jLabel16.setText("Chức Vụ");
        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));

        cbxChucVu.setModel(new javax.swing.DefaultComboBoxModel<ChucVu>());
        cbxChucVu.setBackground(new java.awt.Color(97, 212, 195));
        cbxChucVu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxChucVu.setForeground(new java.awt.Color(255, 255, 255));

        jLabel17.setText("Ghi Chú");
        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblNhanVien);

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        txtMatKhau.setText("jPasswordField1");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tìm kiếm");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NHÂN VIÊN");

        javax.swing.GroupLayout PanelKHLayout = new javax.swing.GroupLayout(PanelKH);
        PanelKH.setLayout(PanelKHLayout);
        PanelKHLayout.setHorizontalGroup(
            PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKHLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(281, 281, 281))
            .addGroup(PanelKHLayout.createSequentialGroup()
                .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelKHLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelKHLayout.createSequentialGroup()
                                .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTenDem)
                                        .addComponent(txtTen)
                                        .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtHo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKHLayout.createSequentialGroup()
                                .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelKHLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelKHLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelKHLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(rdNam, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdNu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtMatKhau))
                                .addGap(11, 11, 11))
                            .addGroup(PanelKHLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelKHLayout.createSequentialGroup()
                                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(17, 17, 17)
                                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDiaChi)
                                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(PanelKHLayout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelKHLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelKHLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        PanelKHLayout.setVerticalGroup(
            PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKHLayout.createSequentialGroup()
                .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelKHLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKHLayout.createSequentialGroup()
                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelKHLayout.createSequentialGroup()
                                .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelKHLayout.createSequentialGroup()
                                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50)
                                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50)
                                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTenDem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50)
                                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rdNam)
                                            .addComponent(rdNu)))
                                    .addGroup(PanelKHLayout.createSequentialGroup()
                                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50)
                                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(50, 50, 50)
                                .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelKHLayout.createSequentialGroup()
                                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(56, 56, 56)
                                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelKHLayout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKHLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnsua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông Tin Nhân Viên", PanelKH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        ArrayList<ViewModeNhanVien> nv= nhanVienSe.timKiem(txtTimKiem.getText());
        DefaultTableModel model= (DefaultTableModel) tblNhanVien.getModel();
        model.setColumnCount(0);
        model.addColumn("MÃ NHÂN VIÊN");
        model.addColumn("TÊN");
        model.addColumn("TÊN ĐÊM");
        model.addColumn("HỌ");
        model.addColumn("NGÀY SINH");
        model.addColumn("GIỚI TÍNH");
        model.addColumn("CHỨC VỤ");
        model.addColumn("ĐỊA CHỈ");
        model.addColumn("SỐ ĐIỆN THOẠI");
       // model.addColumn("MẬT KHẨU");
        model.addColumn("GHI CHÚ");
        model.setRowCount(0);
        for (ViewModeNhanVien x : nv) {
            model.addRow(new Object[]{x.getMaNv(),x.getTenNv(),x.getTenDem(),x.getHo(),x.getNgaySinh(),x.getGioiTinh()==1?"Nam":"Nữ",
                x.getChucVu(),x.getDiaChi(),x.getSdt(),x.getGhiChu()});
        }

    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int index=tblNhanVien.getSelectedRow();
        txtMaNhanVien.setText(tblNhanVien.getValueAt(index,0).toString());
        txtTen.setText(tblNhanVien.getValueAt(index,1).toString());
        txtTenDem.setText(tblNhanVien.getValueAt(index,2).toString());
        txtHo.setText(tblNhanVien.getValueAt(index,3).toString());
        txtNgaySinh.setDate(LocalDate.parse(tblNhanVien.getValueAt(index,4).toString()));
        if(tblNhanVien.getValueAt(index,5).toString().equals("Nam")){
            rdNam.setSelected(true);
        }else{
            rdNu.setSelected(true);
        }

        int socv=cbxChucVu.getItemCount();
        ChucVu sp=new  ChucVu();
        sp.setTenCv(tblNhanVien.getValueAt(index,6).toString());
        cbxChucVu.setSelectedItem(sp.getTenCv());
        for (int j = 0; j < socv; j++) {
            ChucVu  sp1=cbxChucVu.getItemAt(j);
            if(sp.getTenCv().equals(sp1.getTenCv())){
                cbxChucVu.setSelectedIndex(j);
            }
        }

        txtDiaChi.setText(tblNhanVien.getValueAt(index,7).toString());
        txtSoDienThoai.setText(tblNhanVien.getValueAt(index,8).toString());

       // txtMatKhau.setText(tblNhanVien.getValueAt(index,9).toString());

        txtGhiChu.setText(tblNhanVien.getValueAt(index,10).toString());

    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed

        NhanVien nv=new NhanVien();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        nv.setMaNv(txtMaNhanVien.getText());
        nv.setTenNv(txtTen.getText());
        nv.setTenDem(txtTenDem.getText());
        nv.setHo(txtHo.getText());
        nv.setNgaySinh(txtNgaySinh.getText());
        int gioiTinh=rdNam.isSelected()?1:0;
        nv.setGioiTinh(gioiTinh);
        ChucVu cv=( ChucVu) cbxChucVu.getSelectedItem();
        nv.setChucvu(cv);
        nv.setDiaChi(txtDiaChi.getText());
        nv.setSdt(txtSoDienThoai.getText());

        nv.setMatKhau(txtMatKhau.getText());

        nv.setGhiChu(txtGhiChu.getText());
        nhanVienSe.sua(nv,txtMaNhanVien.getText());
        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        load(nhanVienSe.getList());

    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        nhanVienSe.delete(txtMaNhanVien.getText());
        load(nhanVienSe.getList());
        load1(nhanVienSe.getList1());
        JOptionPane.showMessageDialog(this,"Xoá Thành Công");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        NhanVien nv=them();
        int ketQua= nhanVienSe.them(nv);
        if(ketQua <0){
            JOptionPane.showMessageDialog(this,"Thêm Thất Bại");
        }else{
            JOptionPane.showMessageDialog(this,"Thêm Thành Công");
            load(nhanVienSe.getList());
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTimKiemNhanVienNghiViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemNhanVienNghiViecActionPerformed
        ArrayList<ViewModeNhanVien> nv= nhanVienSe.timKiemNhanVienNghiViec(txtTimKiemNhanVienNghiViec.getText());

        DefaultTableModel model= (DefaultTableModel) tblNhanVien1.getModel();
        model.setColumnCount(0);
        model.addColumn("MÃ NHÂN VIÊN");
        model.addColumn("TÊN");
        model.addColumn("TÊN ĐÊM");
        model.addColumn("HỌ");
        model.addColumn("NGÀY SINH");
        model.addColumn("GIỚI TÍNH");
        model.addColumn("CHỨC VỤ");
        model.addColumn("ĐỊA CHỈ");
        model.addColumn("SỐ ĐIỆN THOẠI");
        model.addColumn("MẬT KHẨU");
        model.addColumn("GHI CHÚ");
        model.setRowCount(0);
        for (ViewModeNhanVien x : nv) {
            model.addRow(new Object[]{x.getMaNv(),x.getTenNv(),x.getTenDem(),x.getHo(),x.getNgaySinh(),x.getGioiTinh()==1?"Nam":"Nữ",
                x.getChucVu(),x.getDiaChi(),x.getSdt(),x.getMatKhau(),x.getGhiChu()});
        }
    }//GEN-LAST:event_txtTimKiemNhanVienNghiViecActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        nhanVienSe.delete1(txtTimKiemNhanVienNghiViec.getText());
        load(nhanVienSe.getList());
        load1(nhanVienSe.getList1());
        JOptionPane.showMessageDialog(this,"Chuyển Trạng Thái Thành Công");
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void tblNhanVien1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVien1MouseClicked
        int index=tblNhanVien1.getSelectedRow();
        txtTimKiemNhanVienNghiViec.setText(tblNhanVien1.getValueAt(index,0).toString());
    }//GEN-LAST:event_tblNhanVien1MouseClicked
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelKH;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JButton btnsua;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<ChucVu> cbxChucVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTable tblNhanVien1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JPasswordField txtMatKhau;
    private com.github.lgooddatepicker.components.DatePicker txtNgaySinh;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenDem;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemNhanVienNghiViec;
    // End of variables declaration//GEN-END:variables
}
