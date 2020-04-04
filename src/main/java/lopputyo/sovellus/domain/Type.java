package lopputyo.sovellus.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Type {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long typeid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="type")
	private List<Premise> premises;

	public Type() {
		super();
	}
	
	public Type(String name) {
	super();
	this.name = name;
	}

	public Type(long typeid, String name, List<Premise> premises) {
		super();
		this.typeid = typeid;
		this.name = name;
		this.premises = premises;
	}

	public long getTypeid() {
		return typeid;
	}

	public void setTypeid(long typeid) {
		this.typeid = typeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Premise> getPremises() {
		return premises;
	}

	public void setPremises(List<Premise> premises) {
		this.premises = premises;
	}

	@Override
	public String toString() {
		return "Type [typeid=" + typeid + ", name=" + name + "]";
	}
	
	


}
