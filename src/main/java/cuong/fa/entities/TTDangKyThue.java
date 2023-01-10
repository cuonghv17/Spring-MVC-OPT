package cuong.fa.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class TTDangKyThue {
	@Id
	@GeneratedValue(generator = "my_generator")
	@GenericGenerator(name = "my_generator", strategy = "cuong.fa.mygenerator.MyGeneratorTTDangKyThue")
	@Column(columnDefinition = "varchar(5)")
	private String maDK;

	@Column(columnDefinition = "varchar(50)")
	@Length(max = 50,message = "ky tu qua dai !")
	@NotBlank(message = "please input name !")
	private String tenKH;

	@Column(columnDefinition = "varchar(11)")
	@Length(min=10,max = 11,message = "Dinh dang khong hop le !")
	private String soDienThoai;

	@Min(value = 1,message = "so luong phai lon hon 0!")
	private int soLuongSan;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maLoaiSan", referencedColumnName = "maLoaiSan")
	private LoaiSan loaiSan;
	
	//@PastOrPresent(nho hon)
	@FutureOrPresent(message = "ngay thue phai lon han ngay hien tai")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayThue;
	
	
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime gioThue;
	
	@Min(value = 0,message = "tien coc phai lon hon hoac bang 0!")
	private int tienDatCoc;
	
	private int tienThanhToan;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayDatCoc;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayThanhToan;
	
	
	@Column(columnDefinition = "integer default 0" )
	@Range(min = 0, max = 2, message = "Nhập trang thai trong khoảng 0 - 2" )
	
	private int trangThai;

	public TTDangKyThue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TTDangKyThue(String tenKH, String soDienThoai, int soLuongSan, LoaiSan loaiSan, LocalDate ngayThue,
			LocalTime gioThue, int tienDatCoc, int tienThanhToan, LocalDate ngayDatCoc, LocalDate ngayThanhToan,
			@Range(min = 0, max = 2, message = "Nhập trang thai trong khoảng 0 - 2") int trangThai) {
		super();
		this.tenKH = tenKH;
		this.soDienThoai = soDienThoai;
		this.soLuongSan = soLuongSan;
		this.loaiSan = loaiSan;
		this.ngayThue = ngayThue;
		this.gioThue = gioThue;
		this.tienDatCoc = tienDatCoc;
		this.tienThanhToan = tienThanhToan;
		this.ngayDatCoc = ngayDatCoc;
		this.ngayThanhToan = ngayThanhToan;
		this.trangThai = trangThai;
	}

	public String getMaDK() {
		return maDK;
	}

	public void setMaDK(String maDK) {
		this.maDK = maDK;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getSoLuongSan() {
		return soLuongSan;
	}

	public void setSoLuongSan(int soLuongSan) {
		this.soLuongSan = soLuongSan;
	}

	public LoaiSan getLoaiSan() {
		return loaiSan;
	}

	public void setLoaiSan(LoaiSan loaiSan) {
		this.loaiSan = loaiSan;
	}

	public LocalDate getNgayThue() {
		return ngayThue;
	}

	public void setNgayThue(LocalDate ngayThue) {
		this.ngayThue = ngayThue;
	}

	public LocalTime getGioThue() {
		return gioThue;
	}

	public void setGioThue(LocalTime gioThue) {
		this.gioThue = gioThue;
	}

	public int getTienDatCoc() {
		return tienDatCoc;
	}

	public void setTienDatCoc(int tienDatCoc) {
		this.tienDatCoc = tienDatCoc;
	}

	public int getTienThanhToan() {
		return tienThanhToan;
	}

	public void setTienThanhToan(int tienThanhToan) {
		this.tienThanhToan = tienThanhToan;
	}

	public LocalDate getNgayDatCoc() {
		return ngayDatCoc;
	}

	public void setNgayDatCoc(LocalDate ngayDatCoc) {
		this.ngayDatCoc = ngayDatCoc;
	}

	public LocalDate getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(LocalDate ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "TTDangKyThue [maDK=" + maDK + ", tenKH=" + tenKH + ", soDienThoai=" + soDienThoai + ", soLuongSan="
				+ soLuongSan + ", loaiSan=" + loaiSan + ", ngayThue=" + ngayThue + ", gioThue=" + gioThue
				+ ", tienDatCoc=" + tienDatCoc + ", tienThanhToan=" + tienThanhToan + ", ngayDatCoc=" + ngayDatCoc
				+ ", ngayThanhToan=" + ngayThanhToan + ", trangThai=" + trangThai + "]";
	}
	
	

}
