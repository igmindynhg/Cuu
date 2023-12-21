/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Molder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author AD
 */
public class MenuModel extends BaseModel {

    private int id;
    private String maMon;
    private String tenMon;
    private String kichCo;
    private int gia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public MenuModel(int id, String maMon, String tenMon, String kichCo, int gia) {
        this.id = id;
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.kichCo = kichCo;
        this.gia = gia;
    }

    public MenuModel(String maMon, String tenMon, String kichCo, int gia) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.kichCo = kichCo;
        this.gia = gia;
    }

    public MenuModel(String tenMon, String kichCo, int gia) {
        this.tenMon = tenMon;
        this.kichCo = kichCo;
        this.gia = gia;
    }

    public MenuModel() {
    }

    public ArrayList<MenuModel> getDuLieu() {
        ArrayList<MenuModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select id,MaMon,TenMon,KichCo,Gia from Menu");
            while (rs.next()) {
                MenuModel mn = new MenuModel();
                mn.setId(rs.getInt(1));
                mn.setMaMon(rs.getString(2));
                mn.setTenMon(rs.getString(3));
                mn.setKichCo(rs.getString(4));
                mn.setGia(rs.getInt(5));
                arr.add(mn);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Khong co cong viec");
        }
        return arr;
    }
public ArrayList<MenuModel> getDuLieu1() {
        ArrayList<MenuModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select TenMon,KichCo,Gia from Menu");
            while (rs.next()) {
                MenuModel mn = new MenuModel();
                mn.setTenMon(rs.getString(1));
                mn.setKichCo(rs.getString(2));
                mn.setGia(rs.getInt(3));
                arr.add(mn);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Khong co cong viec");
        }
        return arr;
    }
    
    public boolean Them(MenuModel dk) {
        String sql = "";
        try (Connection conn = this.getConnBaseModel()) {
//            sql = "insert into NguoiDung (HoTen,TaiKhoan,MatKhau) values(?,?,?)";
            sql = "insert into Menu values (?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, dk.getMaMon());
            st.setString(2, dk.getTenMon());
            st.setString(3, dk.getKichCo());
            st.setInt(4, dk.getGia());
            st.executeUpdate();
            System.out.println(dk);
            return true;
        } catch (Exception e) {

            System.out.println(sql);

        }
        return false;
    }

    public Boolean update(MenuModel dk) {
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            sql = "update Menu set MaMon = ?,TenMon = ?,KichCo =?,Gia=? where id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, dk.getMaMon());
            st.setString(2, dk.getTenMon());
            st.setString(3, dk.getKichCo());
            st.setInt(4, dk.getGia());
            st.setInt(5, dk.getId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {

            System.out.println("bug r");
            System.out.println(dk);
//            System.out.println(sql);
        }
        return false;
    }

    public boolean delete(MenuModel nd) {
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            sql = "delete from Menu where id = ? ";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, nd.getId());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Xóa bị lỗi");
        }
        return false;
    }

    public ArrayList<MenuModel> tim(String key) {
        ArrayList<MenuModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            String sql = "select*from Menu where TenMon like '%" + key + "%'";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                MenuModel mn = new MenuModel();
                mn.setId(rs.getInt(1));
                mn.setMaMon(rs.getString(2));
                mn.setTenMon(rs.getString(3));
                mn.setKichCo(rs.getString(4));
                mn.setGia(rs.getInt(5));
                arr.add(mn);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Không có");
        }
        return arr;
    }
}
