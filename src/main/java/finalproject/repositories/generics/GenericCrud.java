package finalproject.repositories.generics;

import org.springframework.data.repository.CrudRepository;

public interface GenericCrud<T> extends CrudRepository<T, Integer>{

}
