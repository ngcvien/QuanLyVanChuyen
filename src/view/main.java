package view;

import conf.Database;
import controllers.ChiTietDonHangController;
import controllers.DonHangController;
import controllers.HangHoaController;
import controllers.KhachHangController;
import interfaces.ICallbackVoid;
import model.ChiTietDonHang;
import model.DonHang;
import model.KhachHang;
import services.KhachHangService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class main {

    public static void start(ICallbackVoid callback) throws SQLException {
        Database.connect("localhost",
                3306,
                "root",
                "",
                "quanlyvanchuyen");
        callback.exec();
        Database.close();
    }


    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        start(() -> {
            KhachHangController khachHangController = new KhachHangController();
            HangHoaController hangHoaController = new HangHoaController();
            KhachHangService khachHangService = new KhachHangService();
            KhachHang khachHang = new KhachHang();
            DonHangController donHangController = new DonHangController();

            ChiTietDonHangController chiDonHangController = new ChiTietDonHangController();
//            khachHangController.display();
            while (true) {
                System.out.println("Menu");
                System.out.println("1.Nhap thong tin Khách Hàng");
                System.out.println("2. In tất cả Khách hàng");
                System.out.println("3. Nhập thông tin Hàng Hóa");
                System.out.println("4.In thông tin hàng hóa");
                System.out.println("5.Nhập đơn hàng");
                System.out.println("6.In tất cả đơn hàng");
                System.out.println("7.Tìm khách hàng bằng ID");
                System.out.println("8.Nhập chi tiết đơn hàng");
                System.out.println("9.In các chi tiết hóa đơn");
                System.out.println("vv..");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                if (choice == 0) {
                    break;
                }
                switch (choice) {
                    case 1: {
                        khachHangController.insert();
                        break;
                    }
                    case 2: {
                        khachHangController.display();
                        break;
                    }
                    case 3: {
                        hangHoaController.insert();
                        break;
                    }
                    case 4: {
                        hangHoaController.display();
                        break;
                    }
                    case 5: {
                        donHangController.insert();
                        break;
                    }
                    case 6: {
                        donHangController.display();
                        break;
                    }
                    case 7: {
                        System.out.println("Nhập ID khách hàng cần tìm: ");
                        int id = sc.nextInt();
                        System.out.println(KhachHang.toStringHeader());
                        System.out.println(khachHangController.findById(id));
                        sc.nextLine();
                        break;
                    }
                    case 8: {
                        chiDonHangController.insert();
                        break;
                    }
                    case 9: {
                        chiDonHangController.display();
                        break;
                    }
                }
            }
        });

//        PreparedStatement stmt = Database.getConnection().prepareStatement("select * from `khachhang`");
//        ResultSet rs = stmt.executeQuery();
//        while (rs.next()) {
//            System.out.println(rs.getString("tenKH"));
//            KhachHang khachHang = new KhachHang(
//                    rs.getInt("makh"),rs.getString("tenKH"),rs.getString("DiaChi"),
//                    rs.getString("SoDienThoai"), rs.getString("email")
//            );
//
//        }
//        System.out.println(Database.getConnection());
//        Database.getConnection();
//        System.out.println();
//        rs.close();
    }
}
