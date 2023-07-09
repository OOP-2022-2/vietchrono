package hust.soict.oop.scraper.screen.controllers;

import java.io.IOException;

import hust.soict.oop.scraper.festival.Festival;
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
import static hust.soict.oop.scraper.paths.Paths.*;

public class ControllerFestival {

	private Festival festival;

	@FXML
	private HBox itemC;

	@FXML
	private Label nameLabel;

	@FXML
	private Label dateLabel;

	@FXML
	private Label locationLabel;

	@FXML
	private Button detailButton;

	public ControllerFestival(Festival festival) {
		this.festival = festival;
	}

	public void setFestivalDetails() {
		nameLabel.setText(festival.getName());
		dateLabel.setText(festival.getDate());
		locationLabel.setText(festival.getLocation());
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
			modalController.setModalDetails(this.festival);

			// Show the modal and wait for it to be closed
			modalStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
