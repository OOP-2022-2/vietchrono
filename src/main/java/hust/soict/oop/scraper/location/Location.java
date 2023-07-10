package hust.soict.oop.scraper.location;

import java.util.*;

import hust.soict.oop.scraper.figure.*;

public class Location {
	private String name;
	private String date;
	private String location;
	private String type;
	private List<Figure> relatedFigures = new ArrayList<>();
	private List<King> relatedKings = new ArrayList<>();

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

	public List<Figure> getRelatedFigures() {
		return relatedFigures;
	}

	public void setRelatedFigures(List<Figure> relatedFigures) {
		this.relatedFigures = relatedFigures;
	}

	public List<King> getRelatedKings() {
		return relatedKings;
	}

	public void setRelatedKings(List<King> relatedKings) {
		this.relatedKings = relatedKings;
	}

}