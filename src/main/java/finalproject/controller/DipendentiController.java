package finalproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import finalproject.entities.Dipendente;
import finalproject.repositories.CrudDipendente;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {

	@Autowired
	private CrudDipendente db;
	
	@GetMapping
	public Iterable<Dipendente> getAll() {
		return db.findAll();		
	}
	@GetMapping("/{id}")
	public Optional<Dipendente> get(@PathVariable int id) {
		return db.findById(id);
	}
	
	@PostMapping
	public void add(@RequestBody Dipendente d) {
		if (d.getId() == 0)
			db.save(d);
	}
	
	@DeleteMapping
	public void delete(@PathVariable int id) {
		db.deleteById(id);
	}
	
	@PutMapping
	public void update(@RequestBody Dipendente d) {
		if (db.findById(d.getId()).isPresent())
			db.save(d);
	}
}
