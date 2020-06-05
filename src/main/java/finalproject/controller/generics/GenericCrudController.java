package finalproject.controller.generics;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entities.Entity;
import finalproject.repositories.generics.GenericCrud;

/**
 * 
 * @author leosc
 *
 * @param <T> La classe che estende Entity di cui si deve operare il controllo
 * @param <I> l'interfaccia creata per quella Entity
 */
@RestController
public abstract class GenericCrudController<T extends Entity, I extends GenericCrud<T>> {

	String directory;
	
	@Autowired
	private I db;
	
	@GetMapping
	public Iterable<T> getAll() {
		return db.findAll();		
	}
	@GetMapping("/{id}")
	public Optional<T> get(@PathVariable int id) {
		return db.findById(id);
	}
	
	@PostMapping
	public void add(@RequestBody T obj) {
		if (obj.getId() == 0)
			db.save(obj);
	}
	
	@DeleteMapping
	public void delete(@PathVariable int id) {
		db.deleteById(id);
	}
	
	@PutMapping
	public void update(@RequestBody T obj) {
		if (db.findById(obj.getId()).isPresent())
			db.save(obj);
	}
}
