package lopputyo.sovellus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name="bgg077.kiinteistot")
public class Premise {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull(message="Syötä arvo")
	@Size(min = 2, message="Vähintään 2 kirjainta")
	private String address;
	
	@NotNull(message="Syötä arvo")
	@Size(min = 2, message="Vähintään 2 kirjainta")
	private String city;
	
	private String description;
	private String img = "https://icon-library.net/images/placeholder-image-icon/placeholder-image-icon-7.jpg";
	
	private int myynnissa;
	

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="typeid")
	private Type type;
	
	//@ManyToOne
	//@JoinColumn(name="fileid")
	//private File file;
	
	

	public Premise(long id,
			@NotNull(message = "Syötä arvo") @Size(min = 2, message = "Vähintään 2 kirjainta") String address,
			@NotNull(message = "Syötä arvo") @Size(min = 2, message = "Vähintään 2 kirjainta") String city,
			String description, String img, int myynnissa, Type type, File file) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.description = description;
		this.img = img;
		this.myynnissa = myynnissa;
		this.type = type;
//		this.file = file;
	}


	public Premise() {
		super();
	}


	public Premise(long id, @NotNull @Size(min = 2, message = "Vähintään 2 kirjainta") String address,
			@NotNull @Size(min = 2, message = "Vähintään 2 kirjainta") String city, String description, String img,
			int myynnissa, Type type) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.description = description;
		this.img = img;
		this.myynnissa = myynnissa;
		this.type = type;
	}
	
	
	//for h2
	public Premise(String address, String city, String description, String img, int myynnissa, Type type) {
		super();
		this.address = address;
		this.city = city;
		this.description = description;
		this.img = img;
		this.myynnissa = myynnissa;
		this.type = type;
	}



/*	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}*/


	public int getMyynnissa() {
		return myynnissa;
	}


	public void setMyynnissa(int myynnissa) {
		this.myynnissa = myynnissa;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Premise [id=" + id + ", address=" + address + ", city=" + city + ", description=" + description
				+ ", img=" + img + ", myynnissa=" + myynnissa + ", type=" + type + "]";
	}
	
	
	
	
	
	

}
