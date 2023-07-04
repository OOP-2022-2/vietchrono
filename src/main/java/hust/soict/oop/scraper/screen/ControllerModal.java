package hust.soict.oop.scraper.screen;

import hust.soict.oop.scraper.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ControllerModal {

    @FXML
    private ScrollPane modalScrollPane;

    @FXML
    private VBox contentBox;

    public void setModalDetails(Event event) {
        Label eventLabel = new Label("Event: " + event.getEvent());
        Label dateLabel = new Label("Date: " + event.printDate());
        Label ageLabel = event.getAge() == null || event.getAge().equals("") ? null : new Label("Age: " + event.getAge());
        Label dynastyLabel = event.getDynasty() == null || event.getDynasty().equals("") ? null : new Label("Dynasty: " + event.getDynasty());
        Label descriptionLabel = event.getDescription() == null || event.getDescription().equals("") ? null : new Label("Description: " + event.getDescription());

        eventLabel.setStyle("-fx-text-fill: white;");
        dateLabel.setStyle("-fx-text-fill: white;");
        if (ageLabel != null)
            ageLabel.setStyle("-fx-text-fill: white;");
        if (dynastyLabel != null)
            dynastyLabel.setStyle("-fx-text-fill: white;");
        if (descriptionLabel != null)
            descriptionLabel.setStyle("-fx-text-fill: white;");

        // Set wrap text for all labels
        eventLabel.setWrapText(true);
        dateLabel.setWrapText(true);
        if (ageLabel != null)
            ageLabel.setWrapText(true);
        if (dynastyLabel != null)
            dynastyLabel.setWrapText(true);
        if (descriptionLabel != null)
            descriptionLabel.setWrapText(true);

        // Create a VBox to hold all the non-null labels
        VBox vbox = new VBox();
        vbox.getChildren().addAll(eventLabel, dateLabel);
        if (ageLabel != null)
            vbox.getChildren().add(ageLabel);
        if (dynastyLabel != null)
            vbox.getChildren().add(dynastyLabel);
        if (descriptionLabel != null)
            vbox.getChildren().add(descriptionLabel);

        // Set the spacing between labels
        vbox.setSpacing(10);

        // Apply margins to the labels
        VBox.setMargin(eventLabel, new Insets(20, 10, 0, 20));
        VBox.setMargin(dateLabel, new Insets(0, 10, 0, 20));
        if (ageLabel != null)
            VBox.setMargin(ageLabel, new Insets(0, 10, 0, 20));
        if (dynastyLabel != null)
            VBox.setMargin(dynastyLabel, new Insets(0, 10, 0, 20));
        if (descriptionLabel != null)
            VBox.setMargin(descriptionLabel, new Insets(0, 10, 20, 20));

        // Clear existing children from contentBox
        contentBox.getChildren().clear();

        // Add the VBox to the contentBox
        contentBox.getChildren().add(vbox);

        // Bind the contentBox width to the modalScrollPane width
        contentBox.prefWidthProperty().bind(modalScrollPane.widthProperty());
        contentBox.minHeightProperty().bind(modalScrollPane.heightProperty());
    }

}
