package hust.soict.oop.scraper.screen;

import java.io.IOException;

import hust.soict.oop.scraper.location.Location;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerAttraction {
	private static final String VIEW_MODAL_PATH = "ViewModal.fxml";
	
	private Location attraction;
	
    @FXML
    private HBox itemC;

    @FXML
    private Label attractionLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label locationLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Button detailButton;
    
    public ControllerAttraction(Location attraction) {
    	this.attraction = attraction;
    }

    public void setAttractionDetails() {
        // Set the event details in the UI elements
    	attractionLabel.setText(attraction.getName());
    	timeLabel.setText(attraction.getDate());
    	locationLabel.setText(attraction.getLocation());
    	typeLabel.setText(attraction.getType());

        // Set button action or any additional event handling
//        detailButton.setOnAction(event -> {
//            // Handle the button click event for the event details
//        });
    }
    
    @FXML
    private void handleDetailButtonClick(ActionEvent event) {
        try {
            // Load the FXML file for the modal content            
            FXMLLoader loader = new FXMLLoader(getClass().getResource(VIEW_MODAL_PATH));
            Parent root = loader.load();

            // Create a new stage (modal) to show the content
            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.setTitle("Details");
            modalStage.setScene(new Scene(root));
            
            // Set the event details in the Event.fxml controller
            ControllerModal modalController = loader.getController();
            modalController.setModalDetails(this.attraction);

            // Show the modal and wait for it to be closed
            modalStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
