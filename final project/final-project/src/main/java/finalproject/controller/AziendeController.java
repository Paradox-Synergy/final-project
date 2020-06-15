package finalproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import finalproject.controller.generics.GenericCrudController;
import finalproject.entities.Azienda;
import finalproject.entities.Dipendente;
import finalproject.repositories.AziendaRepository;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/aziende")
public class AziendeController extends GenericCrudController<Azienda, AziendaRepository> {
//
//	@Autowired
//	private AziendaRepository db;
//	
//	@GetMapping
//	public Iterable<Azienda> getAll() {
//		return db.findAll();		
//	}
//	@GetMapping("/{id}")
//	public Object get(@PathVariable int id) {
//		Optional<Azienda> azienda = db.findById(id);
//		
//		if (!azienda.isPresent())
//			return "ERRORE: nessuna azienda trovata all'id: "+id;
//		
//		return azienda.get();
//	}
//	
//	@PostMapping
//	public void add(@RequestBody Azienda d) {
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
//	public void update(@RequestBody Azienda d) {
//		if (db.findById(d.getId()).isPresent())
//			db.save(d);
//	}
}
