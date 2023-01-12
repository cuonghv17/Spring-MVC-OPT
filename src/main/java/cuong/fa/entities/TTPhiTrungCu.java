package cuong.fa.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author hocuong
 *@since 1999/08/18
 *sdsds
 */
@Entity
public class TTPhiTrungCu {

	@Id
	@GeneratedValue(generator = "my_generator")
	@GenericGenerator(name = "my_generator", strategy = "cuong.fa.mygenerator.MyGeneratorTTPhiTrungCu")
	@Column(columnDefinition = "varchar(5)")
	private String maTT;
	
	@Column(columnDefinition = "varchar(50)")
	@Length(max = 50,message = "ky tu qua dai !")
	@NotBlank(message = "please input !")
	private String maCanHo;
	
	
	@Min(value = 1,message = "so luong phai lon hon 0!")
	private int dienTich;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maToaNha", referencedColumnName = "maToaNha")
	private ToaNha toaNha;
	
	@Column(columnDefinition = "varchar(50)")
	@Length(max = 50,message = "ky tu qua dai !")
	@NotBlank(message = "please input !")
	private String hoTenChuHo;
	
	
	@Column(columnDefinition = "varchar(11)")
	@Length(min=10,max = 11,message = "So dien thoai chua dung !")
	private String soDienThoai;
	
	//@PastOrPresent(nho hon)
		@FutureOrPresent(message = "ngay thue phai lon han ngay hien tai")
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate thangBD;
		
		@Min(value = 1,message = "So thang khong hop le!")
		@Max(value = 12, message = "So thang khong hop le")
		private int soThang;

		@FutureOrPresent(message = "ngay thue phai lon han ngay hien tai")
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate ngayDong;
		
	
	
	private int tongTien;



	public TTPhiTrungCu() {
		super();
		// TODO Auto-generated constructor stub
	}






	/**
	 * @param maTT
	 * @param maCanHo
	 * @param dienTich
	 * @param toaNha
	 * @param hoTenChuHo
	 * @param soDienThoai
	 * @param thangBD
	 * @param soThang
	 * @param ngayDong
	 * @param tongTien
	 */
	public TTPhiTrungCu(String maTT,
			@Length(max = 50, message = "ky tu qua dai !") @NotBlank(message = "please input !") String maCanHo,
			@Min(value = 1, message = "so luong phai lon hon 0!") int dienTich, ToaNha toaNha,
			@Length(max = 50, message = "ky tu qua dai !") @NotBlank(message = "please input !") String hoTenChuHo,
			@Length(min = 10, max = 11, message = "So dien thoai chua dung !") String soDienThoai,
			@FutureOrPresent(message = "ngay thue phai lon han ngay hien tai") LocalDate thangBD,
			@Min(value = 1, message = "So thang khong hop le!") @Max(value = 12, message = "So thang khong hop le") int soThang,
			@FutureOrPresent(message = "ngay thue phai lon han ngay hien tai") LocalDate ngayDong, int tongTien) {
		super();
		this.maTT = maTT;
		this.maCanHo = maCanHo;
		this.dienTich = dienTich;
		this.toaNha = toaNha;
		this.hoTenChuHo = hoTenChuHo;
		this.soDienThoai = soDienThoai;
		this.thangBD = thangBD;
		this.soThang = soThang;
		this.ngayDong = ngayDong;
		this.tongTien = tongTien;
	}






	public String getMaTT() {
		return maTT;
	}



	public void setMaTT(String maTT) {
		this.maTT = maTT;
	}



	public String getMaCanHo() {
		return maCanHo;
	}



	public void setMaCanHo(String maCanHo) {
		this.maCanHo = maCanHo;
	}



	public int getDienTich() {
		return dienTich;
	}



	public void setDienTich(int dienTich) {
		this.dienTich = dienTich;
	}



	public ToaNha getToaNha() {
		return toaNha;
	}



	public void setToaNha(ToaNha toaNha) {
		this.toaNha = toaNha;
	}



	public String getHoTenChuHo() {
		return hoTenChuHo;
	}



	public void setHoTenChuHo(String hoTenChuHo) {
		this.hoTenChuHo = hoTenChuHo;
	}



	public String getSoDienThoai() {
		return soDienThoai;
	}



	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}



	public LocalDate getThangBD() {
		return thangBD;
	}



	public void setThangBD(LocalDate thangBD) {
		this.thangBD = thangBD;
	}



	public int getSoThang() {
		return soThang;
	}



	public void setSoThang(int soThang) {
		this.soThang = soThang;
	}



	public LocalDate getngayDong() {
		return ngayDong;
	}



	public void setngayDong(LocalDate ngayDong) {
		this.ngayDong = ngayDong;
	}



	public int getTongTien() {
		return tongTien;
	}



	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}



	@Override
	public String toString() {
		return "TTPhiTrungCu [maTT=" + maTT + ", maCanHo=" + maCanHo + ", dienTich=" + dienTich + ", toaNha=" + toaNha
				+ ", hoTenChuHo=" + hoTenChuHo + ", soDienThoai=" + soDienThoai + ", thangBD=" + thangBD + ", soThang="
				+ soThang + ", ngayDong=" + ngayDong + ", tongTien=" + tongTien + "]";
	}
	
	
	

}
