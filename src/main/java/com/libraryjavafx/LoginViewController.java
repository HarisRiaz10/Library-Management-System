package com.libraryjavafx;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import com.libraryjavafx.giaoDlen;
import com.libraryjavafx.NhanVienDAO;
import com.libraryjavafx.NhanVien;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;


/**
 * FXML Controller class
 */
public class LoginViewController implements Initializable {

    @FXML
    private TextField btnLogin_Username;
    @FXML
    private PasswordField pwd;
    @FXML
    private Button jButton1;
    @FXML
    private Button jButton2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void jButton1ActionPerformed(ActionEvent event) throws Exception {
        if(btnLogin_Username.getText().equals("")){
            Alert alert = new Alert(AlertType.INFORMATION, "Tai Khoan ko dc de trong", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
           // JOptionPane.showMessageDialog(null, "Tai Khoan ko dc de trong", "LOI", JOptionPane.ERROR_MESSAGE);
        }else if(String.valueOf(pwd.getText()).equals("")){
            Alert alert = new Alert(AlertType.INFORMATION, "Mat Khau ko dc de trong", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
          //  JOptionPane.showMessageDialog(null, "Mat Khau ko dc de trong", "LOI", JOptionPane.ERROR_MESSAGE);
        }else{
            NhanVienDAO nvDAO = new NhanVienDAO();
            List<NhanVien> nv = nvDAO.getNhanVienWithCrit(btnLogin_Username.getText(), String.valueOf(pwd.getText()));
            if(!nv.isEmpty()){
            if(nv.get(0).getCapbac().equalsIgnoreCase("quan ly") || nv.get(0).getCapbac().equalsIgnoreCase("boss")){
                       giaoDlen gd = new giaoDlen();
                       gd.showFormThongTin(nv.get(0));
                        gd.setVisible(true);
                        jButton1.setVisible(false);
            }else{
                       giaoDlen gd = new giaoDlen();
                       gd.showFormThongTin(nv.get(0));
                        gd.setVisible(true);
                        jButton1.setVisible(false);
                        gd.hideNV();
            }
            }else{
            Alert alert = new Alert(AlertType.INFORMATION, "Tai Khoan khong ton tai", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
            //JOptionPane.showMessageDialog(null, "Tai Khoan khong ton tai", "LOI", JOptionPane.ERROR_MESSAGE);
            }

          

        }
    }

    @FXML
    private void jButton2ActionPerformed(ActionEvent event) {
        System.exit(0);
    }
    
}
