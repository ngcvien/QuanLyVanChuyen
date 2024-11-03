package controllers;

import interfaces.IController;
import model.KhachHang;
import services.KhachHangService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class KhachHangController implements IController<KhachHang> {
    private KhachHangService khachHangService;
    private Scanner sc;
    private ArrayList<KhachHang> khachHangs;
    public KhachHangController() throws SQLException {
        sc = new Scanner(System.in);
        khachHangService = new KhachHangService();
        khachHangs = khachHangService.findAll();
    }

    @Override
    public void display() {
        System.out.println(KhachHang.toStringHeader());
        for (KhachHang khachHang : khachHangs) {
            System.out.println(khachHang);
        }
    }

    @Override
    public void removeItem(long id) throws SQLException {

    }

    @Override
    public void update(KhachHang khachHang) throws SQLException {

    }


    @Override
    public void insert() throws SQLException {
        System.out.println("Nhap Id khach hang: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ten Khach hang: ");
        String tenKhachHang = sc.nextLine();
        System.out.println("Nhập địa chỉ khách hàng: ");
        String diaChi= sc.nextLine();
        System.out.println("Nhap so dien thoai khach hang: ");
        String sdt= sc.nextLine();
        System.out.println("Nhap email khach hang: ");
        String email= sc.nextLine();
        KhachHang khachHang = new KhachHang(id, tenKhachHang, diaChi, sdt, email);
        this.khachHangs.add(khachHang);
        this.khachHangService.save(khachHang);
    }

    public KhachHang findById(long id) throws SQLException {
        for (KhachHang khachHang : khachHangs) {
            if(khachHang.getMaKH()==id)
                return khachHang;
        }
        return null;
    }



}
