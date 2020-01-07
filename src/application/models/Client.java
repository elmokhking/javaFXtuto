package application.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {

	private Long id;
	
	private String name;
	
	public Client() {
	
	}

	public Client(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@XmlAttribute
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "id:"+this.getId()+"\nname:"+this.getName();
	}
	
	
}
