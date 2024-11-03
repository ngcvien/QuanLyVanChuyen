package model;

public class ChiTietDonHang {
    private DonHang donHang;
    private HangHoa hangHoa;
//    private KhachHang khachHang;
    private int soLuong;
    private int donGia;

    public ChiTietDonHang() {}

//    public ChiTietDonHang(DonHang donHang, HangHoa hangHoa,KhachHang khachHang, int soLuong, int donGia) {
//        this.donHang = donHang;
//        this.hangHoa = hangHoa;
//        this.khachHang = khachHang;
//        this.soLuong = soLuong;
//        this.donGia = donGia;
//    }


    public ChiTietDonHang(DonHang donHang, HangHoa hangHoa, int soLuong, int donGia) {
        this.donHang = donHang;
        this.hangHoa = hangHoa;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public ChiTietDonHang(DonHang donHang) {
        this.donHang = donHang;
    }


    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }

    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }

//    public KhachHang getKhachHang() {
//        return khachHang;
//    }
//
//    public void setKhachHang(KhachHang khachHang) {
//        this.khachHang = khachHang;
//    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

//    public static String toStringHeader() {
//        return String.format(
//                        "+-------+-----------------+-----------------+----------------+\n" +
//                        "| ID ĐH |                 | Loại hàng        | Trọng lượng    |\n" +
//                        "+-------+-----------------+------------------+----------------+\n"
//        );
//    }
//
//    @Override
//    public String toString() {
//        return String.format(
//                "| %-5s | %-15s | %-16s | %-15s |\n" +
//                        "+-------+-----------------+------------------+----------------+\n",
//                donHang.getMaDH(), khachHang.getMaKH() , khachHang.getTenKH(),khachHang.getDiaChi(),
//                hangHoa.getTenHH(),hangHoa.getTrongluong(),
//                soLuong, donGia,soLuong*donGia
//        );
//    }


    public String toStringHeader() {
        return String.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+\n"
                           + "|     ID đơn      |  ID Khách hàng  |  Tên khách hàng |    Địa chỉ      |    Tên hàng     |   Trọng lượng   |    Số lượng     |   Đơn giá(VND)  | Thành tiền(VND) |\n"
                           + "+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+\n");
    }

    public String toString() {
        return String.format("| %15s | %15s | %15s | %15s | %15s | %15s | %15s | %15s | %15s |\n"
                + "+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+\n",
                donHang.getMaDH(),
                donHang.getKhachHang().getMaKH(),
                donHang.getKhachHang().getTenKH(),
                donHang.getKhachHang().getDiaChi(),
                hangHoa.getTenHH(),
                hangHoa.getTrongluong(),
                soLuong,
                donGia,
                soLuong * donGia);
    }
}

