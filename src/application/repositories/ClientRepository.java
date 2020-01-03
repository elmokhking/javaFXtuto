package application.repositories;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.ConnectToDB;
import application.models.Client;

public class ClientRepository {
	
	
	
	
	public ClientRepository() {
		super();
		ConnectToDB.connect();
	}

	public List<Client> getAllClient() throws SQLException{
		List<Client> clients=new ArrayList<>();
		ResultSet rs=ConnectToDB.execute("SELECT * FROM client");
		while (rs.next()) {
			clients.add(new Client(Long.valueOf(rs.getString("id")),rs.getString("name")));
		}
		return clients;
	}

     
}
