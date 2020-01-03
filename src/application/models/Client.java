package application.models;



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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{'id':'"+this.getId()+"','name':'"+this.getName()+"'}";
	}
	
	
}
