import java.text.NumberFormat;
import java.util.Locale;

public class Account {
	private static final double LAI_SUAT = 0.035;
	private double soTien;
	private int soTK;
	private String tenTK;
	private String trangThai;
	
	//constructor mac dinh
	public Account() {
		this.soTien = 50;
		this.soTK = 999999;
		this.tenTK = "chua xac dinh";
	}
	//constructor 3 tham so
	public Account(double soTien, int soTK, String tenTK) {
		this.soTien = soTien;
		this.soTK = soTK;
		this.tenTK = tenTK;
	}
	public double getSoTien() {
		return soTien;
	}
	public void setSoTien(double soTien) {
		if(soTien >= 50) {
			this.soTien = soTien;
		} else {
			this.soTien = 50;
			setTrangThai("so tien phai lon hon hoacj bang 50");
		}
	}
	public int getSoTK() {
		return soTK;
	}
	public void setSoTK(int soTK) {
		if(soTK > 0 && soTK != 999999) {
			this.soTK = soTK;
		} else {
			this.soTK = 999999;
			setTrangThai("so tai khoan phai lon hon 0 va khac 999999");
		}
	}
	public String getTenTK() {
		return tenTK;
	}
	public void setTenTK(String tenTK) {
		if(!tenTK.isEmpty()) {
			this.tenTK = tenTK;
		} else {
			this.tenTK = "chua xac dinh" ;
			setTrangThai("ten tai khoan khong duoc rong");
		}
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	@Override
    public String toString() {
        // Tạo đối tượng Locale với ngôn ngữ và quốc gia
        Locale locale = new Locale("vi", "VN");

        // Tạo đối tượng NumberFormat với Locale
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);

        // Định dạng số tiền
        String soTienDaDinhDang = formatter.format(soTien);

        // Tạo chuỗi chứa toàn bộ thông tin tài khoản với số tiền đã định dạng
        String thongTinTaiKhoan = "Số tài khoản: " + soTK + "\n"
                + "Tên tài khoản: " + tenTK + "\n"
                + "Số tiền: " + soTienDaDinhDang + "\n"
                + "Trạng thái: " + trangThai;

        return thongTinTaiKhoan;
    }
	public void rutTien(double soTienRut) {
		if(soTienRut <= soTien) {
			soTien -= soTienRut;
			System.out.println("so tien da rut la "+ soTienRut+ " tu tai khoan " + tenTK);
		} else {
			System.out.println(" so tien rut khong du");
		}
	}
	public void napTien(double soTienNap) {
		if(soTienNap > 0) {
			soTien += soTienNap;
			System.out.println("da nap "+ soTienNap + " vao tai khoan "+ soTK);
		} else {
			System.out.println("so tien phai nap lon hon 0");
		}
	}
	public void chuyenKhoan(Account taiKhoanNhan, double soTienChuyen) {
        if (soTienChuyen <= soTien) {
            soTien -= soTienChuyen;
            taiKhoanNhan.napTien(soTienChuyen);
            System.out.println("Đã chuyển " + soTienChuyen + " từ tài khoản " + soTK + " sang tài khoản " + taiKhoanNhan.getSoTK());
        } else {
            System.out.println("Số dư không đủ để thực hiện giao dịch.");
        }
    }
	public void daoHan() {
		double laiSuat = soTien * LAI_SUAT;
		soTien += laiSuat;
		System.out.println("so du sau dao han cua tai khoan "+ 	soTK + " la "+ soTien);
	}
}




















