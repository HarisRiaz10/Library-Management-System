package com.libraryjavafx;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
//import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.libraryjavafx.DAO;
import com.libraryjavafx.Sach;
import static com.libraryjavafx.Sach.getValueAt;
import com.libraryjavafx.giaoDlen;

/**
 * FXML Controller class
 */
public class sachViewController implements Initializable {

    @FXML
    private Label jLabel1;
    @FXML
    private TextField sach_tf_tensach_filter;
    @FXML
    private Button jButton1;
    @FXML
    private ScrollPane jScrollPane1;
    @FXML
    private TableView<?> tbl_sach_danhSach;
    @FXML
    private TableView<?> tbl_sach_danhSach_model;
    @FXML
    private TableColumn<?, ?> title1;
    @FXML
    private TableColumn<?, ?> title2;
    @FXML
    private TableColumn<?, ?> title3;
    @FXML
    private TableColumn<?, ?> title4;
    @FXML
    private Button chon;
    @FXML
    private Button jButton3;
    
   // private ObservableList<tbl_sach_danhSach> Tbl_Sach_DanhSach;

  //   Object[][] danhSach_sach_data;
 //   Object[] danhSach_sach_columns = {"Mã Sách","Tên Sách","Số lượng còn"};
 //   DefaultTableModel tbl_sach_danhSach_model = new DefaultTableModel(danhSach_sach_data,danhSach_sach_columns);
    /**
     * Initializes the controller class.
     */
    
    Sach sach;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sach = new Sach();
    }    

    @FXML
    private void jButton1ActionPerformed(ActionEvent event) {
             DAO dao = new DAO();
             
        sach_tf_tensach_filter.getText();
//        sach.resetTable(sach.tbl_sach_danhSach_model);
        dao.beginTransaction();
        
        List<Sach> listS = (List<Sach>)dao.getObjectsWithCriteria("Sach", "e.tensach like '%"+sach_tf_tensach_filter.getText()+"%'");
        dao.commitTransaction();
        dao.closeAll();
        listS.stream().forEach(e -> {
            Object[] tmpRow= new Object[]{
            e.getMasach(), e.getTensach()
                ,e.getSoluongton()
            };
  //          sach.tbl_sach_danhSach_model.addRow(tmpRow);
        });
    }

    @FXML
    private void tbl_sach_danhSachMouseClicked(MouseEvent event) {
        chon.setVisible(true);
    }

    public static Object getValueAt(TableView<?> table, int column, int row) {
    return table.getColumns().get(column).getCellObservableValue(row).getValue();
   
}
    @FXML
    private void chonActionPerformed(ActionEvent event) {
        giaoDlen gd = new giaoDlen();
        if(tbl_sach_danhSach.getItems().size()!= -1){                        
                for(int i = 0 ; i < gd.getTbl_qlpm_ctpm().getItems().size(); i++){
                    if(Integer.parseInt(String.valueOf(getValueAt(tbl_sach_danhSach_model,0, i)) ) == Integer.parseInt(String.valueOf(gd.getTbl_qlpm_ctpm_model().getValueAt(i, 0)) ) ) {
                        if(Integer.parseInt(String.valueOf(getValueAt(tbl_sach_danhSach,2, i)) ) > 0){
                            gd.getTbl_qlpm_ctpm_model().setValueAt(Integer.parseInt(String.valueOf(gd.getTbl_qlpm_ctpm_model().getValueAt(i, 2)) )+1,i, 2);                        
                          //  tbl_sach_danhSach.setValueAt(Integer.parseInt(String.valueOf(getValueAt(tbl_sach_danhSach,2, i)) )-1,2,tbl_sach_danhSach.getSelectionModel().getSelectedItem());
                            return;
                        }else{
                             Alert alert = new Alert(Alert.AlertType.INFORMATION, "Het Sach", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
                        //    JOptionPane.showMessageDialog(null,"Het Sach","LOI",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                    }
                    
                }
            }
            else{
                
            }   
        if(Integer.parseInt(String.valueOf(getValueAt(tbl_sach_danhSach_model,2,(int)tbl_sach_danhSach.getSelectionModel().getSelectedItem())) ) > 0){
               // tbl_sach_danhSach_model.setValueAt(Integer.parseInt(String.valueOf(sach.tbl_sach_danhSach_model.getValueAt(tbl_sach_danhSach.getSelectedRow(), 2)) )-1,tbl_sach_danhSach.getSelectedRow(), 2);
                Object[] tmpRow = {getValueAt(tbl_sach_danhSach_model,0,(int)tbl_sach_danhSach.getSelectionModel().getSelectedItem()), getValueAt(tbl_sach_danhSach_model,1,(int)tbl_sach_danhSach.getSelectionModel().getSelectedItem()),1};
                gd.getTbl_qlpm_ctpm_model().addRow(tmpRow);      
                gd.getTbl_qlpm_ctpm().getSelectionModel().clearSelection();           
        }
                
        
    }

    @FXML
    private void jButton3ActionPerformed(ActionEvent event) {
        Platform.exit();
    }
    
}
