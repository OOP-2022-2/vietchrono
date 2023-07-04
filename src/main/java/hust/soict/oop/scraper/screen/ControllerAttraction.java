package hust.soict.oop.scraper.screen;

import java.io.IOException;

import hust.soict.oop.scraper.event.Event;
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
	
	private Event event;
	
    @FXML
    private HBox itemC;

    @FXML
    private Label eventLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label ageLabel;

    @FXML
    private Label dynastyLabel;

    @FXML
    private Button detailButton;
    
    public ControllerAttraction(Event event) {
    	this.event = event;
    }

    public void setEventDetails() {
        // Set the event details in the UI elements
        eventLabel.setText(event.getEvent());
        dateLabel.setText(event.printDate());
        ageLabel.setText(event.getAge());
        dynastyLabel.setText(event.getDynasty());

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
            modalController.setModalDetails(this.event);

            // Show the modal and wait for it to be closed
            modalStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
