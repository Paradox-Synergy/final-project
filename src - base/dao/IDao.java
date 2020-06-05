package dao;

import java.util.List;

public interface IDao<T> {

	List<T> getAll();
	
	T getOne(int id);
	
	void add(T obj);
	
	void delete(int id);
	
	void update(T obj);
	
}
