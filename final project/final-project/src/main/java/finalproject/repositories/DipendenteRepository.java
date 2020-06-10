package finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import finalproject.entities.Dipendente;

@Repository
public interface DipendenteRepository extends CrudRepository<Dipendente, Integer> {

}
