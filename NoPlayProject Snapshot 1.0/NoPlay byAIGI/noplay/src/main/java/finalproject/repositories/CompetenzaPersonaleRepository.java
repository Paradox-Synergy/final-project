package finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import finalproject.entities.CompetenzaPersonale;
import finalproject.entities.keys.CompositeKey;

@Repository
public interface CompetenzaPersonaleRepository extends CrudRepository<CompetenzaPersonale, CompositeKey>{

	
}
