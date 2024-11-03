package model;

public class KhachHang {
    private int maKH;
    private String tenKH;
    private String diaChi;
    private String sdt;
    private String email;

    public KhachHang() {}

    public KhachHang(int makh, String tenKH, String diaChi, String soDienThoai, String email) {
        this.email = email;
        this.sdt = soDienThoai;
        this.diaChi = diaChi;
        this.tenKH = tenKH;
        this.maKH = makh;
    }

    public KhachHang(int makh, String tenKH) {
        this.tenKH = tenKH;
        this.maKH = makh;
    }

    public KhachHang(int maKH) {
        this.maKH = maKH;
    }

    public KhachHang(int maKH, String tenKH, String diachi) {
        this.tenKH = tenKH;
        this.maKH = maKH;
        this.diaChi = diachi;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String toStringHeader(){
        return String.format(
                        "+-------+----------------------+------------------+---------------------------+---------------+\n" +
                        "| ID    | Name                 | Dia Chi          | Sdt                       | Email         |\n" +
                        "+-------+----------------------+------------------+---------------------------+---------------+\n"
        );
    }

    @Override
    public String toString() {
        return String.format(
                "| %-5s | %-20s | %-16s | %-25s | %-13s |\n" +
                        "+-------+----------------------+------------------+---------------------------+---------------+\n",
                this.maKH, this.tenKH, this.diaChi, this.sdt, this.email
        );
    }

    public String toSringIdAndName(){
        return "Mã khách hàng: "+this.maKH+", tên: "+this.tenKH;
    }

}
