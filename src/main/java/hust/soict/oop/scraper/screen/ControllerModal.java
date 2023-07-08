package hust.soict.oop.scraper.screen;

import hust.soict.oop.scraper.dynasty.Dynasty;
import hust.soict.oop.scraper.event.Event;
import hust.soict.oop.scraper.festival.Festival;
import hust.soict.oop.scraper.figure.Figure;
import hust.soict.oop.scraper.figure.King;
import hust.soict.oop.scraper.location.Location;
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
    
    public void setModalDetails(Dynasty dynasty) {
    	Label xungDotLabel = new Label("Xung đột: " + dynasty.getXungDot());
    	Label thoiKyLabel = new Label("Thời kỳ: " + dynasty.getThoiKy());
    	Label doiPhuongLabel = new Label("Đối Phương: " + dynasty.getDoiPhuong());
    	Label ketQuaLabel = new Label("Kết Quả" + dynasty.getKetQua());
    	
    	xungDotLabel.setStyle("-fx-text-fill: white;");
    	thoiKyLabel.setStyle("-fx-text-fill: white;");
    	doiPhuongLabel.setStyle("-fx-text-fill: white;");
    	ketQuaLabel.setStyle("-fx-text-fill: white;");
    	
    	xungDotLabel.setWrapText(true);
    	thoiKyLabel.setWrapText(true);
    	doiPhuongLabel.setWrapText(true);
    	ketQuaLabel.setWrapText(true);
    	
    	VBox vbox = new VBox();
        vbox.getChildren().addAll(xungDotLabel, thoiKyLabel, doiPhuongLabel, ketQuaLabel);
        
        vbox.setSpacing(10);

        // Apply margins to the labels
        VBox.setMargin(xungDotLabel, new Insets(20, 10, 0, 20));
        VBox.setMargin(thoiKyLabel, new Insets(0, 10, 0, 20));
        VBox.setMargin(doiPhuongLabel, new Insets(0, 10, 0, 20));
        VBox.setMargin(ketQuaLabel, new Insets(0, 10, 0, 20));
    }
    public void setModalDetails(King king) {
    	Label kingLabel = new Label("Vua: " + king.getName());
    	Label countryLabel = new Label("Quốc gia: " + king.getCountry());
        Label timeLabel = new Label("Năm sinh - Năm mất: " + king.getSinh() + "-" + king.getMat());
        Label reignLabel = new Label("Trị vì: " + king.getTriVi());
        
        Label huyLabel = king.getHuy().equals("Không rõ") ? null : new Label("Huý: " + king.getHuy());
        Label nienHieuLabel = king.getNienHieu().equals("Không rõ") ? null : new Label("Niên Hiệu: " + king.getNienHieu());
        Label thuyHieuLabel = king.getThuyHieu().equals("Không rõ") ? null : new Label("Thuỵ Hiệu: " + king.getThuyHieu());
        Label mieuHieuLabel = king.getMieuHieu().equals("Không rõ") ? null : new Label("Miếu Hiệu: " + king.getMieuHieu());
        
        Label trieuDaiLabel = king.getTrieuDai().equals("Không rõ") ? null : new Label("Triều Đại: " + king.getTrieuDai());
        Label tienNhiemLabel = king.getTienNhiem().equals("Không rõ") ? null : new Label("Tiền Nhiệm: " + king.getTienNhiem());
        Label keNhiemLabel = king.getKeNhiem().equals("Không rõ") ? null : new Label("Kế Nhiệm: " + king.getKeNhiem());
        
        Label anTangLabel = king.getAnTang().equals("Không rõ") ? null : new Label("An Táng: " + king.getAnTang());
        Label tonGiaoLabel = king.getTonGiao().equals("Không rõ") ? null : new Label("Tôn Giáo: " + king.getTonGiao());
        
        Label thanPhuLabel = king.getThanPhu().equals("Không rõ") ? null : new Label("Thân Phụ: " + king.getThanPhu());
        Label thanMauLabel = king.getThanMau().equals("Không rõ") ? null : new Label("Thân Mẫu: " + king.getThanMau());
        Label theThiepLabel = king.getTheThiep().equals("Không rõ") ? null : new Label("Thê Thiếp: " + king.getTheThiep());
        
        Label pictureLabel = king.getPictureLink().equals("Không có ảnh") ? null : new Label("Ảnh: " + king.getPictureLink());

        Label descriptionLabel = king.getDescription() == null || king.getDescription().equals("") ? null : new Label("Thông tin: " + king.getDescription());

        kingLabel.setStyle("-fx-text-fill: white;");
        countryLabel.setStyle("-fx-text-fill: white;");
        timeLabel.setStyle("-fx-text-fill: white;");
        reignLabel.setStyle("-fx-text-fill: white;");
        
        if (huyLabel != null)
        	huyLabel.setStyle("-fx-text-fill: white;");
        if (nienHieuLabel != null)
        	nienHieuLabel.setStyle("-fx-text-fill: white;");
        if (thuyHieuLabel != null)
        	thuyHieuLabel.setStyle("-fx-text-fill: white;");
        if (mieuHieuLabel != null)
        	mieuHieuLabel.setStyle("-fx-text-fill: white;");
        
        if (trieuDaiLabel != null)
        	trieuDaiLabel.setStyle("-fx-text-fill: white;");
        if (tienNhiemLabel != null)
        	tienNhiemLabel.setStyle("-fx-text-fill: white;");
        if (keNhiemLabel != null)
        	keNhiemLabel.setStyle("-fx-text-fill: white;");
        
        if (anTangLabel != null)
        	anTangLabel.setStyle("-fx-text-fill: white;");
        if (tonGiaoLabel != null)
        	tonGiaoLabel.setStyle("-fx-text-fill: white;");
        
        if (thanPhuLabel != null)
        	thanPhuLabel.setStyle("-fx-text-fill: white;");
        if (thanMauLabel != null)
        	thanMauLabel.setStyle("-fx-text-fill: white;");
        if (theThiepLabel != null)
        	theThiepLabel.setStyle("-fx-text-fill: white;");
        
        if (pictureLabel != null)
        	pictureLabel.setStyle("-fx-text-fill: white;");
        
        if (descriptionLabel != null)
            descriptionLabel.setStyle("-fx-text-fill: white;");

        // Set wrap text for all labels
        kingLabel.setWrapText(true);
        timeLabel.setWrapText(true);
        countryLabel.setWrapText(true);
        reignLabel.setWrapText(true);
        
        if(huyLabel != null)
        	huyLabel.setWrapText(true);
        if(nienHieuLabel != null)
        	nienHieuLabel.setWrapText(true);
        if(thuyHieuLabel != null)
        	thuyHieuLabel.setWrapText(true);
        if(mieuHieuLabel != null)
        	mieuHieuLabel.setWrapText(true);
        
        if(trieuDaiLabel != null)
        	trieuDaiLabel.setWrapText(true);
        if(tienNhiemLabel != null)
        	tienNhiemLabel.setWrapText(true);
        if(keNhiemLabel != null)
        	keNhiemLabel.setWrapText(true);
        
        if(anTangLabel != null)
        	anTangLabel.setWrapText(true);
        
        if (tonGiaoLabel != null)
        	tonGiaoLabel.setWrapText(true);
        
        if (thanPhuLabel != null)
        	thanPhuLabel.setWrapText(true);
        if (thanMauLabel != null)
        	thanMauLabel.setWrapText(true);
        if (theThiepLabel != null)
        	theThiepLabel.setWrapText(true);
        
        if (pictureLabel != null)
        	pictureLabel.setWrapText(true);
        
        if (descriptionLabel != null)
            descriptionLabel.setWrapText(true);

        // Create a VBox to hold all the non-null labels
        VBox vbox = new VBox();
        vbox.getChildren().addAll(kingLabel, timeLabel, countryLabel, reignLabel);
        
        if(huyLabel != null)
        	vbox.getChildren().add(huyLabel);
        if(nienHieuLabel != null)
        	vbox.getChildren().add(nienHieuLabel);
        if(thuyHieuLabel != null)
        	vbox.getChildren().add(thuyHieuLabel);
        if(mieuHieuLabel != null)
        	vbox.getChildren().add(mieuHieuLabel);
        
        if(trieuDaiLabel != null)
        	vbox.getChildren().add(trieuDaiLabel);
        if(tienNhiemLabel != null)
        	vbox.getChildren().add(tienNhiemLabel);
        if(keNhiemLabel != null)
        	vbox.getChildren().add(keNhiemLabel);
        
        if(anTangLabel != null)
        	vbox.getChildren().add(anTangLabel);
        
        if (tonGiaoLabel != null)
        	vbox.getChildren().add(tonGiaoLabel);
        
        if (thanPhuLabel != null)
        	vbox.getChildren().add(thanPhuLabel);
        if (thanMauLabel != null)
        	vbox.getChildren().add(thanMauLabel);
        if (theThiepLabel != null)
        	vbox.getChildren().add(theThiepLabel);
        
        if (pictureLabel != null)
        	vbox.getChildren().add(pictureLabel);
        if (descriptionLabel != null)
            vbox.getChildren().add(descriptionLabel);

        // Set the spacing between labels
        vbox.setSpacing(10);

        // Apply margins to the labels
        VBox.setMargin(kingLabel, new Insets(20, 10, 0, 20));
        VBox.setMargin(timeLabel, new Insets(0, 10, 0, 20));
        VBox.setMargin(countryLabel, new Insets(0, 10, 0, 20));
        VBox.setMargin(reignLabel, new Insets(0, 10, 0, 20));
        
        if(huyLabel != null)
        	VBox.setMargin(huyLabel, new Insets(0, 10, 0, 20));
        if(nienHieuLabel != null)
        	VBox.setMargin(nienHieuLabel, new Insets(0, 10, 0, 20));
        if(thuyHieuLabel != null)
        	VBox.setMargin(thuyHieuLabel, new Insets(0, 10, 0, 20));
        if(mieuHieuLabel != null)
        	VBox.setMargin(mieuHieuLabel, new Insets(0, 10, 0, 20));
        
        if(trieuDaiLabel != null)
        	VBox.setMargin(trieuDaiLabel, new Insets(0, 10, 0, 20));
        if(tienNhiemLabel != null)
        	VBox.setMargin(tienNhiemLabel, new Insets(0, 10, 0, 20));
        if(keNhiemLabel != null)
        	VBox.setMargin(keNhiemLabel, new Insets(0, 10, 0, 20));
        
        if(anTangLabel != null)
        	VBox.setMargin(anTangLabel, new Insets(0, 10, 0, 20));
        
        if (tonGiaoLabel != null)
        	VBox.setMargin(tonGiaoLabel, new Insets(0, 10, 0, 20));
        
        if (thanPhuLabel != null)
        	VBox.setMargin(thanPhuLabel, new Insets(0, 10, 0, 20));
        if (thanMauLabel != null)
        	VBox.setMargin(thanMauLabel, new Insets(0, 10, 0, 20));
        if (theThiepLabel != null)
        	VBox.setMargin(theThiepLabel, new Insets(0, 10, 0, 20));
        
        if (pictureLabel != null)
        	VBox.setMargin(pictureLabel, new Insets(0, 10, 0, 20));
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
    public void setModalDetails(Figure figure) {
    	Label figureLabel = new Label("Tên: " + figure.getName());
    	Label otherNameLabel = new Label("Tên khác: " + figure.getOtherName());
        Label timeLabel = new Label("Năm sinh - Năm mất: " + figure.getTime());
        Label placeLabel = new Label("Quê quán: " + figure.getPlace());
        Label periodLabel = new Label("Thời kì: " + figure.getPeriod());
        Label descriptionLabel = figure.getDescription() == null || figure.getDescription().equals("") ? null : new Label("Thông tin: " + figure.getDescription());

        figureLabel.setStyle("-fx-text-fill: white;");
        timeLabel.setStyle("-fx-text-fill: white;");
        otherNameLabel.setStyle("-fx-text-fill: white;");
        placeLabel.setStyle("-fx-text-fill: white;");
        periodLabel.setStyle("-fx-text-fill: white;");
        if (descriptionLabel != null)
            descriptionLabel.setStyle("-fx-text-fill: white;");

        // Set wrap text for all labels
        figureLabel.setWrapText(true);
        timeLabel.setWrapText(true);
        otherNameLabel.setWrapText(true);
        placeLabel.setWrapText(true);
        periodLabel.setWrapText(true);
        if (descriptionLabel != null)
            descriptionLabel.setWrapText(true);

        // Create a VBox to hold all the non-null labels
        VBox vbox = new VBox();
        vbox.getChildren().addAll(figureLabel, otherNameLabel, timeLabel, periodLabel, placeLabel);
        if (descriptionLabel != null)
            vbox.getChildren().add(descriptionLabel);

        // Set the spacing between labels
        vbox.setSpacing(10);

        // Apply margins to the labels
        VBox.setMargin(figureLabel, new Insets(20, 10, 0, 20));
        VBox.setMargin(timeLabel, new Insets(0, 10, 0, 20));
        VBox.setMargin(otherNameLabel, new Insets(0, 10, 0, 20));
        VBox.setMargin(placeLabel, new Insets(0, 10, 0, 20));
        VBox.setMargin(periodLabel, new Insets(0, 10, 0, 20));
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

    public void setModalDetails(Location attraction) {
    	Label attractionLabel = new Label("Di tích: " + attraction.getName());
    	Label dateLabel = new Label("Thời gian công nhận: " + attraction.getDate());
        Label locationLabel = new Label("Địa điểm: " + attraction.getLocation());
        Label typeLabel = new Label("Loại di tích: " + attraction.getType());
        
        attractionLabel.setStyle("-fx-text-fill: white;");
        dateLabel.setStyle("-fx-text-fill: white;");
        locationLabel.setStyle("-fx-text-fill: white;");
        typeLabel.setStyle("-fx-text-fill: white;");
        
        attractionLabel.setWrapText(true);
        dateLabel.setWrapText(true);
        locationLabel.setWrapText(true);
        typeLabel.setWrapText(true);
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(attractionLabel, dateLabel, locationLabel, typeLabel);
        
        vbox.setSpacing(10);

        // Apply margins to the labels
        VBox.setMargin(attractionLabel, new Insets(20, 10, 0, 20));
        VBox.setMargin(dateLabel, new Insets(0, 10, 0, 20));
        VBox.setMargin(locationLabel, new Insets(0, 10, 0, 20));
        VBox.setMargin(typeLabel, new Insets(0, 10, 0, 20));
        
        // Clear existing children from contentBox
        contentBox.getChildren().clear();

        // Add the VBox to the contentBox
        contentBox.getChildren().add(vbox);

        // Bind the contentBox width to the modalScrollPane width
        contentBox.prefWidthProperty().bind(modalScrollPane.widthProperty());
        contentBox.minHeightProperty().bind(modalScrollPane.heightProperty());
    }
  
    public void setModalDetails(Festival festival) {
    	Label nameLabel = new Label("Event: " + festival.getName());
        Label dateLabel = new Label("Date: " + festival.getDate());
        Label locationLabel = new Label("Location: " + festival.getLocation());
        Label descriptionLabel = new Label("Description: " + festival.getDescription());
        
        nameLabel.setStyle("-fx-text-fill: white;");
        dateLabel.setStyle("-fx-text-fill: white;");
        locationLabel.setStyle("-fx-text-fill: white;");
        descriptionLabel.setStyle("-fx-text-fill: white;");

        // Set wrap text for all labels
        nameLabel.setWrapText(true);
        dateLabel.setWrapText(true);
        locationLabel.setWrapText(true);
        descriptionLabel.setWrapText(true);

        // Create a VBox to hold all the non-null labels
        VBox vbox = new VBox();
        vbox.getChildren().addAll(nameLabel, dateLabel, locationLabel, descriptionLabel);

        // Set the spacing between labels
        vbox.setSpacing(10);

        // Apply margins to the labels
        VBox.setMargin(nameLabel, new Insets(20, 10, 0, 20));
        VBox.setMargin(dateLabel, new Insets(0, 10, 0, 20));
        VBox.setMargin(locationLabel, new Insets(0, 10, 0, 20));
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
