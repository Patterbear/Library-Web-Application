package co2103.hw2.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co2103.hw2.model.Item;
import co2103.hw2.model.Library;
import co2103.hw2.model.Patron;

public interface LibraryRepository extends CrudRepository<Library, Integer> {
	
	public List<Library> findByPatrons(Patron p);
	public Library findByItems(Item i);
	public List<Library> findByName(String name);
	public Library findById(int id);
	public List<Library> findByCity(String city);

}
