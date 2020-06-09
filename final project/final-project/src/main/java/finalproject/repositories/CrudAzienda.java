package finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import finalproject.entities.Azienda;

@Repository
public interface CrudAzienda extends CrudRepository<Azienda, Integer> {

	
}
