package cuong.fa.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * @author hocuong
 *@since 1999/08/18
 *sdsds
 */
@Entity
public class ToaNha {
	@Id
	@GeneratedValue(generator = "my_generator")  
	@GenericGenerator(name = "my_generator", strategy = "cuong.fa.mygenerator.MyGeneratorToaNha")
	@Column(columnDefinition = "varchar(5)")
	private String maToaNha;
	
	@Column(columnDefinition = "varchar(50)")
	@Length(max = 50,message = "ky tu qua dai !")
	@NotBlank(message = "please input name !")
	private String tenToaNha;
	
	@OneToMany(mappedBy = "toaNha", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TTPhiTrungCu> tTPhiTrungCu;
	
	public ToaNha() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param maToaNha
	 * @param tenToaNha
	 */
	public ToaNha(String maToaNha,
			@Length(max = 50, message = "ky tu qua dai !") @NotBlank(message = "please input name !") String tenToaNha) {
		super();
		this.maToaNha = maToaNha;
		this.tenToaNha = tenToaNha;
		
	}

	
	public String getMaToaNha() {
		return maToaNha;
	}

	public void setMaToaNha(String maToaNha) {
		this.maToaNha = maToaNha;
	}

	public String getTenToaNha() {
		return tenToaNha;
	}

	public void setTenToaNha(String tenToaNha) {
		this.tenToaNha = tenToaNha;
	}

	public List<TTPhiTrungCu> gettTPhiTrungCu() {
		return tTPhiTrungCu;
	}

	public void settTPhiTrungCu(List<TTPhiTrungCu> tTPhiTrungCu) {
		this.tTPhiTrungCu = tTPhiTrungCu;
	}

	
	@Override
	public String toString() {
		return "ToaNha [maToaNha=" + maToaNha + ", tenToaNha=" + tenToaNha + "]";
	}

}
