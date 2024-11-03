package services;

import conf.Database;
import interfaces.IService;
import model.ChiTietDonHang;
import model.DonHang;
import model.HangHoa;
import model.KhachHang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChiTietDonHangService implements IService<ChiTietDonHang> {
    public ChiTietDonHangService() {
    }

    public ChiTietDonHang chiTietDonHangMapper(ResultSet rs) throws SQLException {
        KhachHang khachHang = new KhachHang(rs.getInt("maKH"),rs.getString("tenKH"),
                rs.getString("diachi"));
        DonHang donHang = new DonHang(rs.getInt("maDH"), khachHang, rs.getDate("ngayLap"),
                rs.getDate("ngayGiaoHang"));
        HangHoa hangHoa = new HangHoa(rs.getInt("maHH"), rs.getString("tenHH"),
                rs.getString("loaiHang"), rs.getFloat("trongluong"));

        ChiTietDonHang chiTietDonHang = new ChiTietDonHang(
                donHang,
                hangHoa,
                rs.getInt("soluong"),
                rs.getInt("dongia")
        );
        return chiTietDonHang;
    }

    @Override
    public ArrayList<ChiTietDonHang> findAll() throws SQLException {
        ArrayList<ChiTietDonHang> chiTietDonHangs = new ArrayList<>();
        PreparedStatement statement = Database.getConnection().prepareStatement(
                "SELECT \n" +
                        "    ctdh.MaDH, \n" +
                        "    kh.MaKH, \n" +
                        "    ctdh.MaHH, \n" +
                        "    kh.TenKH, \n" +
                        "    kh.diachi, \n" +
                        "    hh.TenHH, \n" +
                        "    hh.loaihang, \n" +
                        "    hh.trongluong, \n" +
                        "    ctdh.SoLuong, \n" +
                        "    ctdh.DonGia, \n" +
                        "    dh.NgayLap, \n" +
                        "    dh.NgayGiaoHang\n" +
                        "FROM \n" +
                        "    chitietdonhang ctdh\n" +
                        "INNER JOIN donhang dh ON ctdh.MaDH = dh.MaDH\n" +
                        "INNER JOIN hanghoa hh ON ctdh.MaHH = hh.MaHH\n" +
                        "INNER JOIN khachhang kh ON kh.MaKH = dh.MaKH;"
        );
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            chiTietDonHangs.add(chiTietDonHangMapper(resultSet));
        }
        return chiTietDonHangs;
    }

    @Override
    public boolean save(ChiTietDonHang chiTietDonHang) throws SQLException {
        PreparedStatement statement = Database.getConnection().prepareStatement(
                "INSERT INTO `chitietdonhang` (`MaDH`, `MaHH`, `SoLuong`, `DonGia`) VALUES (?,?,?,?)");
        statement.setInt(1,chiTietDonHang.getDonHang().getMaDH());
        statement.setInt(2,chiTietDonHang.getHangHoa().getMaHH());
        statement.setInt(3,chiTietDonHang.getSoLuong());
        statement.setInt(4,chiTietDonHang.getDonGia());
        int rowsAffected = statement.executeUpdate();
        return rowsAffected > 0;
    }

    @Override
    public boolean remove(long id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(ChiTietDonHang chiTietDonHang) throws SQLException {
        return false;
    }

    @Override
    public ChiTietDonHang findById(long id) throws SQLException {
        return null;
    }
}
