package controllers;

import interfaces.IController;
import model.DonHang;
import model.KhachHang;
import services.DonHangService;
import services.KhachHangService;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DonHangController implements IController {

    private Scanner sc;
    private DonHangService donHangService;
    private KhachHangService khachHangService;
    private KhachHangController khachHangController;
    private ArrayList<DonHang> donHangs;
    private ArrayList<KhachHang> khachHangs;

    public DonHangController() throws SQLException {
        donHangService = new DonHangService();
        khachHangService = new KhachHangService();
        sc = new Scanner(System.in);
        donHangs = donHangService.findAll();
        khachHangs = khachHangService.findAll();
        khachHangController = new KhachHangController();
    }


    @Override
    public void display() {
        System.out.println(DonHang.toStringHeader());
        for (DonHang donHang : donHangs) {
            System.out.println(donHang);
        }
    }

    @Override
    public void removeItem(long id) throws SQLException {

    }

    @Override
    public void update(Object o) throws SQLException {

    }

    @Override
    public void insert() throws SQLException {
        System.out.print("Nhập mã đơn hàng: ");
        int id = sc.nextInt();
        for (KhachHang khachHang : khachHangs) {
            System.out.println(khachHang.toSringIdAndName());
        }
        System.out.print("Chọn mã khách hàng: ");
        KhachHang khachHang = khachHangController.findById(sc.nextLong());
        sc.nextLine();
        System.out.print("Nhập ngày lập(yyyy-mm-dd): ");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date ngayLapSQL = null, ngayGiaoHangSQL = null;
        try {
            Date ngayLap = new Date(formatter.parse(sc.nextLine()).getTime());
            ngayLapSQL = new java.sql.Date(ngayLap.getTime());
            // Sử dụng đối tượng date
        } catch (ParseException e) {
            // Xử lý lỗi nếu định dạng chuỗi không hợp lệ
            System.out.println("Lỗi định dạng ngày tháng: " + e.getMessage());
        }
        System.out.print("Nhập ngày giao hàng(yyyy-mm-dd): ");
        try {
            Date ngayGiaoHang = new Date(formatter.parse(sc.nextLine()).getTime());
            ngayGiaoHangSQL = new java.sql.Date(ngayGiaoHang.getTime());
            // Sử dụng đối tượng date
        } catch (ParseException e) {
            // Xử lý lỗi nếu định dạng chuỗi không hợp lệ
            System.out.println("Lỗi định dạng ngày tháng: " + e.getMessage());
        }
        DonHang donHang = new DonHang(id, khachHang, ngayLapSQL, ngayGiaoHangSQL);
        donHangs.add(donHang);
        donHangService.save(donHang);

    }

    public DonHang findById(long id) throws SQLException {
        for (DonHang donHang : donHangs) {
            if(donHang.getMaDH() == id) {
                return donHang;
            }
        }
        return null;
    }
}
