/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Molder.MenuModel;
import View.QuanLy;
import javax.swing.JOptionPane;

/**
 *
 * @author AD
 */
public class MenuController {

    private static QuanLy qlview;
    public static MenuModel ndOn;

    public MenuController(QuanLy view) {
        MenuController.qlview = view;
    }

    public MenuController(MenuModel view) {
        MenuController.ndOn = view;
    }

    public void add() {
        MenuModel nd = qlview.checkMenu();
        int Gia = nd.getGia();
        String gia = String.valueOf(Gia);
        if (nd.getMaMon().equals("") || nd.getTenMon().equals("") || nd.getKichCo().equals("") || gia.equals("")) {
            qlview.Thongbao("Vui lòng nhập đầy đủ thông tin");
        } else {
            boolean dkm = new MenuModel().Them(nd);
            if (dkm == true) {
                qlview.Thongbao("Thêm thành công");
            } else {
                qlview.Thongbao("bai bai");
            }
        }

    }

    public void update(QuanLy view) {
        MenuModel nd = qlview.checkMenu();
        int Gia = nd.getGia();
        String gia = String.valueOf(Gia);
        if (nd.getMaMon().equals("") || nd.getTenMon().equals("") || nd.getKichCo().equals("") || gia.equals("")) {
            JOptionPane.showMessageDialog(qlview, "Không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean rs = new MenuModel().update(nd);
            if (rs) {
                JOptionPane.showMessageDialog(qlview, "Update thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                qlview.TaiTrang1(new MenuModel().getDuLieu());

            } else {
                JOptionPane.showMessageDialog(qlview, "Update thất bại", "Thong bao", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void delete(QuanLy view) {
        MenuModel nd = view.checkMenu();
        boolean ts = new MenuModel().delete(nd);
        if (ts) {
            JOptionPane.showMessageDialog(view, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            view.TaiTrang1(new MenuModel().getDuLieu());
        } else {
            JOptionPane.showMessageDialog(view, "Xóa thất bại");
        }

    }

}
