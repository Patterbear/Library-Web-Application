package co2103.hw2.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co2103.hw2.model.Item;
import co2103.hw2.model.Library;
import co2103.hw2.model.Patron;

public interface PatronRepository extends CrudRepository <Patron, Integer>{
	
	//No 'find' method for 'address' field as staff should NOT be using addresses to find patrons
	public List<Patron> findByName(String name);
	public List <Patron> findByEmail(String email);
	public List<Patron> findByLibraries(Library l);
	public Patron findById(int id);
	public Patron findByItem (Item item);
}
