package finalproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.EntityResponse;

import finalproject.controller.generics.GenericCrudController;
import finalproject.entities.Dipendente;
import finalproject.repositories.DipendenteRepository;
import javassist.NotFoundException;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/dipendenti")
public class DipendentiController extends GenericCrudController<Dipendente, DipendenteRepository>{

//	@Autowired
//	private DipendenteRepository db;
//	
//	@GetMapping
//	public Iterable<Dipendente> getAll() {
//		return db.findAll();
//	}
//	@GetMapping("/{id}")
//	public Object get(@PathVariable int id) {
//		Optional<Dipendente> dipendente = db.findById(id);
//		
//		if (!dipendente.isPresent())
//			return "ERRORE: nessun dipendente trovato all'id: "+id;
//		
//		return dipendente.get();
//	}
//	
//	@PostMapping
//	public void add(@RequestBody Dipendente d) {
//		if (d.getId() == 0)
//			db.save(d);
//	}
//	
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable int id) {
//		db.deleteById(id);
//	}
//	
//	@PutMapping
//	public void update(@RequestBody Dipendente d) {
//		if (db.findById(d.getId()).isPresent())
//			db.save(d);
//	}
}
