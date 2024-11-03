package interfaces;

import model.KhachHang;

import java.sql.SQLException;

public interface IController<X> {
    void display();
    void removeItem(long id) throws SQLException;
    void update(X x) throws SQLException;


    void insert() throws SQLException;
}
