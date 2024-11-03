package services;

import conf.Database;
import interfaces.IService;
import model.KhachHang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KhachHangService implements IService<KhachHang> {

    public KhachHangService() {}

    private KhachHang khachHangMapper(ResultSet rs) throws SQLException {
        KhachHang khachHang = new KhachHang(

                rs.getInt("makh"),
                rs.getString("tenKH"),
                rs.getString("DiaChi"),
                rs.getString("SoDienThoai"),
                rs.getString("email")
        );
        return khachHang;
    }

    @Override
    public ArrayList<KhachHang> findAll() throws SQLException {
        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        PreparedStatement stmt = Database.getConnection().prepareStatement("select * from khachhang");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            khachHangs.add(khachHangMapper(rs));
        }
        return khachHangs;
    }

    @Override
    public boolean save(KhachHang khachHang) throws SQLException {
        PreparedStatement stmt = Database.getConnection().prepareStatement(
            "INSERT INTO `khachhang` (`MaKH`, `TenKH`, `DiaChi`, `SoDienThoai`, `Email`) VALUES (?, ?, ?, ?, ?);"
        );
        stmt.setInt(1, khachHang.getMaKH());
        stmt.setString(2, khachHang.getTenKH());
        stmt.setString(3, khachHang.getDiaChi());
        stmt.setString(4, khachHang.getSdt());
        stmt.setString(5, khachHang.getEmail());
        int affectedRows = stmt.executeUpdate();
        return affectedRows > 0;
    }

//    @Override
//    public boolean save(KhachHang khachHang) throws SQLException {
//        PreparedStatement stmt = Database.getConnection().prepareStatement(
//                "INSERT INTO `khachhang` (`MaKH`, `TenKH`, `DiaChi`, `SoDienThoai`, `Email`) VALUES (233, 'Thủy', 'QN', '08333333333', 'thuy@gmail.com');"
//        );
//
//        int affectedRows = stmt.executeUpdate();
//        return affectedRows > 0;
//    }

    @Override
    public boolean remove(long id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(KhachHang khachHang) throws SQLException {
        return false;
    }

    @Override
    public KhachHang findById(long id) throws SQLException {
        return null;
    }
}
