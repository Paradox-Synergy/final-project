package finalproject.controller.generics;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import finalproject.entities.superclasses.JPAEntity;

/**
 * 
 * @author Paradox
 *
 * @param <T> La classe che estende la JPAEntity di cui si deve operare il controllo
 * @param <I> l'interfaccia creata per quella entity, estensione di CrudRepository<Entity, Integer>
 */

@MappedSuperclass
public abstract class GenericCrudController<T extends JPAEntity, I extends CrudRepository<T, Integer>> {

	String tName = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].toString();
	{
//		int beginIndex;
//		while ((beginIndex = tName.indexOf(".")) != -1) {
//			tName = tName.substring(beginIndex+1);
//		}		
		String[] split = tName.split("\\.");
		tName = split[split.length-1];
	}

	
	@Autowired
	private I db;
	
	@GetMapping
	public Iterable<T> getAll() {
		return db.findAll();		
	}
	@GetMapping("/{id}")
	public Object get(@PathVariable int id) {
		Optional<T> obj = db.findById(id);
		
		if (obj.isPresent())
			return obj.get();
		
		return idNotFound(id);
	}
	
	@PostMapping
	public String add(@RequestBody T obj) {
		if (obj.getId() == 0) {
			db.save(obj);
			return jsonMessage("Added new "+tName);
		}
		return jsonError("Id must be null");
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		if (db.findById(id).isPresent()) {
			db.deleteById(id);
			return executed("deleted", id);
		}
		return idNotFound(id);
	}
	
	@PutMapping
	public String update(@RequestBody T obj) {
		if (db.findById(obj.getId()).isPresent()) {
			db.save(obj);
			return executed("updated", obj.getId());
		}
		return idNotFound(obj.getId());
	}
	
	private String executed(String action, int id) {
		return jsonMessage("Element at id: "+id+" "+action);
	}
	private String idNotFound(int id) {
		return jsonError("no "+tName+" found at id: "+id);
	}
	public String jsonError(String error) {
		return "{\n"
				+ "\"error\": \""+error+"\"\n"
				+"}";
	}
	public String jsonMessage(String msg) {
		return "{\n"
				+ "\"message\": \""+msg+"\"\n"
				+"}";
	}
}
