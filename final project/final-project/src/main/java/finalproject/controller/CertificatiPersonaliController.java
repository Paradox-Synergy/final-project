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

import finalproject.controller.generics.JoinCrudController;
import finalproject.entities.CertificatoPersonale;
import finalproject.repositories.CertificatoPersonaleRepository;


@RestController
@RequestMapping({"certificati_personali"})
public class CertificatiPersonaliController extends JoinCrudController<CertificatoPersonale, CertificatoPersonaleRepository>{

//	private String className = "Certificato";
//
//	@Autowired
//	private CertificatoPersonaleRepository db;
//	
//	@GetMapping
//	public Iterable<CertificatoPersonale> getAll() {
//		return db.findAll();		
//	}
//	@GetMapping("/{id}")
//	public Object get(@PathVariable int id) {
//		Optional<CertificatoPersonale> obj = db.findById(id);
//		
//		if (obj.isPresent())
//			return obj.get();
//		
//		return idNotFound(id);
//	}
//	
//	@PostMapping
//	public String add(@RequestBody CertificatoPersonale cp) {
//		if (cp.getId() == null) {
//			db.save(cp);
//			return jsonMessage("Added new "+className);
//		}
//		return jsonError("Id must be null");
//	}
//	
//	@DeleteMapping("/{id}")
//	public String delete(@PathVariable int id) {
//		if (db.findById(id).isPresent()) {
//			db.deleteById(id);
//			return executed("deleted", id);
//		}
//		return idNotFound(id);
//	}
//	
//	@PutMapping
//	public String update(@RequestBody T obj) {
//		if (db.findById(obj.getId()).isPresent()) {
//			db.save(obj);
//			return executed("updated", obj.getId());
//		}
//		return idNotFound(obj.getId());
//	}
//	
//	private String executed(String action, int id) {
//		return jsonMessage("Element at id:"+id+" "+action);
//	}
//	private String idNotFound(int id) {
//		return jsonError("no "+className+" found at id: "+id);
//	}
//	public String jsonError(String error) {
//		return "{\n"
//				+ "\"error\": \""+error+"\"\n"
//				+"}";
//	}
//	public String jsonMessage(String msg) {
//		return "{\n"
//				+ "\"message\": \""+msg+"\"\n"
//				+"}";
//	}
}
