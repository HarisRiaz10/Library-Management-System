package com.libraryjavafx;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import com.libraryjavafx.NhanVien;
import com.libraryjavafx.NhanVienDAO;
import com.libraryjavafx.giaoDlen;

/**
 * FXML Controller class
 */
public class resetPasswordViewController implements Initializable {

    @FXML
    private Pane jPanel1;
    @FXML
    private Label jLabel4;
    @FXML
    private PasswordField pwd;
    @FXML
    private Label jLabel5;
    @FXML
    private PasswordField cpwd;
    @FXML
    private Button jButton1;
    @FXML
    private Button jButton2;
    @FXML
    private Label jLabel41;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void jButton1ActionPerformed(ActionEvent event) {
        if(String.valueOf(pwd.getText()).equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Mat Khau ko dc de trong", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
            //JOptionPane.showMessageDialog(null, "Mat Khau ko dc de trong","LOI",JOptionPane.ERROR_MESSAGE);            
        }else{
            if(!String.valueOf(pwd.getText()).equals(String.valueOf(cpwd.getText()))){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Xac Nhan Mat Khau sai", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
                //JOptionPane.showMessageDialog(null, "Xac Nhan Mat Khau sai","LOI",JOptionPane.ERROR_MESSAGE);            
            }else{
                NhanVien nv = new NhanVien();
                //1 object in 2 session, error
                //1 session get, 1 session update
                nv.setMatkhau(String.valueOf(pwd.getText()));
                NhanVienDAO nvDAO = new NhanVienDAO();
                nvDAO.updateNhanVien(nv);
                giaoDlen gd = new giaoDlen();
                 Alert alert = new Alert(Alert.AlertType.INFORMATION, "Dat Mat Khau thanh cong", ButtonType.OK);
                 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                 alert.show();
                //JOptionPane.showMessageDialog(null, "Dat Mat Khau thanh cong"); 
                gd.showTableNhanVien();
            }
        }
    }

    @FXML
    private void jButton2ActionPerformed(ActionEvent event) {
        Platform.exit();
    }
    
}
