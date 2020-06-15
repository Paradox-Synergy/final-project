package finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import finalproject.entities.Certificato;

@Repository
public interface CertificatoRepository extends CrudRepository<Certificato, Integer> {

	
}
