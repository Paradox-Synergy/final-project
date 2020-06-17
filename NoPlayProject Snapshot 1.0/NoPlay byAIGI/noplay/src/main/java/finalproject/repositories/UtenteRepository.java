package finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import finalproject.entities.Utente;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Integer> {

	
}
