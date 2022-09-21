package co2103.hw2.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co2103.hw2.model.Item;
import co2103.hw2.model.Library;
import co2103.hw2.model.Patron;

public interface ItemRepository extends CrudRepository <Item, Integer>{
	
	public List<Item> findByTitleContains(String title);
	public List<Item> findByAuthor(String author);
	public List<Item> findByYear(int year);
	public List<Item> findByGenreContains(String genre); //Some items have multiple genres
	public Item findByRentedBy(Patron rentedBy);
	public Item findByBelongsTo(Library belongsTo);
	public Item findById(int id);
}
