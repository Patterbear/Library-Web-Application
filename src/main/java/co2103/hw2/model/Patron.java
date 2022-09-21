package co2103.hw2.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Patron {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Generates IDs starting from '1' instead of doing 1-9 across all models
	private int id;
	private String name;
	
	@ManyToMany(mappedBy = "patrons")
	private List<Library> libraries;
	private String email;
	private String address;
	
	@OneToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "id")
	private Item item;
	
	public Patron() {}
	
	public Patron(String name, String email, String address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Library> getLibraries() {
		return libraries;
	}
	public void setLibraries(List<Library> libraries) {
		this.libraries = libraries;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Patron [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", item=" + item
				+ "]";
	}


	
	
}
