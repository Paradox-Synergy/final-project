package dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entities.Entity;
import util.IMappable;

@SuppressWarnings("unchecked")
public class GenericMySqlDao<T extends Entity> extends BasicDao{
	
	private final String tableName;
	private final Class<T> type;
	private final Field[] fields;
	
	private final String selectAll;
	private final String selectById;
	private final String insert;
	private final String update;
	private final String deleteById;

	public GenericMySqlDao(String dbAddress, String user, String password,
			String tableName) {
		super(dbAddress, user, password);
		this.tableName = tableName;
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
		this.fields = this.type.getDeclaredFields();
		
		this.selectAll = "SELECT * FROM " + this.tableName + ";";
		this.selectById = "SELECT * FROM " + this.tableName + " WHERE id=?;";
		this.insert = "INSERT INTO " + this.tableName + " VALUES " + sqlValues() + ";";
		this.deleteById = "DELETE FROM " +  this.tableName + " WHERE id=?;";
		this.update = "UPDATE " + this.tableName + " SET " + sqlSet() + " WHERE id=?;";
	}
	
	/** 
	 * @return "(null, ?, ?, ..., ?);"
	 */
	private String sqlValues() {
		String values = "null";
		for (int i = 0; i < fields.length; i++) {
			values += ", ?";
		}
		return "("+values+")";
	}
	/**
	 * @return "val1=?, val2=?, ..., valn=?"
	 */
	private String sqlSet() {
		String set = "";
		for (Field f : fields) {
			set = ", "+f+"='?'";
		}
		return set;
	}

	public List<T> selectAll() {
		List<T> list = new ArrayList<T>();
		
		List<Map<String, String>> maps = getAll(selectAll);
		for (Map<String, String> map : maps) {
			T obj = IMappable.fromMap(type, map);
			list.add(obj);
		}
		
		return list;
	}
	
	public T selectOne(int id) {
		return (T) IMappable.fromMap(type, getOne(selectById, id));
	}
	
	public void add(T obj) {		
		Map<String, String> objMap = obj.toMap();
		List<String> valueSet = new ArrayList<String>();
		
		for (Field f : fields) {
			valueSet.add(objMap.get(f.getName()));
		}
		execute(insert, valueSet);		
	}
	
	public void update(T obj) {
		
		List<Object> params = new ArrayList<Object>();
		for (Field f : fields) {
			f.setAccessible(true);
			try {
				params.add(f.get(obj));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				params.add("null");
				e.printStackTrace();
			}	
		}
		execute(update, params, obj.getId());
		
	}

	public void delete(int id) {
		execute(deleteById, id);
	}
}
