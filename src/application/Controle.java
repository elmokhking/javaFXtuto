package application;

import java.util.Arrays;
import java.util.List;
import application.models.Client;
import application.repositories.ClientRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class Controle {
	
	
	@FXML
	private Button myBtn;
	
	@FXML
	private TextArea myTextArea;
	
	@FXML
	private ComboBox<String> clientIds;
	
	private ClientRepository clientRepository;
	
	private static List<Client> clients;
	
	private String ids[];
	
	
	@FXML
	public void initialize() {
		try {
			clientRepository=new ClientRepository();
			clients=clientRepository.getAllClient();
			ids=new String[clients.size()+1];
			for (int i=1;i<=clients.size();i++) {
				ids[i]=clients.get(i-1).getId()+"";
			}
			ids[0]="choose a client id:";
			clientIds.getItems().addAll(FXCollections.observableArrayList(ids));
			clientIds.getSelectionModel().select(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@FXML
	public void selectId() {
		if(clientIds.getSelectionModel().getSelectedIndex()!=0) {
			for (Client client : clients) {
				if(client.getId()==Long.valueOf(clientIds.getSelectionModel().getSelectedItem())) {
					myTextArea.setText(client.toString());
				}
			}
		}
	}
	
}
