package model;

import java.sql.Date;
import java.time.LocalDate;

public class DonHang {
    private int maDH;
    private KhachHang khachHang;
    private Date ngayLap;
    private Date ngayGiao;

    public DonHang(int maDH, KhachHang khachHang, Date ngayLap, Date ngayGiao) {
        this.maDH = maDH;
        this.khachHang = khachHang;
        this.ngayLap = ngayLap;
        this.ngayGiao = ngayGiao;
    }

    public DonHang(int maDH) {
        this.maDH = maDH;
    }

    public DonHang(int maDH, Date ngayLap, Date ngayGiaoHang) {
        this.maDH = maDH;
        this.ngayLap = ngayLap;
        this.ngayGiao = ngayGiaoHang;
    }




    public int getMaDH() {
        return maDH;
    }

    public void setMaDH(int maDH) {
        this.maDH = maDH;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Date getNgayLap() {
        return  ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap =  ngayLap;
    }

    public Date getNgayGiao() {
        return  ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public static String toStringHeader(){
        return String.format(
                        "+--------+----------------------+------------------+----------------+---------------+\n" +
                        "| ID đơn | Id Khách hàng        | Tên khách hàng   | ngày lập       | Ngày giao     |\n" +
                        "+------- +----------------------+------------------+----------------+---------------+\n"
         );
    }

    @Override
    public String toString() {
        return String.format(
                "| %-6s | %-20s | %-16s | %-14s | %-13s |\n" +
                        "+--------+----------------------+------------------+----------------+---------------+\n",
                this.maDH, khachHang.getMaKH(),khachHang.getTenKH(), this.ngayLap, this.ngayGiao
        );
    }
}
