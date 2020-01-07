package application;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;

import application.models.Client;
import application.repositories.ClientRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Controle {
	
	
	@FXML
	private Button myBtn;
	
	@FXML
	private TextArea myTextArea;
	
	@FXML
	private ComboBox<String> clientIds;
	
	@FXML
	private Button stringFormat;
	
	@FXML 
	private Button jsonFormat;
	
	@FXML
	private Button xmlFormat;
	
	
	private ClientRepository clientRepository;
	
	private static List<Client> clients;
	
	private String ids[];
	
	private Client selectedClient;
	
	
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
			jsonFormat.setDisable(true);
			stringFormat.setDisable(true);
			xmlFormat.setDisable(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@FXML
	public void selectId() {
		if(clientIds.getSelectionModel().getSelectedIndex()!=0) {
			myTextArea.setStyle("-fx-text-fill: black;");
			for (Client client : clients) {
				if(client.getId()==Long.valueOf(clientIds.getSelectionModel().getSelectedItem())) {
					this.selectedClient=client;
					myTextArea.setText(client.toString());
					stringFormat.setDisable(true);
					jsonFormat.setDisable(false);
					xmlFormat.setDisable(false);
				}
			}
		}
	}
	
	@FXML
	public void setToJsonFormat() {
		myTextArea.setStyle("-fx-text-fill: black;");
		if(this.selectedClient!=null) {
			Gson gson=new Gson();
			myTextArea.setText(gson.toJson(this.selectedClient));
			jsonFormat.setDisable(true);
			stringFormat.setDisable(false);
			xmlFormat.setDisable(false);
		}
	}
	
	@FXML
	public void setToStringFormt() {
		if(this.selectedClient!=null) {
			myTextArea.setStyle("-fx-text-fill: black;");
			myTextArea.setText(this.selectedClient.toString());
			jsonFormat.setDisable(false);
			stringFormat.setDisable(true);
			xmlFormat.setDisable(false);
		}
	}
	
	@FXML
	public void setToxmlFormat() {
		if(this.selectedClient!=null) {
			myTextArea.setText("error in java 11 , some jar are not installed");
			myTextArea.setStyle("-fx-text-fill: red;");;
			jsonFormat.setDisable(false);
			stringFormat.setDisable(false);
			xmlFormat.setDisable(true);
		}
	}
	@FXML
	public void exitFormApp() {
		System.exit(0);
	}
	
//	   private static String jaxbObjectToXML(Client client) 
//	    {
//		   String xmlContent="";
//	        try
//	        {
//	            //Create JAXB Context
//	            JAXBContext jaxbContext = JAXBContext.newInstance(Client.class);
//	             
//	            //Create Marshaller
//	            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//	 
//	            //Required formatting??
//	            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//	 
//	            //Print XML String to Console
//	            StringWriter sw = new StringWriter();
//	             
//	            //Write XML to StringWriter
//	            jaxbMarshaller.marshal(client, sw);
//	             
//	            //Verify XML Content
//	            xmlContent = sw.toString();
//	            
//	           
//	 
//	        } catch (JAXBException e) {
//	            e.printStackTrace();
//	        }
//	        return xmlContent;
//	    }
}
