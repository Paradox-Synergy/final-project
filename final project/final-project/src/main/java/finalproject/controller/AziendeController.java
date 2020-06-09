package finalproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import finalproject.controller.generics.GenericCrudController;
import finalproject.entities.Azienda;
import finalproject.repositories.CrudAzienda;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/aziende")
public class AziendeController /*extends GenericCrudController<Azienda, CrudAzienda>*/ {

	@Autowired
	private CrudAzienda db;
	
	@GetMapping
	public Iterable<Azienda> getAll() {
		return db.findAll();		
	}
	@GetMapping("/{id}")
	public Optional<Azienda> get(@PathVariable int id) {
		return db.findById(id);
	}
	
	@PostMapping
	public void add(@RequestBody Azienda d) {
		if (d.getId() == 0)
			db.save(d);
	}
	
	@DeleteMapping
	public void delete(@PathVariable int id) {
		db.deleteById(id);
	}
	
	@PutMapping
	public void update(@RequestBody Azienda d) {
		if (db.findById(d.getId()).isPresent())
			db.save(d);
	}
}
