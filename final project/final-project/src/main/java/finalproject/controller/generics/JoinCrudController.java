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

import finalproject.entities.keys.CompositeKey;
import finalproject.entities.superclasses.JPAEntity;
import finalproject.entities.superclasses.JoinEntity;

/**
 * 
 * @author Paradox
 *
 * @param <T> La classe che estende la JoinEntity di cui si deve operare il controllo
 * @param <I> l'interfaccia creata per quella entity, estensione di CrudRepository<Entity, Integer>
 */

@MappedSuperclass
public abstract class JoinCrudController<T extends JoinEntity, I extends CrudRepository<T, CompositeKey>> {

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
	@GetMapping("/{id1}-{id2}")
	public Object get(@PathVariable int id1, @PathVariable int id2) {
		CompositeKey id = new CompositeKey(id1, id2);
		Optional<T> obj = db.findById(id);
		
		if (obj.isPresent())
			return obj.get();
		
		return idNotFound(id);
	}
	
	@PostMapping
	public String add(@RequestBody T obj) {
		CompositeKey id = obj.getId();
		if (id == null || id.getId1() == 0 || id.getId2() == 0) {
			db.save(obj);
			return jsonMessage("Added new "+tName);
		}
		return jsonError("Id must be null");
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id1, @PathVariable int id2) {
		CompositeKey id = new CompositeKey(id1, id2);
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
	
	private String executed(String action, CompositeKey id) {
		return jsonMessage("Element at composite id:"+id.getCompositeId().toString()+action);
	}
	private String idNotFound(CompositeKey id) {
		return jsonError("no "+tName+" found at composite id: "+id.getCompositeId());
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
