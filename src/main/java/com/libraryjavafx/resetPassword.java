package com.libraryjavafx;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

public class resetPassword {

    NhanVien nv;
    giaoDlen gd;
    public resetPassword() {

    }
    
    public void reopenFrame(giaoDlen gd){
        this.gd = gd;
    }
    
    public void passNV(NhanVien nv){
        this.nv = new NhanVien();
        this.nv.setManv(nv.getManv());
        this.nv.setTendangnhap(nv.getTendangnhap());
        this.nv.setTennv(nv.getTennv());
        this.nv.setMatkhau(nv.getMatkhau());
        this.nv.setSdt(nv.getSdt());
        this.nv.setDiachi(nv.getDiachi());
        this.nv.setTuoi(nv.getTuoi());
        this.nv.setCMND(nv.getCMND());
        this.nv.setGioitinh(nv.getGioitinh());
        this.nv.setCapbac(nv.getCapbac());
    }
}
