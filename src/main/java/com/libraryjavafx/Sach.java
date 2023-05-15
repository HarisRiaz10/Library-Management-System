/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryjavafx;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TableView;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.hibernate.annotations.Columns;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.swing.table.DefaultTableModel;


@Entity
@Table(appliesTo="sach")
public class Sach {
    
    
  //  public Object[][] danhSach_sach_data;
  //  public Object[] danhSach_sach_columns = {"Mã Sách","Tên Sách","Số lượng còn"};
  //  public DefaultTableModel tbl_sach_danhSach_model = new DefaultTableModel(danhSach_sach_data,danhSach_sach_columns);
  //  public TableView<?> tbl_sach_danhSach = new TableView<>();
  //  public Button chon = new Button();
  //  giaoDlen gd;
    
//    @Id
  //  @GeneratedValue(strategy = GenerationType.AUTO)
    @Columns(columns = {
    @Column(name="MASACH"),    
    @Column(name="TENSACH"),    
    @Column(name="SOTRANG"),
    @Column(name="NGONNGU"),    
    @Column(name="SOLUONGTON")})

    int soluongton;
    int masach;
    String ngonngu;
    int sotrang;
    String tensach;
    
    @ManyToOne
    @JoinColumn(name="MANXB")
    NhaXuatBan nxb;
    
    @ManyToOne
    @JoinColumn(name="MATL")
    TheLoai tl;
    
    
    
    @OneToMany(mappedBy = "ctpm_id.sach",cascade = CascadeType.ALL)
    List<ChiTietPhieuMuon> ctpm = new ArrayList<ChiTietPhieuMuon>();
   
    
    
    public Sach() {
     //    initComponents();
      //  gd = new giaoDlen();
     //   tbl_sach_danhSach.setItems((ObservableList) tbl_sach_danhSach_model);
      //  chon.setVisible(false);
        showTableDanhSach();
    }

    public Sach(String tensach, int sotrang, String ngonngu, int soluongton) {
        this.tensach = tensach;
        this.sotrang = sotrang;
        this.ngonngu = ngonngu;
        this.soluongton = soluongton;
    }

    public void resetTable(DefaultTableModel tblModel){
        for(int i=tblModel.getRowCount()-1;i>=0;i--){
            tblModel.removeRow(i);
        }
    }
    public void showTableDanhSach(){
        SachDAO sachDAO = new SachDAO();
        List<Sach> listSach = sachDAO.getAllSach();
        for (int i = 0; i < listSach.size(); i++) {
            Object[] tmpRow =new Object[]
            {
                listSach.get(i).getMasach(), listSach.get(i).getTensach()
                ,listSach.get(i).getSoluongton()
            };
            
           //    tbl_sach_danhSach_model.addRow(tmpRow);      
        }
        
    }
    public static Object getValueAt(TableView<?> table, int column, int row) {
    return table.getColumns().get(column).getCellObservableValue(row).getValue();
   
}
    
        private void formWindowClosed(java.awt.event.WindowEvent evt) {                                  
                List<Sach> sach = new ArrayList();
      //  for(int i=0 ; i<tbl_sach_danhSach.getItems().size() ; i++){
            Sach s = new Sach();
         //   s.setMasach(Integer.parseInt(String.valueOf(getValueAt(tbl_sach_danhSach,0, i))));
         //   s.setSoluongton(Integer.parseInt(String.valueOf(getValueAt(tbl_sach_danhSach,2, i))));
            sach.add(s);
     //   }
     //   gd.getListFromsach(sach);
    }     
    
  //  public void passingFrame(giaoDlen gd){
  //      this.gd = gd;
  //  }
    
    public int getMasach() {
        return masach;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

   

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public int getSotrang() {
        return sotrang;
    }

    public void setSotrang(int sotrang) {
        this.sotrang = sotrang;
    }

    public String getNgonngu() {
        return ngonngu;
    }

    public void setNgonngu(String ngonngu) {
        this.ngonngu = ngonngu;
    }

    public int getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }

    public NhaXuatBan getNxb() {
        return nxb;
    }

    public void setNxb(NhaXuatBan nxb) {
        this.nxb = nxb;
    }

    public TheLoai getTl() {
        return tl;
    }

    public void setTl(TheLoai tl) {
        this.tl = tl;
    }

    public List<ChiTietPhieuMuon> getCtpm() {
        return ctpm;
    }

    public void setCtpm(List<ChiTietPhieuMuon> ctpm) {
        this.ctpm = ctpm;
    }
    
    
}
