package finalproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finalproject.controller.generics.GenericCrudController;
import finalproject.entities.Utente;
import finalproject.entities.Utente;
import finalproject.repositories.CrudDipendente;
import finalproject.repositories.CrudUtente;

@RestController
@RequestMapping("/utenti")
public class UtentiController /*extends GenericCrudController<Utente, CrudUtente>*/ {

	@Autowired
	private CrudUtente db;
	
	@GetMapping
	public Iterable<Utente> getAll() {
		return db.findAll();		
	}
	@GetMapping("/{id}")
	public Optional<Utente> get(@PathVariable int id) {
		return db.findById(id);
	}
	
	@PostMapping
	public void add(@RequestBody Utente d) {
		if (d.getId() == 0)
			db.save(d);
	}
	
	@DeleteMapping
	public void delete(@PathVariable int id) {
		db.deleteById(id);
	}
	
	@PutMapping
	public void update(@RequestBody Utente d) {
		if (db.findById(d.getId()).isPresent())
			db.save(d);
	}
}
