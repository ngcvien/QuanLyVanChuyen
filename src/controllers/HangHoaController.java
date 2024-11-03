package controllers;

import interfaces.IController;
import model.HangHoa;
import services.HangHoaService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class HangHoaController implements IController {

    private Scanner sc;
    private HangHoaService hangHoaService;
    private ArrayList<HangHoa> hangHoas;

    public HangHoaController() throws SQLException {
        sc = new Scanner(System.in);
        hangHoaService = new HangHoaService();
        hangHoas = hangHoaService.findAll();
    }

    @Override
    public void display() {
        System.out.println(HangHoa.toStringHeader());
        for (HangHoa h : hangHoas) {
            System.out.println(h);
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
        System.out.println("Nhap id hang hoa: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ten Hang: ");
        String tenHang = sc.nextLine();
        System.out.println("Nhap loai hang: ");
        String loaiHang = sc.nextLine();
        System.out.println("Nhap trong luong");
        float trongLuong = sc.nextFloat();
        sc.nextLine();
        HangHoa hangHoa = new HangHoa(id, tenHang, loaiHang, trongLuong);
        hangHoaService.save(hangHoa);
        hangHoas.add(hangHoa);

    }

    public HangHoa findById(long id) throws SQLException {
      for (HangHoa h : hangHoas) {
        if(h.getMaHH()==id){
          return h;
        }
      }
      return null;
    }


}
