package hust.soict.oop.scraper.location;
import java.util.*;

public class Location {
    private String name;
    private String date;
    private String location;
    private String type;

    public Location() {
    	
    }

    // Getters and Setters for the attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setLocation(String location) {
        this.location = location;
    }

}