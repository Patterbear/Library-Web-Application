package co2103.hw2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co2103.hw2.repo.ItemRepository;
import co2103.hw2.repo.LibraryRepository;
import co2103.hw2.repo.PatronRepository;

@Controller
public class ListController {
	
	@Autowired
	private LibraryRepository lrepo;
	@Autowired
	private ItemRepository irepo;
	@Autowired
	private PatronRepository prepo;
	
	
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listObjects(Model model) {
		model.addAttribute("libraries", lrepo.findAll());
		model.addAttribute("patrons", prepo.findAll());
		model.addAttribute("items", irepo.findAll());
		return "list";
	}

}
