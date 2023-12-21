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

/**
 *
 * @author AD
 */
public class NguoiDungModel extends BaseModel {

    private String TaiKhoan;
    private String MatKhau;
    private String VaiTro;
    private int MaTaiKhoan;

    public NguoiDungModel() {
        this.TaiKhoan = null;
        this.MatKhau = null;
        this.VaiTro = null;

    }

    public NguoiDungModel(String TaiKhoan, String MatKhau, String VaiTro, int MaTaiKhoan) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.VaiTro = VaiTro;
        this.MaTaiKhoan = MaTaiKhoan;
    }

    public NguoiDungModel(String TaiKhoan, String MatKhau, String VaiTro) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.VaiTro = VaiTro;
    }

    public NguoiDungModel(String TaiKhoan, String MatKhau) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(String VaiTro) {
        this.VaiTro = VaiTro;
    }

    public int getMaTaiKhoan() {
        return MaTaiKhoan;
    }

    public void setMaTaiKhoan(int MaTaiKhoan) {
        this.MaTaiKhoan = MaTaiKhoan;
    }

    public NguoiDungModel checkLogin(String taiKhoan, String matKhau) {
        NguoiDungModel nd = new NguoiDungModel();
        System.out.println(nd);
        String sql = "";

        try (Connection conn = this.getConnBaseModel()) {
            sql = "select * from NguoiDung where TaiKhoan = ? and MatKhau = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, taiKhoan);

            statement.setString(2, matKhau);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                nd.setTaiKhoan(rs.getString(1));
                nd.setMatKhau(rs.getString(2));
                nd.setVaiTro(rs.getString(3));
                nd.setMaTaiKhoan(rs.getInt(4));
                return nd;
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy model!");
            System.out.println(nd);
        }
        return nd;
    }

    public ArrayList<NguoiDungModel> getDuLieu() {
        ArrayList<NguoiDungModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnBaseModel();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select MaTaiKhoan,TaiKhoan,MatKhau,ChucVu from NguoiDung");
            while (rs.next()) {
                NguoiDungModel nd = new NguoiDungModel();
                nd.setMaTaiKhoan(rs.getInt(1));
                nd.setTaiKhoan(rs.getString(2));
                nd.setMatKhau(rs.getString(3));
                nd.setVaiTro(rs.getString(4));;
                arr.add(nd);
            }
            return arr;
        } catch (Exception e) {
            System.out.println("Khong co cong viec");
        }
        return arr;
    }

    // Them tài khoản
    public boolean Them(NguoiDungModel dk) {
        String sql = "";
        try (Connection conn = this.getConnBaseModel()) {
//            sql = "insert into NguoiDung (HoTen,TaiKhoan,MatKhau) values(?,?,?)";
            sql = "insert into NguoiDung values (?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, dk.getTaiKhoan());
            st.setString(2, dk.getMatKhau());
            st.setString(3, dk.getVaiTro());
            st.executeUpdate();
            System.out.println(dk);
            return true;
        } catch (Exception e) {

            System.out.println(sql);

        }
        return false;
    }

    public Boolean updateTK(NguoiDungModel nd) {
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            sql = "update NguoiDung set TaiKhoan = ?,MatKhau = ?,ChucVu =? where MaTaiKhoan = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(2, nd.getMatKhau());
            st.setString(3, nd.getVaiTro());
            st.setString(1, nd.getTaiKhoan());
            st.setInt(4, nd.getMaTaiKhoan());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {

            System.out.println("bug r");
            System.out.println(nd);
//            System.out.println(sql);
        }
        return false;
    }

    public boolean deleteTK(NguoiDungModel nd) {
        String sql = "";
        try {
            Connection conn = this.getConnBaseModel();
            sql = "delete from NguoiDung where TaiKhoan = ? ";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nd.getTaiKhoan());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Xóa bị lỗi");
        }
        return false;
    }
}
