package com.libraryjavafx;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javax.swing.table.DefaultTableModel;
import com.libraryjavafx.giaoDlen;
import com.libraryjavafx.LoginDAO;
import com.libraryjavafx.NhaXuatBan;
import com.libraryjavafx.NhaXuatBanDAO;
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

/**
 * FXML Controller class
 */
public class giaoDlenViewController implements Initializable {

    @FXML
    private Pane jPanel6;
    @FXML
    private Pane jPanel5;
    @FXML
    private Label jLabel1;
    @FXML
    private Pane BIGDATA;
    @FXML
    private TabPane tab_pane;
    @FXML
    private Pane dg_panel;
    @FXML
    private Label jLabel2;
    @FXML
    private Label jLabel3;
    @FXML
    private Label jLabel4;
    @FXML
    private Label jLabel5;
    @FXML
    private Label jLabel6;
    @FXML
    private Label jLabel7;
    @FXML
    private Label jLabel8;
    @FXML
    private Label jLabel9;
    @FXML
    private TextField dg_tf_nghe;
    @FXML
    private TextField dg_tf_cmnd;
    @FXML
    private TextField dg_tf_diachi;
    @FXML
    private TextField dg_tf_sdt;
    @FXML
    private ScrollPane jScrollPane1;
    @FXML
    private TableView<?> tbl_dg;
    @FXML
    private Button dg_them_btn;
    @FXML
    private Button dg_del_btn;
    @FXML
    private Button dg_update_btn;
    @FXML
    private Button jButton4;
    @FXML
    private TextField dg_tf_search;
    @FXML
    private RadioButton dg_nam;
    @FXML
    private RadioButton dg_nu;
    @FXML
    private TextField dg_tf_tendg;
    @FXML
    private Label jLabel48;
    @FXML
    private ComboBox<?> dg_search_gioitinh;
    @FXML
    private Label jLabel51;
    @FXML
    private Label jLabel52;
    @FXML
    private Label jLabel53;
    @FXML
    private Label jLabel55;
    @FXML
    private Label jLabel73;
    @FXML
    private Button dg_rs_btn;
    @FXML
    private Button dg_cancel_btn;
    @FXML
    private Label dg_tf_madg;
    @FXML
    private Button jButton6;
    @FXML
    private DatePicker dg_ngay;
    @FXML
    private Pane jPanel2;
    @FXML
    private Pane jPanel10;
    @FXML
    private Label jLabel79;
    @FXML
    private Label jLabel80;
    @FXML
    private Label jLabel81;
    @FXML
    private ScrollPane jScrollPane8;
    @FXML
    private TableView<?> tbl_phieumuon;
    @FXML
    private TableColumn<?, ?> c1;
    @FXML
    private TableColumn<?, ?> c2;
    @FXML
    private TableColumn<?, ?> c3;
    @FXML
    private TextField phieumuon_tf_madg;
    @FXML
    private TextField phieumuon_tf_tien;
    @FXML
    private Label jLabel22;
    @FXML
    private Label phieumuon_crntDate;
    @FXML
    private Label phieumuon_crntUser;
    @FXML
    private SplitPane jSeparator3;
    @FXML
    private Pane jPanel11;
    @FXML
    private Label jLabel82;
    @FXML
    private TextField msach_tf_tensach;
    @FXML
    private Button jButton12;
    @FXML
    private ScrollPane jScrollPane9;
    @FXML
    private TableView<?> tbl_msach;
    @FXML
    private Button jButton26;
    @FXML
    private Button jButton1;
    @FXML
    private Button jButton25;
    @FXML
    private Button jButton11;
    @FXML
    private Button jButton2;
    @FXML
    private Pane qlpm_pane;
    @FXML
    private ScrollPane jScrollPane3;
    @FXML
    private TableView<?> tbl_pmTongHop;
    @FXML
    private TableColumn<?, ?> title1;
    @FXML
    private TableColumn<?, ?> title2;
    @FXML
    private TableColumn<?, ?> title3;
    @FXML
    private TableColumn<?, ?> title4;
    @FXML
    private Label jLabel41;
    @FXML
    private Button jButton3;
    @FXML
    private Label jLabel83;
    @FXML
    private ComboBox<?> pmTongHop_tt_search;
    @FXML
    private SplitPane jSeparator5;
    @FXML
    private SplitPane jSeparator6;
    @FXML
    private Label jLabel84;
    @FXML
    private Label jLabel85;
    @FXML
    private Label jLabel88;
    @FXML
    private Label jLabel86;
    @FXML
    private Label jLabel87;
    @FXML
    private Button btn_pmTongHop_update;
    @FXML
    private Button btn_pmTongHop_delete;
    @FXML
    private Button btn_pmTongHop_cancel;
    @FXML
    private ScrollPane jScrollPane11;
    @FXML
    private TableView<?> tbl_qlpm_ctpm;
    @FXML
    private Button btn_pmTongHop_xoaPM;
    @FXML
    private Button btnPrint;
    @FXML
    private Button btn_qlpm_suaSach;
    @FXML
    private Label txt_pmTongHop_tienCoc;
    @FXML
    private Label txt_pmTongHop_docGia;
    @FXML
    private DatePicker pmTongHop_ngaythue_search;
    @FXML
    private Pane jPanel13;
    @FXML
    private ScrollPane jScrollPane4;
    @FXML
    private TableView<?> tbl_trasach;
    @FXML
    private TableColumn<?, ?> c4;
    @FXML
    private TableColumn<?, ?> c5;
    @FXML
    private Label jLabel16;
    @FXML
    private TextField jTextField1;
    @FXML
    private Button jButton23;
    @FXML
    private SplitPane jSeparator4;
    @FXML
    private ScrollPane jScrollPane10;
    @FXML
    private TableView<?> tbl_trasach_ctpm;
    @FXML
    private Label jLabel18;
    @FXML
    private Label jLabel19;
    @FXML
    private Label jLabel20;
    @FXML
    private Label jLabel89;
    @FXML
    private Label jLabel21;
    @FXML
    private Label jLabel17;
    @FXML
    private Label lbl_TraSach_tiencoc;
    @FXML
    private Label lbl_TraSach_nhanvien;
    @FXML
    private Label lbl_TraSach_maphieu;
    @FXML
    private Label lbl_TraSach_ngayTra;
    @FXML
    private Label lbl_TraSach_dg;
    @FXML
    private Label lbl_TraSach_ngayThue;
    @FXML
    private Button btn_trasach_giahan;
    @FXML
    private Button btn_trasach_trahet;
    @FXML
    private Pane jPanel4;
    @FXML
    private Label jLabel;
    @FXML
    private Label jLabel33;
    @FXML
    private Button tl_them_btn;
    @FXML
    private Button tl_del_btn;
    @FXML
    private Button tl_update_btn;
    @FXML
    private Button tl_rs_btn;
    @FXML
    private Button tl_cancel_btn;
    @FXML
    private Button jButton16;
    @FXML
    private Label jLabel34;
    @FXML
    private Label jLabel35;
    @FXML
    private TextField tl_tf_ten;
    @FXML
    private ScrollPane jScrollPane6;
    @FXML
    private TableView<?> tbl_tl;
    @FXML
    private Label jLabel36;
    @FXML
    private Label jLabel38;
    @FXML
    private TextField nxb_tf_ten;
    @FXML
    private TextField nxb_tf_diachi;
    @FXML
    private TextField nxb_tf_sdt;
    @FXML
    private Label jLabel37;
    @FXML
    private Label jLabel39;
    @FXML
    private Button nxb_them_btn;
    @FXML
    private Button nxb_del_btn;
    @FXML
    private Button nxb_update_btn;
    @FXML
    private Button nxb_rs_btn;
    @FXML
    private Button nxb_cancel_btn;
    @FXML
    private Button jButton20;
    @FXML
    private ScrollPane jScrollPane7;
    @FXML
    private TableView<?> tbl_nxb;
    @FXML
    private TableColumn<?, ?> SDT;
    @FXML
    private Label tl_tf_matl;
    @FXML
    private Label nxb_tf_manxb;
    @FXML
    private Pane jPanel3;
    @FXML
    private Label jLabel10;
    @FXML
    private Label jLabel11;
    @FXML
    private Label jLabel12;
    @FXML
    private Label jLabel13;
    @FXML
    private Label jLabel14;
    @FXML
    private Label jLabel15;
    @FXML
    private Label jLabel30;
    @FXML
    private TextField sach_tf_ten;
    @FXML
    private TextField sach_tf_sotrang;
    @FXML
    private TextField sach_tf_ngonngu;
    @FXML
    private TextField sach_tf_sl;
    @FXML
    private ComboBox<?> sach_tl;
    @FXML
    private ComboBox<?> sach_nxb;
    @FXML
    private Label jLabel101;
    @FXML
    private Label jLabel1011;
    @FXML
    private Label jLabel10111;
    @FXML
    private Label jLabel10112;
    @FXML
    private Button sach_them_btn;
    @FXML
    private Button sach_del_btn;
    @FXML
    private Button sach_update_btn;
    @FXML
    private Button sach_rs_btn;
    @FXML
    private Button sach_cancel_btn;
    @FXML
    private TextField sach_tf_ten_search;
    @FXML
    private Button jButton8;
    @FXML
    private Label jLabel43;
    @FXML
    private ComboBox<?> sach_tl1;
    @FXML
    private Label jLabel45;
    @FXML
    private ComboBox<?> sach_nxb1;
    @FXML
    private Button jButton14;
    @FXML
    private ScrollPane jScrollPane2;
    @FXML
    private TableView<?> tbl_sach;
    @FXML
    private TableView<?> tbl_tl_model;
    @FXML
    private TableColumn<?, ?> c6;
    @FXML
    private TableColumn<?, ?> c7;
    @FXML
    private Pane nv_panel;
    @FXML
    private ScrollPane jScrollPane5;
    @FXML
    private TableView<?> tbl_nv;
    @FXML
    private Button nv_btn_search;
    @FXML
    private TextField nv_search;
    @FXML
    private Label jLabel49;
    @FXML
    private Button jButton13;
    @FXML
    private Pane dg_panel1;
    @FXML
    private Label jLabel23;
    @FXML
    private Label jLabel24;
    @FXML
    private Label jLabel29;
    @FXML
    private Label jLabel27;
    @FXML
    private Label jLabel28;
    @FXML
    private Label jLabel26;
    @FXML
    private Label jLabel25;
    @FXML
    private Label jLabel47;
    @FXML
    private TextField nv_tf_tuoi;
    @FXML
    private TextField nv_tf_cmnd;
    @FXML
    private TextField nv_tf_diachi;
    @FXML
    private TextField nv_tf_sdt;
    @FXML
    private Button nv_them_btn;
    @FXML
    private Button nv_del_btn;
    @FXML
    private Button nv_upd_btn;
    @FXML
    private RadioButton nv_nam;
    @FXML
    private RadioButton nv_nu;
    @FXML
    private TextField nv_tf_tennv;
    @FXML
    private Label jLabel511;
    @FXML
    private Label jLabel521;
    @FXML
    private Label jLabel531;
    @FXML
    private Label jLabel551;
    @FXML
    private Label jLabel731;
    @FXML
    private Button nv_rs_btn;
    @FXML
    private Button nv_cancel_btn;
    @FXML
    private Label dg_tf_madg1;
    @FXML
    private TextField nv_tf_tdn;
    @FXML
    private Label jLabel5311;
    @FXML
    private Label jLabel42;
    @FXML
    private ComboBox<?> nv_capbac;
    @FXML
    private Label jLabel7311;
    @FXML
    private Button nv_reset_passwd;
    @FXML
    private Pane jPanel8;
    @FXML
    private Pane jPanel7;
    @FXML
    private Label jLabel54;
    @FXML
    private Label jLabel56;
    @FXML
    private Label jLabel57;
    @FXML
    private Label jLabel58;
    @FXML
    private Label jLabel59;
    @FXML
    private Label jLabel60;
    @FXML
    private Label jLabel61;
    @FXML
    private Label jLabel62;
    @FXML
    private Label jLabel64;
    @FXML
    private Button jButton9;
    @FXML
    private Button jButton10;
    @FXML
    private Label jLabel63;
    @FXML
    private Label jLabel71;
    @FXML
    private Label tt_tf_ma;
    @FXML
    private Label tt_tf_ten;
    @FXML
    private Label tt_tf_tdn;
    @FXML
    private Label tt_tf_sdt;
    @FXML
    private Label tt_tf_diachi;
    @FXML
    private Label tt_tf_tuoi;
    @FXML
    private Label tt_tf_cmnd;
    @FXML
    private Label tt_tf_gioitinh;
    @FXML
    private Label tt_tf_capbac;
    @FXML
    private Label jLabe40;
    private Label sach_tf_ma;

    giaoDlen gd = new giaoDlen();
     Object[][] nxb_data ;
    Object[] nxb_columns = {"Ma NXB","Ten","Dia Chi","SDT"};
    DefaultTableModel tbl_nxb_model = new DefaultTableModel(nxb_data,nxb_columns);
        Object[][] sach_data ;
    Object[] sach_columns = {"Ma Sach","Ten","So Trang","Ngon Ngu",
        "So Luong Ton","NXB","The Loai"};
    DefaultTableModel tbl_msach_model = new DefaultTableModel(sach_data,sach_columns);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sach_nxb = new ComboBox();
        sach_tf_ma = new Label();
    }    


    @FXML
    private void jLabe40MouseClicked(MouseEvent event) {                                      
       // new LoginDAO().setVisible(true);
        jLabe40.setVisible(false);
    }          
    
      public static Object getValueAt(TableView<?> table, int column, int row) {
    return table.getColumns().get(column).getCellObservableValue(row).getValue();
   
}
    @FXML
    private void tbl_tlMouseClicked(MouseEvent event) {
         
            tl_tf_matl.setText(String.valueOf(getValueAt(tbl_tl_model,1, (int) tbl_tl.getSelectionModel().getSelectedItem())));
            tl_tf_ten.setText(String.valueOf(getValueAt(tbl_tl_model,1, (int) tbl_tl.getSelectionModel().getSelectedItem())));
            
            tl_del_btn.setVisible(true);
            tl_cancel_btn.setVisible(true);
            tl_update_btn.setVisible(true);
            
            tl_them_btn.setVisible(false);
            tl_rs_btn.setVisible(false);
        
    }
 

    @FXML
    private void nxb_them_btnActionPerformed(ActionEvent event) {
         NhaXuatBan nxb = new NhaXuatBan(nxb_tf_diachi.getText(), nxb_tf_sdt.getText(), nxb_tf_ten.getText());
        if(!gd.validateNhaXuatBanForm()){
            return;
        }else{
            NhaXuatBanDAO nxbDAO = new NhaXuatBanDAO();
            nxbDAO.saveNhaXuatBan(nxb);
            gd.resetFormNhaXuatBan();
            gd.showTableNhaXuatBan();
            
            sach_nxb.getItems().removeAll();
       //    sach_nxb.getItems().addAll(new NhaXuatBanDAO().getDistinctNhaXuatBan());
           // addDataFromListToComboBox(sach_nxb,new NhaXuatBanDAO().getDistinctNhaXuatBan());
        }
        
    }

    @FXML
    private void nxb_del_btnActionPerformed(ActionEvent event) {
            NhaXuatBan nxb = new NhaXuatBan(nxb_tf_diachi.getText(), nxb_tf_sdt.getText(), nxb_tf_ten.getText());
        nxb.setManxb(Integer.parseInt(nxb_tf_manxb.getText()));
        NhaXuatBanDAO nxbDAO = new NhaXuatBanDAO();
        nxbDAO.deleteNhaXuatBan(nxb);
        gd.resetFormNhaXuatBan();
        gd.showTableNhaXuatBan();
        nxb_del_btn.setVisible(false);
        nxb_cancel_btn.setVisible(false);
        nxb_update_btn.setVisible(false);
        
        nxb_them_btn.setVisible(true);
        nxb_rs_btn.setVisible(true);
    }

    @FXML
    private void nxb_update_btnActionPerformed(ActionEvent event) {
                NhaXuatBan nxb = new NhaXuatBan(nxb_tf_diachi.getText(), nxb_tf_sdt.getText(), nxb_tf_ten.getText());
        nxb.setManxb(Integer.parseInt(nxb_tf_manxb.getText()));
        if(!gd.validateNhaXuatBanForm()){
            return;
        }else{
            NhaXuatBanDAO nxbDAO = new NhaXuatBanDAO();
            nxbDAO.updateNhaXuatBan(nxb);
            
            gd.resetFormNhaXuatBan();
            gd.showTableNhaXuatBan();
            nxb_del_btn.setVisible(false);
        nxb_cancel_btn.setVisible(false);
        nxb_update_btn.setVisible(false);
        
        nxb_them_btn.setVisible(true);
        nxb_rs_btn.setVisible(true);
        }
    }

    @FXML
    private void nxb_rs_btnActionPerformed(ActionEvent event) {
          gd.resetFormNhaXuatBan();
        gd.showTableNhaXuatBan();
    }

    @FXML
    private void nxb_cancel_btnActionPerformed(ActionEvent event) {
        gd.resetFormNhaXuatBan();
        tbl_nxb.getSelectionModel().clearSelection();
        nxb_del_btn.setVisible(false);
        nxb_cancel_btn.setVisible(false);
        nxb_update_btn.setVisible(false);
        
        nxb_them_btn.setVisible(true);
        nxb_rs_btn.setVisible(true);
    }

    @FXML
    private void jButton20ActionPerformed(ActionEvent event) {
          gd.resetTable(tbl_nxb_model);
        NhaXuatBanDAO nxbDAO = new NhaXuatBanDAO();
        List<NhaXuatBan> listNXB = nxbDAO.filterNhaXuatBan(nxb_tf_ten.getText());
        listNXB.stream().forEach(e -> {
            Object[] tmpRow = {e.getManxb(), e.getTen(),
                e.getDiachi(),e.getSdt()}; 
            tbl_nxb_model.addRow(tmpRow);
        });
    }

       
    @FXML
    private void tbl_nxbMouseClicked(MouseEvent event) {
               if(event.getSource()==MouseEvent.MOUSE_CLICKED){
            nxb_tf_manxb.setText(String.valueOf(getValueAt(tbl_nxb,(int)tbl_nxb.getSelectionModel().getSelectedItem(),0)));
            nxb_tf_ten.setText(String.valueOf(getValueAt(tbl_nxb,(int)tbl_nxb.getSelectionModel().getSelectedItem(),1)));
            nxb_tf_diachi.setText(String.valueOf(getValueAt(tbl_nxb,(int)tbl_nxb.getSelectionModel().getSelectedItem(),2)));
            nxb_tf_sdt.setText(String.valueOf(getValueAt(tbl_nxb,(int)tbl_nxb.getSelectionModel().getSelectedItem(),3)));
            
            nxb_del_btn.setVisible(true);
            nxb_cancel_btn.setVisible(true);
            nxb_update_btn.setVisible(true);
            
            nxb_them_btn.setVisible(false);
            nxb_rs_btn.setVisible(false);
        }
    }

    @FXML
    private void sach_them_btnActionPerformed(ActionEvent event) {
        Sach s = null;
        if(!gd.validateSachForm()){
            return;
        }       

        s = new Sach(sach_tf_ten.getText(),Integer.parseInt(sach_tf_sotrang.getText()),sach_tf_ngonngu.getText(),Integer.parseInt(sach_tf_sl.getText()));
        TheLoai tl = new TheLoaiDAO().filterTheLoai(String.valueOf(sach_tl.getSelectionModel().getSelectedItem())).get(0);
        NhaXuatBan nxb = new NhaXuatBanDAO().filterNhaXuatBan(String.valueOf(sach_nxb.getSelectionModel().getSelectedItem())).get(0);
        s.setTl(tl);
        s.setNxb(nxb);
        SachDAO sDAO = new SachDAO();
        List<Sach> list = sDAO.filterSach(sach_tf_ten.getText());
        if(list.isEmpty()){
            sDAO.saveSach(s);
            gd.resetFormSach();
            //reset tbl sach form muonsach avoid stack
            gd.resetTable(tbl_msach_model);
            gd.showTableSach();
        }else{
//            JOptionPane.showMessageDialog(null, "Sach da co, vui long cap nhat so luong","LOI",JOptionPane.ERROR_MESSAGE);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Sach da co, vui long cap nhat so luong", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }
    }

    @FXML
    private void sach_del_btnActionPerformed(ActionEvent event) {
            Sach s = new Sach(sach_tf_ten.getText(),Integer.parseInt(sach_tf_sotrang.getText()),sach_tf_ngonngu.getText(),Integer.parseInt(sach_tf_sl.getText()));
        s.setMasach(Integer.parseInt(sach_tf_ma.getText()));
        TheLoai tl = new TheLoaiDAO().filterTheLoai(String.valueOf(sach_tl.getSelectionModel().getSelectedItem())).get(0);
        NhaXuatBan nxb = new NhaXuatBanDAO().filterNhaXuatBan(String.valueOf(sach_nxb.getSelectionModel().getSelectedItem())).get(0);
        s.setTl(tl);
        s.setNxb(nxb);
        SachDAO sDAO = new SachDAO();                
        sDAO.deleteSach(s);
        gd.resetFormSach();
        gd.showTableSach();
        sach_del_btn.setVisible(false);
        sach_cancel_btn.setVisible(false);
        sach_update_btn.setVisible(false);
        
        sach_them_btn.setVisible(true);
        sach_rs_btn.setVisible(true);
    }

    @FXML
    private void sach_update_btnActionPerformed(ActionEvent event) {
         Sach s = null;
        if(!gd.validateSachForm()){
            return;
        }       

        s = new Sach(sach_tf_ten.getText(),Integer.parseInt(sach_tf_sotrang.getText()),sach_tf_ngonngu.getText(),Integer.parseInt(sach_tf_sl.getText()));
        s.setMasach(Integer.parseInt(sach_tf_ma.getText()));
        TheLoai tl = new TheLoaiDAO().filterTheLoai(String.valueOf(sach_tl.getSelectionModel().getSelectedItem())).get(0);
        NhaXuatBan nxb = new NhaXuatBanDAO().filterNhaXuatBan(String.valueOf(sach_nxb.getSelectionModel().getSelectedItem())).get(0);
        s.setTl(tl);
        s.setNxb(nxb);
        
        SachDAO sDAO = new SachDAO();
        List<Sach> list = sDAO.filterSach(sach_tf_ten.getText());
        if(list.size()<=1){
            sDAO.updateSach(s);
            gd.resetFormSach();
            gd.showTableSach();
        sach_del_btn.setVisible(false);
        sach_cancel_btn.setVisible(false);
        sach_update_btn.setVisible(false);
        
        sach_them_btn.setVisible(true);
        sach_rs_btn.setVisible(true);
        }else{
             Alert alert = new Alert(Alert.AlertType.INFORMATION, "Sach da co, vui long cap nhat so luong", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        //    JOptionPane.showMessageDialog(null, "Sach da co, vui long cap nhat so luong","LOI",JOptionPane.ERROR_MESSAGE);
        }
    }

 
    
}
