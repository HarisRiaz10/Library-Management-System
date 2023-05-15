/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryjavafx;

import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

import javax.swing.JComboBox;
//import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import com.libraryjavafx.ChiTietPhieuMuon;
import com.libraryjavafx.DAO;
import com.libraryjavafx.DocGia;
import com.libraryjavafx.DocGiaDAO;
import com.libraryjavafx.NhaXuatBan;
import com.libraryjavafx.NhaXuatBanDAO;
import com.libraryjavafx.NhanVien;
import com.libraryjavafx.NhanVienDAO;
import com.libraryjavafx.PhieuMuon;
import com.libraryjavafx.PhieuMuonDAO;
import com.libraryjavafx.Sach;
import com.libraryjavafx.SachDAO;
import com.libraryjavafx.TheLoai;
import com.libraryjavafx.TheLoaiDAO;
import com.libraryjavafx.chitietphieumuon_identity;




public class giaoDlen extends javax.swing.JFrame {

    Object[][] nv_data ;
    Object[] nv_columns = {"Ma nhan vien","Ten nhan vien","Ten dang nhap","Mat Khau","SDT"
            ,"Dia chi","Tuoi","CMND","Gioi tinh","Cap bac"};
    DefaultTableModel tbl_nv_model = new DefaultTableModel(nv_data,nv_columns);
    
    Object[][] dg_data ;
    Object[] dg_columns = {"Ma","Ten","Gioi tinh","Nghe","CMND","SDT","Dia Chi","Ngay cap the"};
    DefaultTableModel tbl_dg_model = new DefaultTableModel(dg_data,dg_columns);
    
    Object[][] tl_data ;
    Object[] tl_columns = {"Ma The Loai","Ten The Loai"};
    DefaultTableModel tbl_tl_model = new DefaultTableModel(tl_data,tl_columns);
    
    Object[][] nxb_data ;
    Object[] nxb_columns = {"Ma NXB","Ten","Dia Chi","SDT"};
    DefaultTableModel tbl_nxb_model = new DefaultTableModel(nxb_data,nxb_columns);

    Object[][] sach_data ;
    Object[] sach_columns = {"Ma Sach","Ten","So Trang","Ngon Ngu",
        "So Luong Ton","NXB","The Loai"};
    DefaultTableModel tbl_sach_model = new DefaultTableModel(sach_data,sach_columns);
    DefaultTableModel tbl_msach_model = new DefaultTableModel(sach_data,sach_columns);
    
    Object[][] phieumuon_data;
    Object[] phieumuon_columns = {"Ma Sach","Ten Sach","So luong"};
    DefaultTableModel tbl_phieumuon_model = new DefaultTableModel(phieumuon_data,phieumuon_columns);
    
    Object[][] phieumuon_data_qlpm;
    Object[] phieumuon_qlpm_columns = {"Ma Sach","Ten Sach","So luong"};
    DefaultTableModel tbl_qlpm_ctpm_model = new DefaultTableModel(phieumuon_data_qlpm,phieumuon_qlpm_columns);
    
    Object[][] pmTongHop_data;
    Object[] pmTongHop_columns = {"Mã phiếu","Đọc giả","Tiền cọc","Nhân viên","Ngày thuê","Ngày tra","Trạng thái"};
    DefaultTableModel tbl_pmTongHop_model = new DefaultTableModel(pmTongHop_data,pmTongHop_columns);
    
    
    
    Object[][] trasach_data;
    Object[] trasach_columns = {"Mã phiếu","Đọc giả","Tiền cọc","Nhân viên","Ngày thuê","Ngày tra","Trạng thái"};
    DefaultTableModel tbl_trasach_model = new DefaultTableModel(trasach_data,trasach_columns);
    
    Object[][] tbl_trasach_ctpm_data;
    Object[] tbl_trasach_ctpm_columns = {"Mã sách","Tên sách","Số lượng"};
    DefaultTableModel tbl_trasach_ctpm_model = new DefaultTableModel (tbl_trasach_ctpm_data,tbl_trasach_ctpm_columns);
    public TableView<?> tbl_nv = new TableView<>();
    public TableView<?> tbl_dg = new TableView<>();
    public TableView<?> tbl_tl = new TableView<>();
    public TableView<?> tbl_nxb = new TableView<>();
    public TableView<?> tbl_sach = new TableView<>();
    public TableView<?> tbl_msach = new TableView<>();
    public TableView<?> tbl_phieumuon = new TableView<>();
    public TableView<?> tbl_qlpm_ctpm = new TableView<>();
    public TableView<?> tbl_trasach = new TableView<>();
    public TableView<?> tbl_trasach_ctpm = new TableView<>();
    public TableView<?> tbl_pmTongHop = new TableView<>();
    public Button nv_del_btn = new Button();
    public Button nv_cancel_btn = new Button();
    public Button nv_upd_btn = new Button();
    public Button nv_reset_passwd = new Button();
    public Button btn_qlpm_suaSach = new Button();
    public Button btn_trasach_giahan = new Button();
    public Button btn_trasach_trahet = new Button();
    public Button dg_del_btn = new Button();
    public Button dg_cancel_btn = new Button();
    public Button dg_update_btn = new Button();
    public Button tl_del_btn = new Button();
    public Button tl_cancel_btn = new Button();
    public Button tl_update_btn = new Button();
    public Button nxb_del_btn = new Button();
    public Button nxb_cancel_btn = new Button();
    public Button nxb_update_btn = new Button();
    public Button sach_del_btn = new Button();
    public Button sach_cancel_btn = new Button();
    public Button sach_update_btn = new Button();
    public Button btn_pmTongHop_update = new Button();
    public Button btn_pmTongHop_delete = new Button();
    public Button btn_pmTongHop_cancel = new Button();
    public Button btn_pmTongHop_xoaPM = new Button();
    public DatePicker phieumuon_crntDate = new DatePicker();
    public DatePicker dg_ngay = new DatePicker();
    public TabPane tab_pane = new TabPane();
    public Pane nv_panel = new Pane();
    public TextField phieumuon_tf_tien = new TextField();
    public TextField phieumuon_tf_madg = new TextField();
    public TextField nxb_tf_sdt = new TextField();
    public TextField nxb_tf_diachi = new TextField();
    public TextField nxb_tf_ten = new TextField();
    public TextField tl_tf_ten = new TextField();
    public TextField sach_tf_sl = new TextField();
    public TextField sach_tf_ngonngu = new TextField();
    public TextField sach_tf_sotrang = new TextField();
    public TextField sach_tf_ten = new TextField();
    public TextField dg_tf_sdt = new TextField();
    public TextField dg_tf_cmnd = new TextField();
    public TextField dg_tf_tendg = new TextField();
    public TextField nv_tf_cmnd = new TextField();
    public TextField nv_tf_tuoi = new TextField();
    public TextField nv_tf_diachi = new TextField();
    public TextField nv_tf_sdt = new TextField();
    public TextField nv_tf_tdn = new TextField();
    public TextField nv_tf_tennv = new TextField();
    public ComboBox sach_tl = new ComboBox();
    public ComboBox sach_nxb = new ComboBox();
    public ComboBox sach_tl1 = new ComboBox();
    public ComboBox sach_nxb1 = new ComboBox();
    public TextField nv_tf_manv = new TextField();
    public TextField tt_tf_gioitinh = new TextField();
    public TextField tt_tf_tuoi = new TextField();
    public TextField tt_tf_capbac = new TextField();
    public TextField dg_tf_madg = new TextField();
    public TextField dg_tf_nghe = new TextField();
    public TextField dg_tf_diachi = new TextField();
    public TextField tl_tf_matl = new TextField();
    public Label lbl_TraSach_dg = new Label();
    public TextField sach_tf_ma = new TextField();
    public TextField nxb_tf_manxb = new TextField();
    public Label lbl_TraSach_maphieu = new Label();
    public Label lbl_pmTongHop_maphieu = new Label();
    public Label lbl_pmTongHop_NgayTra = new Label();
    public Label lbl_pmTongHop_ngayThue = new Label();
    public TextField txt_pmTongHop_docGia = new TextField();
    public TextField txt_pmTongHop_tienCoc = new TextField();
    public TextField tt_tf_ten = new TextField();
    public TextField tt_tf_ma = new TextField();
    public TextField tt_tf_tdn = new TextField();
    public TextField tt_tf_sdt = new TextField();
    public TextField tt_tf_diachi = new TextField();
    public TextField tt_tf_cmnd = new TextField();
    public Label lbl_TraSach_ngayThue = new Label();
    public Label lbl_TraSach_ngayTra = new Label();
    public Label lbl_TraSach_nhanvien = new Label();
    public Label lbl_TraSach_tiencoc = new Label();
    public TextField phieumuon_crntUser = new TextField();
    public ComboBox dg_btn_group = new ComboBox();
    public ComboBox nv_capbac = new ComboBox();
    public ComboBox nv_btn_group = new ComboBox();
    
    
    
    List<Sach> updatedSachList;
    NhanVien crntUser;
    DocGia dg4phieumuon=null;
    
    public giaoDlen() {
      
        capNhatPhieuQuaHan();
        tbl_nv.setItems((ObservableList)tbl_nv_model);
        //set width column ma nhan vien
        tbl_nv.getColumns().get(0).setMaxWidth(100);
        //set width column ten nhan vien
        tbl_nv.getColumns().get(1).setMaxWidth(110);
        
        
        nv_del_btn.setVisible(false);
        nv_cancel_btn.setVisible(false);
        nv_upd_btn.setVisible(false);
        nv_reset_passwd.setVisible(false);
        btn_qlpm_suaSach.setVisible(false);
        btn_trasach_giahan.setVisible(false);
        btn_trasach_trahet.setVisible(false);
        showTableNhanVien();
        
        
        //config table dg
        tbl_dg.setItems((ObservableList)tbl_dg_model);
        tbl_dg.getColumns().get(7).setMaxWidth(110);     
        
        
        dg_del_btn.setVisible(false);
        dg_cancel_btn.setVisible(false);
        dg_update_btn.setVisible(false);
        showTableDocGia();
        
        //config table tl
        tbl_tl.setItems((ObservableList)tbl_tl_model);

        
        tl_del_btn.setVisible(false);
        tl_cancel_btn.setVisible(false);
        tl_update_btn.setVisible(false);
        showTableTheLoai();
        
        //config table nxb
        tbl_nxb.setItems((ObservableList)tbl_nxb_model);
       
        
        nxb_del_btn.setVisible(false);
        nxb_cancel_btn.setVisible(false);
        nxb_update_btn.setVisible(false);
        showTableNhaXuatBan();
        
        //config table sach
        tbl_sach.setItems((ObservableList)tbl_sach_model);
       
        sach_tl.getItems().addAll(new TheLoaiDAO().getDistinctTheLoai());
        //addDataFromListToComboBox(sach_ke,new ViTriDAO().getDistinctKeSach());
        sach_nxb.getItems().addAll(new NhaXuatBanDAO().getDistinctNhaXuatBan());
        sach_tl1.getItems().addAll(new TheLoaiDAO().getDistinctTheLoai());
        sach_nxb1.getItems().addAll(new NhaXuatBanDAO().getDistinctNhaXuatBan());

        
        
        sach_del_btn.setVisible(false);
        sach_cancel_btn.setVisible(false);
        sach_update_btn.setVisible(false);
        showTableSach();       
        
        //config muon sach
        tbl_msach.setItems((ObservableList)tbl_msach_model);
                     
        phieumuon_crntDate.getValue().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        
        tbl_phieumuon.setItems((ObservableList)tbl_phieumuon_model);
        
        //của Nhân
        tbl_qlpm_ctpm.setItems((ObservableList)tbl_qlpm_ctpm_model);
        btn_pmTongHop_update.setVisible(false);
        btn_pmTongHop_delete.setVisible(false);
        btn_pmTongHop_cancel.setVisible(false);
        
        btn_pmTongHop_xoaPM.setVisible(false);
        tbl_pmTongHop.setItems((ObservableList)tbl_pmTongHop_model);
        showTablePMTongHop();
        
        //config tra sach
        tbl_trasach.setItems((ObservableList)tbl_trasach_model);
        tbl_trasach_ctpm.setItems((ObservableList)tbl_trasach_ctpm_model);
        showTableTraSach();
        
        
    }
    
    public void capNhatPhieuQuaHan(){
        Calendar cal = Calendar.getInstance();                
        Calendar cal2 = Calendar.getInstance();
        PhieuMuonDAO pmDAO = new PhieuMuonDAO();
        List<PhieuMuon> listPM = pmDAO.getAllPhieuMuon();
        
        
        
        for (int i = 0; i<listPM.size();i++){
            cal2.setTime(listPM.get(i).getNgaytra());
            if(cal.compareTo(cal2) != -1){
                listPM.get(i).setTt("qua han");
                new PhieuMuonDAO().updatePhieuMuon(listPM.get(i));
            }
        }
    }
    
    public void hideNV(){
        tab_pane.getTabs().remove(nv_panel);
    }

    public void resetTable(DefaultTableModel tblModel){
        for(int i=tblModel.getRowCount()-1;i>=0;i--){
            tblModel.removeRow(i);
        }
    }
    
    public void addDataFromListToComboBox(JComboBox box, List<?> list){
        list.forEach(e->box.addItem(e));
    }
    
    public void showTableTraSach(){
        PhieuMuonDAO pmDAO = new PhieuMuonDAO();
        List<PhieuMuon> listPM = pmDAO.getAllPhieuMuon();
        resetTable(tbl_trasach_model);
        for (int i = 0; i < listPM.size(); i++){
            Object[] tmpRow = new Object[]
            {
                listPM.get(i).getMaphieu(),listPM.get(i).getDocgia().getTendg(),
                listPM.get(i).getTiencoc(),listPM.get(i).getNhanvien().getTennv(),listPM.get(i).getNgaythue(),
                listPM.get(i).getNgaytra(),listPM.get(i).getTt()
            };
            tbl_trasach_model.addRow(tmpRow);
        }
    }
    public void showTableNhanVien(){
        NhanVienDAO nvDAO = new NhanVienDAO();
        List<NhanVien> listNhanVien = nvDAO.getAllNhanVien();
        resetTable(tbl_nv_model);
        for (int i = 0; i < listNhanVien.size(); i++) {
            String pwd="";
            for (int j = 0; j < listNhanVien.get(i).getMatkhau().length(); j++) {
                pwd+="*";
            }
            Object[] tmpRow =new Object[]
            {
                listNhanVien.get(i).getManv(),listNhanVien.get(i).getTennv(),listNhanVien.get(i).getTendangnhap(),pwd
            ,listNhanVien.get(i).getSdt(),listNhanVien.get(i).getDiachi(),listNhanVien.get(i).getTuoi(),listNhanVien.get(i).getCMND()
                    ,listNhanVien.get(i).getGioitinh(),listNhanVien.get(i).getCapbac()
            };
            tbl_nv_model.addRow(tmpRow);
        }
        
    }
    // của Nhân
    public void showTablePMTongHop(){
        PhieuMuonDAO pmDAO = new PhieuMuonDAO();
        List<PhieuMuon> listPM = pmDAO.getAllPhieuMuon();
        resetTable(tbl_pmTongHop_model);
        for (int i = 0; i < listPM.size(); i++){
            Object[] tmpRow = new Object[]
            {
                listPM.get(i).getMaphieu(),listPM.get(i).getDocgia().getTendg(),
                listPM.get(i).getTiencoc(),listPM.get(i).getNhanvien().getTennv(),listPM.get(i).getNgaythue(),
                listPM.get(i).getNgaytra(),listPM.get(i).getTt()
            };
            tbl_pmTongHop_model.addRow(tmpRow);
        }
        
    
    }
   
    public void showTableDocGia(){
        DocGiaDAO dgDAO = new DocGiaDAO();
        List<DocGia> listDocGia = dgDAO.getAllDocGia();
        resetTable(tbl_dg_model);
        for (int i = 0; i < listDocGia.size(); i++) {
            Object[] tmpRow =new Object[]
            {
                listDocGia.get(i).getMadg(),listDocGia.get(i).getTendg(),listDocGia.get(i).getGioitinh(),listDocGia.get(i).getNghenghiep()
                    ,listDocGia.get(i).getCmnd(),listDocGia.get(i).getSdt(),listDocGia.get(i).getDiachi(),listDocGia.get(i).getNgaycapthe()
            };
            tbl_dg_model.addRow(tmpRow);
        }
        
    }
    
    public void showTableTheLoai(){
        TheLoaiDAO tlDAO = new TheLoaiDAO();
        List<TheLoai> listTheLoai = tlDAO.getAllTheLoai();
        resetTable(tbl_tl_model);
        for (int i = 0; i < listTheLoai.size(); i++) {
            Object[] tmpRow =new Object[]
            {
                listTheLoai.get(i).getMatl(), listTheLoai.get(i).getTentl()
            };
            tbl_tl_model.addRow(tmpRow);
        }
        
    }
    
    public void showTableNhaXuatBan(){
        NhaXuatBanDAO nxbDAO = new NhaXuatBanDAO();
        List<NhaXuatBan> listNhaXuatBan = nxbDAO.getAllNhaXuatBan();
        resetTable(tbl_nxb_model);
        for (int i = 0; i < listNhaXuatBan.size(); i++) {
            Object[] tmpRow =new Object[]
            {
                listNhaXuatBan.get(i).getManxb(), listNhaXuatBan.get(i).getTen(),
                listNhaXuatBan.get(i).getDiachi(),listNhaXuatBan.get(i).getSdt()
            };
            tbl_nxb_model.addRow(tmpRow);
        }
        
    }
    
    public void showTableSach(){                
        SachDAO sachDAO = new SachDAO();
        List<Sach> listSach = sachDAO.getAllSach();
        resetTable(tbl_sach_model);
        for (int i = 0; i < listSach.size(); i++) {
            Object[] tmpRow =new Object[]
            {
                listSach.get(i).getMasach(), listSach.get(i).getTensach(),listSach.get(i).getSotrang(),listSach.get(i).getNgonngu()
                ,listSach.get(i).getSoluongton(),listSach.get(i).getNxb().getTen(),listSach.get(i).getTl().getTentl()
            };
            tbl_sach_model.addRow(tmpRow);
            tbl_msach_model.addRow(tmpRow);
        }
        
        
    }
    
    public void showTableMSach(){                
        SachDAO sachDAO = new SachDAO();
        List<Sach> listSach = sachDAO.getAllSach();
        resetTable(tbl_msach_model);
        for (int i = 0; i < listSach.size(); i++) {
            Object[] tmpRow =new Object[]
            {
                listSach.get(i).getMasach(), listSach.get(i).getTensach(),listSach.get(i).getSotrang(),listSach.get(i).getNgonngu()
                ,listSach.get(i).getSoluongton(),listSach.get(i).getNxb().getTen(),listSach.get(i).getTl().getTentl()
            };
            tbl_msach_model.addRow(tmpRow);
        }
        
        
    }
   public static Object getValueAt(TableView<?> table, int column, int row) {
    return table.getColumns().get(column).getCellObservableValue(row).getValue();
   }
   
    public void showTableChiTietPhieuMuon(){
        PhieuMuon PM = new PhieuMuon();
        int row = (int) tbl_pmTongHop.getSelectionModel().getSelectedItem();
        int id = Integer.parseInt(String.valueOf(getValueAt(tbl_pmTongHop,2,row)));
        List<ChiTietPhieuMuon> listCTPM = PM.getCtpm();
        ChiTietPhieuMuon CTPM = new ChiTietPhieuMuon();
        chitietphieumuon_identity ctpm_id = new chitietphieumuon_identity();
            Object[] tmpROw = new Object[]
            {
                PM.getCtpm()
            };
    }
    public void showFormThongTin(NhanVien nv){
        tt_tf_ma.setText(String.valueOf(nv.getManv()));
        tt_tf_ten.setText(nv.getTennv());
        tt_tf_tdn.setText(nv.getTendangnhap());
        tt_tf_sdt.setText(nv.getSdt());
        tt_tf_diachi.setText(nv.getDiachi());
        tt_tf_cmnd.setText(nv.getCMND());
        tt_tf_capbac.setText(nv.getCapbac());
        tt_tf_tuoi.setText(String.valueOf(nv.getTuoi()));
        tt_tf_gioitinh.setText(nv.getGioitinh());
        crntUser = nv;
        phieumuon_crntUser.setText(crntUser.getTennv());
    }
    
    public void resetFormNhanVien(){
        nv_tf_manv.setText("");
        nv_tf_tennv.setText("");
        nv_tf_tdn.setText("");
        nv_tf_sdt.setText("");
//        nv_tf_mk.setText("");
        nv_tf_cmnd.setText("");
        nv_tf_diachi.setText("");
        nv_tf_tuoi.setText("");
        nv_btn_group.getSelectionModel().clearSelection();
        nv_capbac.getSelectionModel().select(0);
    }
    
    public void resetFormDocGia(){
        dg_tf_madg.setText("");
        dg_tf_tendg.setText("");
        dg_tf_sdt.setText("");
        dg_tf_nghe.setText("");
        dg_tf_cmnd.setText("");
        dg_tf_diachi.setText("");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();       
     //   dg_ngay.setValue(date);
    //    dg_ngay.setValue((date));
        dg_btn_group.getSelectionModel().clearSelection();
        
    }
    public void resetFormTheLoai(){
        tl_tf_matl.setText("");
        tl_tf_ten.setText("");
        
    }
    
    public void resetFormTraSach(){
        lbl_TraSach_dg.setText("");
        lbl_TraSach_maphieu.setText("");
        lbl_TraSach_ngayThue.setText("");
        lbl_TraSach_ngayTra.setText("");
        lbl_TraSach_nhanvien.setText("");
        lbl_TraSach_tiencoc.setText("");
    }
    
    public void resetFormNhaXuatBan(){
        nxb_tf_manxb.setText("");
        nxb_tf_ten.setText("");
        nxb_tf_diachi.setText("");
        nxb_tf_sdt.setText("");
    }
    
    public void resetFormSach(){
        sach_tf_ma.setText("");
        sach_tf_ten.setText("");
        sach_tf_ngonngu.setText("");
        
        sach_tf_sl.setText("");
        sach_tf_sotrang.setText("");
        
        sach_tl.getSelectionModel().select(0);
       // sach_ke.setSelectedIndex(0);
        sach_nxb.getSelectionModel().select(0);
    }
    public void resetFormPhieuMuon(){
        phieumuon_tf_madg.setText("");
        phieumuon_tf_tien.setText("");
        resetTable(tbl_phieumuon_model);
        tbl_msach.getSelectionModel().clearSelection();
    }
    
    public void resetFormQLPM_CTPM(){
        lbl_pmTongHop_maphieu.setText("");
        lbl_pmTongHop_ngayThue.setText("");
        lbl_pmTongHop_NgayTra.setText("");
        txt_pmTongHop_docGia.setText("");
        txt_pmTongHop_tienCoc.setText("");
        resetTable(tbl_qlpm_ctpm_model);     
    }
    
    String checkPhoneNumber(String str){        
        try{
            Integer.parseInt(str);
            if(str.startsWith("09")){
            if(str.length() == 10){
                return "";
            }else{
                return "So Dien Thoai Khong Hop Le";
            }
        }else if(str.startsWith("01")){
            if(str.length()==11){
                return "";
            }else{
                return "So Dien Thoai Khong Hop Le";
            }
        }           
            
        }catch(Exception e){
            return "So Dien Thoai Khong Hop Le";
        }
        return "So Dien Thoai Khong Hop Le";
    }    
    
    
    
    public boolean validateNhanVienForm(){
        if(nv_tf_tennv.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ten Nhan Vien khong duoc de trong", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
          //  JOptionPane.showMessageDialog(null, "Ten Nhan Vien khong duoc de trong", "LOI", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            if(nv_tf_tdn.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ten Dang Nhap khong duoc de trong", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
              //  JOptionPane.showMessageDialog(null, "Ten Dang Nhap khong duoc de trong", "LOI", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            else{
                if(!checkPhoneNumber(nv_tf_sdt.getText()).equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, checkPhoneNumber(nv_tf_sdt.getText()), ButtonType.OK);
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alert.show();
                 //   JOptionPane.showMessageDialog(null,checkPhoneNumber(nv_tf_sdt.getText()) , "LOI", JOptionPane.ERROR_MESSAGE);    
                    return false;
                }else{
                    if(nv_tf_diachi.getText().equals("")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Dia Chi khong duoc de trong", ButtonType.OK);
                        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                        alert.show();
                       // JOptionPane.showMessageDialog(null, "Dia Chi khong duoc de trong", "LOI", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }else{
                        if(!nv_tf_tuoi.getText().equals("")){
                            //tuoi khac rong
                            try{
                                Integer.parseInt(nv_tf_tuoi.getText());
                                if(nv_tf_cmnd.getText().equals("")){
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "CMND khong duoc de trong", ButtonType.OK);
                                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                    alert.show();
                                 //   JOptionPane.showMessageDialog(null, "CMND khong duoc de trong", "LOI", JOptionPane.ERROR_MESSAGE);
                                    return false;
                                }else{
                                    try{
                                        Integer.parseInt(nv_tf_cmnd.getText());
                                        if(nv_tf_cmnd.getText().length()!=9){
                                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "CMND khong hop le", ButtonType.OK);
                                            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                            alert.show();
                                            //JOptionPane.showMessageDialog(null, "CMND khong hop le", "LOI", JOptionPane.ERROR_MESSAGE);  
                                            return false;
                                        }else{
                                            try{
                                             //   nv_btn_group.getSelection().isSelected();                                                
                                            }catch(NullPointerException e){
                                                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Chon Gioi Tinh", ButtonType.OK);
                                                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                                alert.show();
                                               // JOptionPane.showMessageDialog(null, "Chon Gioi Tinh", "LOI", JOptionPane.ERROR_MESSAGE);  
                                                return false;
                                            }
                                        }
                                    }catch(Exception e){
                                      Alert alert = new Alert(Alert.AlertType.INFORMATION, "CMND khong hop le", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                  //  JOptionPane.showMessageDialog(null, "CMND khong hop le", "LOI", JOptionPane.ERROR_MESSAGE);  
                                      return false;
                                    }
                                }
                            }catch(Exception e){
                                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Tuoi khong hop le", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                              //  JOptionPane.showMessageDialog(null, "Tuoi khong hop le", "LOI", JOptionPane.ERROR_MESSAGE);    
                                return false;
                            }
                            //
                        }else{
                            //tuoi = rong
                            
                                
                                if(nv_tf_cmnd.getText().equals("")){
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "CMND khong duoc de trong", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                                   // JOptionPane.showMessageDialog(null, "CMND khong duoc de trong", "LOI", JOptionPane.ERROR_MESSAGE);
                                    return false;
                                }else{
                                    try{
                                        Integer.parseInt(nv_tf_cmnd.getText());
                                        if(nv_tf_cmnd.getText().length()!=9){
                                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "CMND khong hop le", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                                         //   JOptionPane.showMessageDialog(null, "CMND khong hop le", "LOI", JOptionPane.ERROR_MESSAGE);  
                                            return false;
                                        }else{
                                            try{
                                           //     nv_btn_group.getSelection().isSelected();                                                
                                            }catch(NullPointerException e){
                                                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Chon Gioi Tinh", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                                              //  JOptionPane.showMessageDialog(null, "Chon Gioi Tinh", "LOI", JOptionPane.ERROR_MESSAGE);  
                                                return false;
                                            }
                                        }
                                    }catch(Exception e){
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "CMND khong hop le", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                                     // JOptionPane.showMessageDialog(null, "CMND khong hop le", "LOI", JOptionPane.ERROR_MESSAGE);  
                                      return false;
                                    }
                                }
                        }
                        
                    }
                }
            }
        }
        return true;
    }
        

    
    public boolean validateDocGiaForm(){
        if(dg_tf_tendg.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ten Doc Gia ko dc de trong", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
           // JOptionPane.showMessageDialog(null, "Ten Doc Gia ko dc de trong","LOI", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            try{
              //  if(dg_btn_group.setOnAction(event -> {((Button)event.getSource());}))
              //  {                
                        try{
                           Integer.parseInt(dg_tf_cmnd.getText());
                           if(dg_tf_cmnd.getText().length()!=9){
                               Alert alert = new Alert(Alert.AlertType.INFORMATION, "CMND khong hop le", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                             //  JOptionPane.showMessageDialog(null, "CMND khong hop le", "LOI", JOptionPane.ERROR_MESSAGE);  
                                return false;
                            }else{
                                  if(!checkPhoneNumber(dg_tf_sdt.getText()).equals("")){
                                      Alert alert = new Alert(Alert.AlertType.INFORMATION, checkPhoneNumber(dg_tf_sdt.getText()) , ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                                        //  JOptionPane.showMessageDialog(null,checkPhoneNumber(dg_tf_sdt.getText()) , "LOI", JOptionPane.ERROR_MESSAGE);    
                                          return false;
                                      }else{
                                          if(dg_ngay.getValue()==null){
                                              Alert alert = new Alert(Alert.AlertType.INFORMATION, checkPhoneNumber(dg_tf_sdt.getText()), ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                                         // JOptionPane.showMessageDialog(null,checkPhoneNumber(dg_tf_sdt.getText()) , "LOI", JOptionPane.ERROR_MESSAGE);    
                                          return false;
                                          }else{
                                              return true;
                                          }
                                      }         
                                 }
                        }catch(Exception e){
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "CMND khong hop le", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                          // JOptionPane.showMessageDialog(null, "CMND khong hop le", "LOI", JOptionPane.ERROR_MESSAGE);  
                            return false;
                        }
               // }
            }catch(NullPointerException e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Vui long chon gioi tinh", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
               // JOptionPane.showMessageDialog(null, "Vui long chon gioi tinh","LOI", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
    }
   
    public boolean validateSachForm(){
        if(sach_tf_ten.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ten Sach khong duoc de trong", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
           // JOptionPane.showMessageDialog(null, "Ten Sach khong duoc de trong","LOI", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            if(!sach_tf_sotrang.getText().equals("")){
                try{
                    Integer.parseInt(sach_tf_sotrang.getText());
                    if(sach_tf_ngonngu.getText().equals("")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ngon Ngu khong duoc de trong", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                   // JOptionPane.showMessageDialog(null, "Ngon Ngu khong duoc de trong","LOI", JOptionPane.ERROR_MESSAGE);
                    return false;
                }else{
                    if(sach_tf_sl.getText().equals("")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "So Luong khong duoc de trong", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                       // JOptionPane.showMessageDialog(null, "So Luong khong duoc de trong","LOI", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }else{
                        try{
                            Integer.parseInt(sach_tf_sl.getText());
                            return true;
                        }catch(Exception e){
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "So Luong khong hop le", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                           // JOptionPane.showMessageDialog(null, "So Luong khong hop le","LOI", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                    }
                }
                    //
                }catch(Exception e){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "So Trang khong hop le", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                   // JOptionPane.showMessageDialog(null, "So Trang khong hop le","LOI", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }else{
                                    
                    if(sach_tf_ngonngu.getText().equals("")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ngon Ngu khong duoc de trong", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                  //  JOptionPane.showMessageDialog(null, "Ngon Ngu khong duoc de trong","LOI", JOptionPane.ERROR_MESSAGE);
                    return false;
                }else{
                    if(sach_tf_sl.getText().equals("")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "So Luong khong duoc de trong", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                       // JOptionPane.showMessageDialog(null, "So Luong khong duoc de trong","LOI", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }else{
                        try{
                            Integer.parseInt(sach_tf_sl.getText());
                            return true;
                        }catch(Exception e){
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "So Luong khong hop le", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                           // JOptionPane.showMessageDialog(null, "So Luong khong hop le","LOI", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                    }
                }
                
                
            }
        }
        
    }
        
    public boolean validateTheLoaiForm(){
        if(tl_tf_ten.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ten The Loai ko dc de trong", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
           // JOptionPane.showMessageDialog(null, "Ten The Loai ko dc de trong","LOI", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean validateNhaXuatBanForm(){
        if(nxb_tf_ten.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ten Nha Xuat Ban ko dc de trong", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
           // JOptionPane.showMessageDialog(null, "Ten Nha Xuat Ban ko dc de trong","LOI", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            if(nxb_tf_diachi.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Dia Chi ko dc de trong", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
              //  JOptionPane.showMessageDialog(null, "Dia Chi ko dc de trong","LOI", JOptionPane.ERROR_MESSAGE);
                return false;
            }else{
                if(nxb_tf_sdt.getText().equals("")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "So Dien Thoai ko dc de trong", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                   // JOptionPane.showMessageDialog(null, "So Dien Thoai ko dc de trong","LOI", JOptionPane.ERROR_MESSAGE);
                    return false;
                }else{
                    if(!checkPhoneNumber(nxb_tf_sdt.getText()).equals("")){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, checkPhoneNumber(nxb_tf_sdt.getText()), ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                      //  JOptionPane.showMessageDialog(null, checkPhoneNumber(nxb_tf_sdt.getText()),"LOI", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }
            }            
        }
        return true;
    }
    
    public boolean validatePhieuMuonForm(){
        if(phieumuon_tf_madg.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ma Doc Gia ko dc de trong", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
          //  JOptionPane.showMessageDialog(null, "Ma Doc Gia ko dc de trong","LOI", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            DocGiaDAO dgDAO = new DocGiaDAO();
            //load: error no proxy .
            dg4phieumuon = dgDAO.getDocGiaWithId(Integer.parseInt(phieumuon_tf_madg.getText()));
            //System.out.println(dg4phieumuon.getMadg());
            if(dg4phieumuon==null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Mã đọc giả không tồn tại", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
               // JOptionPane.showMessageDialog(null, "Mã đọc giả không tồn tại","LỖI", JOptionPane.ERROR_MESSAGE);
                return false;
            }else{
                try{
                    Float.parseFloat(phieumuon_tf_tien.getText());
                    if(tbl_phieumuon.getItems().size()>0){
                        return true;
                    }else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Phiếu mượn không có sách", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                      //  JOptionPane.showMessageDialog(null, "Phiếu mượn không có sách","LỖI", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }catch(Exception e){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Tiền cọc không hợp lệ", ButtonType.OK);
                                      alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                                      alert.show();
                 //   JOptionPane.showMessageDialog(null, "Tiền cọc không hợp lệ","LỖI", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            
        }
        
    }
    
    public TableView<?> getTbl_qlpm_ctpm(){
        return tbl_qlpm_ctpm;
    }
    
    public DefaultTableModel getTbl_qlpm_ctpm_model(){
        return tbl_qlpm_ctpm_model;
    }
    public void getListFromsach(List<Sach> sachList){
        updatedSachList = sachList;
    }
}