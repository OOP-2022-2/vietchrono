package hust.soict.oop.scraper.screen;

import java.io.IOException;

import hust.soict.oop.scraper.figure.Figure;
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

public class ControllerFigure {
	private static final String VIEW_MODAL_PATH = "ViewModal.fxml";

	private Figure figure;

	@FXML
	private HBox itemC;

	@FXML
	private Label figureLabel;

	@FXML
	private Label periodLabel;

	@FXML
	private Label timeLabel;

	@FXML
	private Button detailButton;

	public ControllerFigure(Figure figure) {
		this.figure = figure;
	}

	public void setFigureDetails() {
		// Set the event details in the UI elements
		figureLabel.setText(figure.getName());
		timeLabel.setText(figure.getTime());
		periodLabel.setText(figure.getPeriod());

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
			modalController.setModalDetails(this.figure);

			// Show the modal and wait for it to be closed
			modalStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
