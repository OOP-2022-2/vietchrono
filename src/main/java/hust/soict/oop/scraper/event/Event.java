package hust.soict.oop.scraper.event;

import hust.soict.oop.scraper.figure.*;
import java.util.*;

public class Event {

	private String event;
	private String from;
	private String to;
	private String age;
	private String dynasty;
	private String description;
	private Image image;
	private String source;
	private List<Figure> relatedFigures = new ArrayList<>();
	private List<King> relatedKings = new ArrayList<>();

	public Event() {
		super();
	}

	public Event(String event, String from, String to, String source) {
		super();
		this.event = event;
		this.from = from;
		this.to = to;
		this.source = source;
	}

	public Event(String age, String dynasty, String event, String from, String to, String description, Image image,
			String source) {
		this(event, from, to, source);
		this.age = age;
		this.dynasty = dynasty;
		this.description = description;
		this.image = image;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDynasty() {
		return dynasty;
	}

	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String printDate() {
		if (to.equals("")) {
			return getFrom();
		}
		return getFrom() + " - " + getTo();
	}

	@Override
	public String toString() {
		return getTo() == "" ? age + "   " + dynasty + "   " + getEvent() + "   " + getFrom()
				: age + "   " + dynasty + "   " + getEvent() + "   " + getFrom() + " - " + getTo();
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
