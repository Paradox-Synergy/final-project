package finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import finalproject.entities.Competenza;

@Repository
public interface CompetenzaRepository extends CrudRepository<Competenza, Integer> {

	
}
