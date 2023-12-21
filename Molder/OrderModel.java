/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Molder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AD
 */
public class OrderModel {
    private  int Maorder;
    private int TongTien;
    private String TrangThai;
    private String Despection;

    public OrderModel(int Maorder, int TongTien, String TrangThai, String Despection) {
        this.Maorder = Maorder;
        this.TongTien = TongTien;
        this.TrangThai = TrangThai;
        this.Despection = Despection;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getDespection() {
        return Despection;
    }

    public void setDespection(String Despection) {
        this.Despection = Despection;
    }

    private List<MenuModel> listMenu = new ArrayList<MenuModel>();

    public List<MenuModel> getListMenu() {
        return listMenu;
    }

    public void setListMenu(List<MenuModel> listMenu) {
        this.listMenu = listMenu;
    }
    
    public OrderModel(int Maorder, int TongTien) {
        this.Maorder = Maorder;
        this.TongTien = TongTien;
    }

    public int getMaorder() {
        return Maorder;
    }

    public void setMaorder(int Maorder) {
        this.Maorder = Maorder;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
}
