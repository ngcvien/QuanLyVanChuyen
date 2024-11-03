package services;

import conf.Database;
import interfaces.IService;
import model.HangHoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HangHoaService  implements IService<HangHoa> {

    public HangHoaService() {}

    private HangHoa hangHoaMapper(ResultSet rs) throws SQLException {
        HangHoa hangHoa = new HangHoa(
                rs.getInt("MaHH"),
                rs.getString("TenHH"),
                rs.getString("LoaiHang"),
                rs.getFloat("TrongLuong")
        );
        return hangHoa;
    }

    @Override
    public ArrayList<HangHoa> findAll() throws SQLException {
        ArrayList<HangHoa> hangHoaList = new ArrayList<>();
        PreparedStatement statement = Database.getConnection().prepareStatement("select * from HangHoa");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            hangHoaList.add(hangHoaMapper(rs));
        }

        return hangHoaList;
    }

    @Override
    public boolean save(HangHoa hangHoa) throws SQLException {
        PreparedStatement statement = Database.getConnection().prepareStatement(
                "INSERT INTO `hanghoa` (`MaHH`, `TenHH`, `LoaiHang`, `TrongLuong`) VALUES (?,?,?,?);"
        );
        statement.setInt(1,hangHoa.getMaHH());
        statement.setString(2,hangHoa.getTenHH());
        statement.setString(3,hangHoa.getLoaiHang());
        statement.setFloat(4,hangHoa.getTrongluong());
        int result = statement.executeUpdate();
        return result > 0;
    }

    @Override
    public boolean remove(long id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(HangHoa hangHoa) throws SQLException {
        return false;
    }

    @Override
    public HangHoa findById(long id) throws SQLException {
        return null;
    }


}
