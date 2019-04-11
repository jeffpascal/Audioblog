package data;

public class AnuntInchiriere implements Comparable<AnuntInchiriere> {
	private String title;
	private double price;
	private int rooms;
	private double area;
	private String floor;
	private String comandat;
	private String link;
	private double priceByMeter;
	private String location;

	public AnuntInchiriere(String title, double price, int rooms, double area, String floor, String link,String location) {
		super();
		this.title = title;
		this.price = price;
		this.rooms = rooms;
		this.area = area;
		this.floor = floor;
		this.link = link;
		this.priceByMeter = this.price / this.area;
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return String.format(
				"Anunt [price=%s ,area=%s,rooms=%s,priceByMeter=%.2f, location=%s	,title=%s,   floor=%s, comandat=%s, link=%s ]", price,
				area, rooms, priceByMeter, location,title, floor, comandat, link);
	}

	public double getPriceByMeter() {
		return priceByMeter;
	}

	public void setPriceByMeter(double priceByMeter) {
		this.priceByMeter = priceByMeter;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getComandat() {
		return comandat;
	}

	public void setComandat(String comandat) {
		this.comandat = comandat;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public int compareTo(AnuntInchiriere o) {
		return (int) (this.getArea() - o.getArea());
	}

}
