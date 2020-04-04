package lopputyo.sovellus.domain;

//import java.util.Arrays;
import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
//import javax.persistence.OneToMany;

@Entity
public class File {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long fileid;
	
	private String name, type;
	
	@Lob
	private byte[] file;
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="file")
	//private List<Premise> premises;
	

	public File() {
	}

	public File(long fileid, String name, String type, byte[] file, List<Premise> premises) {
		super();
		this.fileid = fileid;
		this.name = name;
		this.type = type;
		this.file = file;
	//	this.premises = premises;
	}

	public File (String name, String type, byte[] file) {
		this.name = name;
		this.type = type;
		this.file = file;
	}



	public long getFileid() {
		return fileid;
	}

	public void setFileid(long fileid) {
		this.fileid = fileid;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}


	

}
