package co2103.hw2.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co2103.hw2.model.Item;
import co2103.hw2.model.Library;
import co2103.hw2.model.Patron;
import co2103.hw2.repo.ItemRepository;
import co2103.hw2.repo.LibraryRepository;
import co2103.hw2.repo.PatronRepository;

@Controller
public class DeleteController {
	
	@Autowired
	private LibraryRepository lrepo;
	@Autowired
	private ItemRepository irepo;
	@Autowired
	private PatronRepository prepo;
	
	
	
	
	@GetMapping("/deleteLibrary")
	public String newLibrary(Model model, @RequestParam int id) {
		//System.out.println(Integer.toString(id)); //WORKS
		//System.out.println(lrepo.findById((int)id)); // WORKING 7/12
		
		for(int i = 0; i < lrepo.findById(id).getPatrons().size(); i++) {
			lrepo.findById(id).getPatrons().get(i).setItem(null);
		}
		
		for(int i = 0; i < lrepo.findById(id).getItems().size(); i++) {
			//lrepo.findById(library).getItems().get(i).setBelongsTo(null);//working?
			//lrepo.findById(library).getItems().get(i).setRentedBy(null);
			//irepo.deleteById(lrepo.findById(library).getItems().get(i).getId());
			
			lrepo.findById(id).getItems().get(i).setBelongsTo(null);//ALL WORKING NOW 9/12
			lrepo.findById(id).getItems().get(i).setRentedBy(null);
		}
		
	

		lrepo.save(lrepo.findById(id));
		//lrepo.findById(id).setItems(null);
		
		lrepo.deleteById((int) id);//WORKING
		
		
		return "redirect:/list";
	}
	
	@GetMapping("/deletePatron")
	public String newPatron(Model model, @RequestParam int id) {
		
		ArrayList<Library> libs = (ArrayList<Library>) lrepo.findAll();
		//System.out.println(libs.get(1));
		
		for (int i = 0; i < libs.size(); i++) {
			Library lib = libs.get(i);
			List<Patron> lib_ps = lib.getPatrons();
			for(int j = 0; j < lib_ps.size(); j++) {
				if(lib_ps.get(j).getId() == id) {
					lib_ps.remove(lib_ps.get(j));
				}
			}
			lib.setPatrons(lib_ps);
		}
		
		
		if (prepo.findById(id).getItem() != null) {
			irepo.findByRentedBy(prepo.findById(id)).setRentedBy(null);
		}
		
		
		
		prepo.deleteById(((int) id));
		
		
		return "redirect:/list";
	}
	
	@GetMapping("/deleteItem")
	public String newItem(Model model, @RequestParam int id) {
		
		//System.out.println(irepo.findById(item));
		
		//System.out.println(irepo.findById(item).getRentedBy());
		
		
		if (irepo.findById(id).getRentedBy() != null) {
			prepo.findByItem(irepo.findById(id)).setItem(null);
		}
		//System.out.println("Checkpoint 1");
		
		irepo.findById(id).setBelongsTo(null);
		irepo.findById(id).setRentedBy(null);
		
		irepo.save(irepo.findById(id));
		//System.out.println("Checkpoint 2");
		
		ArrayList<Library> libs = (ArrayList<Library>) lrepo.findAll();
		for (int i = 0; i < libs.size(); i++) {
			Library lib = libs.get(i);
			List<Item> lib_is = lib.getItems();
			for(int j = 0; j < lib_is.size(); j++) {
				if(lib_is.get(j).getId() == id) {
					lib_is.remove(lib_is.get(j));
				}
			}
			lib.setItems(lib_is);
		}
		
		//System.out.println("Checkpoint 3");

		
		
		irepo.deleteById(id);
		
		//System.out.println("Checkpoint 4");
		
		
		
		
		return "redirect:/list";
	}
	
	
	

}
