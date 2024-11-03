package services;

import conf.Database;
import interfaces.IService;
import model.DonHang;
import model.KhachHang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DonHangService implements IService<DonHang> {

  public DonHangService() {
  }


  public DonHang donHangMapper(ResultSet rs) throws SQLException {
    DonHang donHang = new DonHang(
        rs.getInt("madh"),
        new KhachHang(
            rs.getInt("makh"),
            rs.getString("tenkh")
        ),
        rs.getDate("ngaylap"),
        rs.getDate("ngaygiaohang")
    );
    return donHang;

  }

  @Override
  public ArrayList<DonHang> findAll() throws SQLException {
    ArrayList<DonHang> donHangs = new ArrayList<>();
    PreparedStatement ps = Database.getConnection().prepareStatement(
        "SELECT madh, donhang.makh, tenkh, ngaylap, ngaygiaohang" +
            " FROM donhang JOIN khachhang ON donhang.makh=khachhang.makh "
    );
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      donHangs.add(donHangMapper(rs));
    }
    return donHangs;
  }

  @Override
  public boolean save(DonHang donHang) throws SQLException {
    PreparedStatement ps = Database.getConnection().prepareStatement(
        "INSERT INTO `donhang` (`MaDH`, `MaKH`, `NgayLap`, `NgayGiaoHang`) VALUES (?, ?, ?, ?);");
    ps.setInt(1, donHang.getMaDH());
    ps.setInt(2, donHang.getKhachHang().getMaKH());
    ps.setDate(3, donHang.getNgayLap());
    ps.setDate(4, donHang.getNgayGiao());
    int rows = ps.executeUpdate();

    return rows > 0;
  }

  @Override
  public boolean remove(long id) throws SQLException {
    return false;
  }

  @Override
  public boolean update(DonHang donHang) throws SQLException {
    return false;
  }

  @Override
  public DonHang findById(long id) throws SQLException {
    return null;
  }
}
