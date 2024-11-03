package model;

public class HangHoa {

    private int maHH;
    private String tenHH;
    private String loaiHang;
    private float trongluong;

    public HangHoa(int maHH, String tenHH, String loaiHang, float trongluong) {
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.loaiHang = loaiHang;
        this.trongluong = trongluong;
    }

    public HangHoa(int maHH) {
        this.maHH = maHH;
    }

    public int getMaHH() {
        return maHH;
    }

    public void setMaHH(int maHH) {
        this.maHH = maHH;
    }

    public String getTenHH() {
        return tenHH;
    }

    public void setTenHH(String tenHH) {
        this.tenHH = tenHH;
    }

    public String getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(String loaiHang) {
        this.loaiHang = loaiHang;
    }

    public float getTrongluong() {
        return trongluong;
    }

    public void setTrongluong(float trongluong) {
        this.trongluong = trongluong;
    }

    public static String toStringHeader() {
        return String.format(
                "+-------+----------------------+------------------+----------------+\n" +
                        "| ID    | Tên Hàng Hóa         | Loại hàng        | Trọng lượng    |\n" +
                        "+-------+----------------------+------------------+----------------+\n"
        );
    }

    @Override
    public String toString() {
        return String.format(
                "| %-5s | %-20s | %-16s | %-15s |\n" +
                        "+-------+----------------------+------------------+----------------+\n",
                this.maHH, this.tenHH, this.loaiHang, this.trongluong
        );
    }

    public String toStringIdAndName(){
        return "Mã hàng hóa: "+maHH+"| Tên hàng: "+tenHH;
    }
}
