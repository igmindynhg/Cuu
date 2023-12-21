/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Molder.NguoiDungModel;
import View.Login;
import View.ManHinhPhanQuyen;
import View.QuanLy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author AD
 */
public class NguoiDungController {

    private static Login dnview;
    private static QuanLy qlview;
    public static NguoiDungModel ndOn;

    public NguoiDungController(Login view) {

        NguoiDungController.dnview = view;
    }

    public NguoiDungController(QuanLy view) {

        NguoiDungController.qlview = view;
    }

    public NguoiDungController(NguoiDungModel view) {

        NguoiDungController.ndOn = view;
    }

    public void doLogin() {
        NguoiDungModel nd = dnview.LayDangNhap();
        System.out.println(nd);
        if (nd.getTaiKhoan().equals("") || nd.getMatKhau().equals("")) {
            dnview.Thongbao("Vui lòng nhập đầy đủ thông tin\n");
        } else {
            NguoiDungModel ndc = new NguoiDungModel().checkLogin(nd.getTaiKhoan(), nd.getMatKhau());

            if ("Quan ly".equals(ndc.getVaiTro())) {
                ndOn = ndc;
                dnview.Thongbao1("Đăng nhập thành công");
                ManHinhPhanQuyen mhpq = new ManHinhPhanQuyen();
                mhpq.setVisible(true);
                dnview.dispose();

            } else if ("Thu Ngan".equals(ndc.getVaiTro())) {
                ndOn = ndc;
                dnview.Thongbao1("Đăng nhập thành công");
                ManHinhPhanQuyen mhpq = new ManHinhPhanQuyen();
                mhpq.setVisible(true);
                dnview.dispose();
                mhpq.btn_QuanLy.setEnabled(false);
                mhpq.btn_PhaChe.setEnabled(false);

            } else if ("Pha Che".equals(ndc.getVaiTro())) {
                ndOn = ndc;
                dnview.Thongbao1("Đăng nhập thành công");
                ManHinhPhanQuyen mhpq = new ManHinhPhanQuyen();
                mhpq.setVisible(true);
                dnview.dispose();
                mhpq.btn_QuanLy.setEnabled(false);
                mhpq.btn_ThuNgan.setEnabled(false);

            } else {
                dnview.Thongbao("Đăng nhập thất bại");
            }
        }
    }

    public boolean Regex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
// them 
    public String regexTaiKhoan = "^([a-zA-Z0-9._%-]+@nhomdangiu\\.[vn]{2,4})*$";

    public void add() {
        NguoiDungModel nd = qlview.checkDangKy();
        if (nd.getTaiKhoan().equals("") || nd.getMatKhau().equals("") || nd.getVaiTro().equals("")) {
            qlview.Thongbao("Vui lòng nhập đầy đủ thông tin");
        } else if (!Regex(nd.getTaiKhoan(), regexTaiKhoan)) {
            qlview.Thongbao("Sai định dạng tài khoản @nhomdangiu.vn");
        } else if (nd.getMatKhau().length() < 6) {
            qlview.Thongbao("Mật khẩu đủ 6 ký tự");

        } else {
            boolean dkm = new NguoiDungModel().Them(nd);
            if (dkm == true) {
                qlview.Thongbao("Tạo thành công tài khoản");
            } else {
                qlview.Thongbao("bai bai");
            }
        }

    }

    public void update(QuanLy qltk) {
        NguoiDungModel tk = qlview.getTaiKhoan();
        

        if (tk.getTaiKhoan().equals("") || tk.getMatKhau().equals("") || tk.getVaiTro().equals("")) {
            JOptionPane.showMessageDialog(qltk, "Không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean rs = new NguoiDungModel().updateTK(tk);
            if (rs) {
                JOptionPane.showMessageDialog(qltk, "Update thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                qlview.TaiTrang(new NguoiDungModel().getDuLieu());

            } else {
                JOptionPane.showMessageDialog(qltk, "Update thất bại", "Thong bao", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void deleteTk(QuanLy view) {
        NguoiDungModel nd = view.getTaiKhoan();
        boolean ts = new NguoiDungModel().deleteTK(nd);
        if (ts) {
            JOptionPane.showMessageDialog(dnview, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            view.TaiTrang(new NguoiDungModel().getDuLieu());
        } else {
            JOptionPane.showMessageDialog(view, "Xóa thất bại");
        }

    }
}
