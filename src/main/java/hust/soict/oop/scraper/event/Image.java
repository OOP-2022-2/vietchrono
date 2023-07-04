package hust.soict.oop.scraper.event;

public class Image {
	
	private String imageUrl;
	private String caption;

	public Image() {
		super();
	}
	
	public Image(String imageUrl, String caption) {
		super();
		this.imageUrl = imageUrl;
		this.caption = caption;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
}