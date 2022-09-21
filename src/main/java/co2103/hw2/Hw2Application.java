package co2103.hw2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co2103.hw2.model.Item;
import co2103.hw2.model.Library;
import co2103.hw2.model.Patron;
import co2103.hw2.repo.ItemRepository;
import co2103.hw2.repo.LibraryRepository;
import co2103.hw2.repo.PatronRepository;

@SpringBootApplication
public class Hw2Application implements ApplicationRunner {
	
	@Autowired
	private LibraryRepository lrepo;
	@Autowired
	private ItemRepository irepo;
	@Autowired
	private PatronRepository prepo;

	public static void main(String[] args) {
		
		SpringApplication.run(Hw2Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		Patron p1 = new Patron("Benjamin McGregor", "bwtfm1@student.le.ac.uk", "1 Spring Road");
		Patron p2 = new Patron("William Strover", "ws@example.co.uk", "76 Patriot Avenue");
		Patron p3 = new Patron("Luke Yaxley", "ly@kermit.org", "82 Tomfoolery Lane");
		
		prepo.save(p1);
		prepo.save(p2);
		prepo.save(p3);
		
		Item i1 = new Item("The Caves of Steel", 1954, "Book", "Isaac Asimov", "Science-Fiction, Mystery","A detective story that illustrates an idea Asimov advocated, that science fiction can be applied to any literary genre, rather than just being a limited genre in itself.");
		Item i2 = new Item("The Machine Stops", 1909, "Book", "E. M. Forster", "Science-Fiction", "A story set in a world where humanity lives underground and relies on a giant machine to provide its needs, predicted technologies similar to instant messaging and the Internet.");
		Item i3 = new Item("2001: A Space Odyssey", 1968, "DVD", "Stanley Kubrick", "Science-Fiction", "A Science fiction film produced and directed by Stanley Kubrick. The screenplay was written by Kubrick and Arthur C. Clarke, and was inspired by Clarke's 1951 short story \"The Sentinel\" and other short stories by Clarke.");
		Item i4 = new Item("Gunfight at the O.K. Corral", 1957, "DVD", "John Sturges", "Western", "An unlikely pact between a deputy federal marshal and an outlaw leads up to one of the most famous gunfights in the old west.");
		
		
		irepo.save(i1);
		irepo.save(i2);
		irepo.save(i3);
		irepo.save(i4);
		
		Library l1 = new Library("Salisbury Library", "Salisbury", List.of(i2), List.of(p1, p2), "01234567890");
		Library l2 = new Library("Sheffield Library", "Sheffield", List.of(i1, i3), List.of(p2), "09876543210");
		Library l3 = new Library("Burton Latimer Library", "Burton Latimer", List.of(i4), List.of(p1, p3), "01234598760");
		
		lrepo.save(l1);
		lrepo.save(l2);
		lrepo.save(l3);
		
		p1.setLibraries(List.of(l1, l3));
		p2.setLibraries(List.of(l1, l2));
		p3.setLibraries(List.of(l2, l3));
		
		prepo.save(p1);
		prepo.save(p2);
		prepo.save(p3);
		
		i1.setBelongsTo(l2);
		i2.setBelongsTo(l1);
		i1.setRentedBy(p2);
		i2.setRentedBy(p1);
		i3.setBelongsTo(l2);
		i4.setBelongsTo(l3);
		i4.setRentedBy(p3);
		
		irepo.save(i1);
		irepo.save(i2);
		irepo.save(i3);
		irepo.save(i4);
		
		p1.setItem(i2);
		p2.setItem(i1);
		p3.setItem(i4);
		
		prepo.save(p1);
		prepo.save(p2);
		prepo.save(p3);
		
		
		//Library Repo findBy tests (ALL WORKING)
		/*
		System.out.println(lrepo.findByCity("Salisbury"));
		System.out.println(lrepo.findByItems(i1));
		System.out.println(lrepo.findByLibCode(6));
		System.out.println(lrepo.findByName("Test Library"));
		System.out.println(lrepo.findByPatrons(p2));
		*/
		
		
		//Patron Repo findBy tests (ALL WORKING)
		/*
		System.out.println(prepo.findByItem(i1));
		System.out.println(prepo.findByEmail("bwtfm1@student.le.ac.uk"));
		System.out.println(prepo.findByItem(i2));
		System.out.println(prepo.findByLibraries(l1));
		System.out.println(prepo.findByName("William Strover"));
		*/
		
		
		//Item Repo findBy tests (ALL WORKING)
		/*
		System.out.println(irepo.findByBelongsTo(l1));
		System.out.println(irepo.findByAuthor("Isaac Asimov"));
		System.out.println(irepo.findByGenreContains("Science-Fiction"));
		System.out.println(irepo.findByRentedBy(p1));
		System.out.println(irepo.findByTitleContains("the"));
		System.out.println(irepo.findByYear(1954));
		System.out.println(irepo.findById(3));
		*/
		
		
		
	}

}
