package finalproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import finalproject.entities.CertificatoPersonale;
import finalproject.entities.keys.CompositeKey;

@Repository
public interface CertificatoPersonaleRepository extends CrudRepository<CertificatoPersonale, CompositeKey> {

}
