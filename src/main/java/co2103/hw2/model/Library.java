package co2103.hw2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Library {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Generates IDs starting from '1' instead of doing 1-9 across all models
	private int id;
	private String name;
	private String city;
	
	@OneToMany(orphanRemoval = true, cascade = CascadeType.MERGE)
	//@JoinColumn(name = "id")
	private List<Item> items;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Patron> patrons;
	private String phoneNumber;
	
	public Library() {
		
	}
	
	public Library(String name, String city, String phoneNumber) {
		this.name = name;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}
	
	public Library(String name, String city, List<Item> items, List<Patron> patrons, String phoneNumber) {
		this.name = name;
		this.city = city;
		this.items = items;
		this.patrons = patrons;
		this.phoneNumber = phoneNumber;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int libCode) {
		this.id = libCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public List<Patron> getPatrons() {
		return patrons;
	}
	public void setPatrons(List<Patron> patrons) {
		this.patrons = patrons;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Library [id=" + id + ", name=" + name + ", city=" + city + ", phoneNumber=" + phoneNumber
				+ "]";
	}
	
	

	
}
