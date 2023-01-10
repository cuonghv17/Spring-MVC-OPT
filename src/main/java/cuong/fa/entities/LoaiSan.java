package cuong.fa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;



@Entity
public class LoaiSan {
	@Id
	@GeneratedValue(generator = "my_generator")  
	@GenericGenerator(name = "my_generator", strategy = "cuong.fa.mygenerator.MyGeneratorLoaiSan")
	@Column(columnDefinition = "varchar(5)")
	private String maLoaiSan;
	
	@Column(columnDefinition = "varchar(50)")
	@Length(max = 50,message = "ky tu qua dai !")
	@NotBlank(message = "please input name !")
	private String tenLoaiSan;
//	
	@Min(value = 0,message = "gia thue khong duoc am!")
	private float giaThue;
	
	@OneToMany(mappedBy = "loaiSan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TTDangKyThue> tTDangKyThue;

	public LoaiSan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiSan( String tenLoaiSan, float giaThue) {
		super();
		
		this.tenLoaiSan = tenLoaiSan;
		this.giaThue = giaThue;
		
	}

	public String getMaLoaiSan() {
		return maLoaiSan;
	}

	public void setMaLoaiSan(String maLoaiSan) {
		this.maLoaiSan = maLoaiSan;
	}

	public String getTenLoaiSan() {
		return tenLoaiSan;
	}

	public void setTenLoaiSan(String tenLoaiSan) {
		this.tenLoaiSan = tenLoaiSan;
	}

	public float getGiaThue() {
		return giaThue;
	}

	public void setGiaThue(float giaThue) {
		this.giaThue = giaThue;
	}

	public List<TTDangKyThue> gettTDangKyThue() {
		return tTDangKyThue;
	}

	public void settTDangKyThue(List<TTDangKyThue> tTDangKyThue) {
		this.tTDangKyThue = tTDangKyThue;
	}

	@Override
	public String toString() {
		return "LoaiSan [maLoaiSan=" + maLoaiSan + ", tenLoaiSan=" + tenLoaiSan + ", giaThue=" + giaThue +"]";
	}

}
