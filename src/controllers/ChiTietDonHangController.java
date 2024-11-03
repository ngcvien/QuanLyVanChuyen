package controllers;

import interfaces.IController;
import model.ChiTietDonHang;
import model.DonHang;
import model.HangHoa;
import model.KhachHang;
import services.ChiTietDonHangService;
import services.DonHangService;
import services.HangHoaService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChiTietDonHangController implements IController {
    private ChiTietDonHang chiTietDonHang;
    private ArrayList<ChiTietDonHang> chiTietDonHangs;
    private ChiTietDonHangService chiTietDonHangService;
    private Scanner sc;

    private ArrayList<DonHang> donHangs;
    private DonHangService donHangService;
    private DonHangController donHangController;

    private ArrayList<HangHoa> hangHoas;
    private HangHoaService hangHoaService;

    public ChiTietDonHangController() throws SQLException {
        chiTietDonHangService = new ChiTietDonHangService();
        chiTietDonHangs=chiTietDonHangService.findAll();
        chiTietDonHang = new ChiTietDonHang();
        sc = new Scanner(System.in);

        donHangService = new DonHangService();
        donHangs = donHangService.findAll();
        donHangController = new DonHangController();

        hangHoaService = new HangHoaService();
        hangHoas = hangHoaService.findAll();


    }

    @Override
    public void display() {
        System.out.println(chiTietDonHang.toStringHeader());
        for(ChiTietDonHang chiTietDonHang : chiTietDonHangs) {
            System.out.println(chiTietDonHang);
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
        System.out.println("Nhập ID đơn hàng");
        donHangController.display();
        System.out.print("ID đơn hàng: ");
        DonHang donHang = donHangController.findById(sc.nextInt());
        System.out.println("Nhập ID hàng hóa");
        for(HangHoa hangHoa : hangHoas) {
            System.out.println("   "+hangHoa.toStringIdAndName());
        }
        System.out.print("ID hàng hóa: ");
        HangHoa hangHoa = new HangHoa(sc.nextInt());
        System.out.print("Nhập số lượng: ");
        int soLuong = sc.nextInt();
        System.out.print("Nhập Đơn giá: ");
        int gia = sc.nextInt();
        sc.nextLine();
        ChiTietDonHang chiTietDonHang = new ChiTietDonHang(donHang,hangHoa,soLuong,gia);
        chiTietDonHangs.add(chiTietDonHang);
        chiTietDonHangService.save(chiTietDonHang);

    }
}
