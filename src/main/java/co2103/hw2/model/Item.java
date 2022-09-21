package co2103.hw2.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Generates IDs starting from '1' instead of doing 1-9 across all models
	private int id;
	
	private String title;
	private int year;
	private String type;
	private String author;
	private String genre;
	private String description;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "items")
	private Library belongsTo;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "item")
	private Patron rentedBy;
	
	public Item() {
		
	}
	
	public Item(String title, int year, String type, String author, String genre, String description) {
		this.title = title;
		this.year = year;
		this.type = type;
		this.author = author;
		this.genre = genre;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Library getBelongsTo() {
		return belongsTo;
	}
	public void setBelongsTo(Library belongsTo) {
		this.belongsTo = belongsTo;
	}
	public Patron getRentedBy() {
		return rentedBy;
	}
	public void setRentedBy(Patron rentedBy) {
		this.rentedBy = rentedBy;
	}
	
	@Override
	public String toString() {
		/*
		String rb;
		if (rentedBy == null) {
			rb = "null";
		} else {
			rb = rentedBy.getName();
		}
		*/
		return "Item [id=" + id + ", title=" + title + ", year=" + year + ", type=" + type + ", author=" + author
				+ ", genre=" + genre + ", description=" + description + ", belongsTo=" + belongsTo/* + ", rentedBy=" + rb */+ "]"; //THIS WORKS 02/12/21 - Commented out 'rb' to adhere to worksheet (says delete attributes that cause loop)
	}
	
	
}
