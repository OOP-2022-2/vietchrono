package hust.soict.oop.scraper.figure;

import java.util.ArrayList;
import java.util.List;

import hust.soict.oop.scraper.dynasty.Dynasty;
import hust.soict.oop.scraper.event.Event;
import hust.soict.oop.scraper.location.Location;

public class Figure {

	public String name;
	public String otherName;
	public String time;
	public String place;
	public String period;
	public String description;
	
	private List<Event> relatedEvents = new ArrayList<>();
	private List<Location> relatedLocation = new ArrayList<>();
	private List<Figure> relatedFigures = new ArrayList<>();
	private List<Dynasty> relatedDynasty = new ArrayList<>();

	public List<Event> getRelatedEvents() {
		return relatedEvents;
	}

	public void setRelatedEvents(List<Event> relatedEvents) {
		this.relatedEvents = relatedEvents;
	}

	public List<Location> getRelatedLocation() {
		return relatedLocation;
	}

	public void setRelatedLocation(List<Location> relatedLocation) {
		this.relatedLocation = relatedLocation;
	}

	public List<Figure> getRelatedFigures() {
		return relatedFigures;
	}

	public void setRelatedFigures(List<Figure> relatedFigures) {
		this.relatedFigures = relatedFigures;
	}

	public List<Dynasty> getRelatedDynasty() {
		return relatedDynasty;
	}

	public void setRelatedDynasty(List<Dynasty> relatedDynasty) {
		this.relatedDynasty = relatedDynasty;
	}

	public Figure(String name, String time, String description, String place, String period, String otherName) {
		this.name = name;
		this.time = time;
		this.description = description;
		this.place = place;
		this.period = period;
		this.otherName = otherName;

	}

	public Figure() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

}
