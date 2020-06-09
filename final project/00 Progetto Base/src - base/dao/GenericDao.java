package dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.IMappable;

public class GenericDao<T extends IMappable> extends BasicDao {

	private final String tableName;
	private final Class<T> type;
	private final String selectAll;
	private final String selectById;

	@SuppressWarnings("unchecked")
	public GenericDao(String dbAddress, String user, String password, String tableName) {
		super(dbAddress, user, password);
		this.tableName = tableName;
		// Un po' di magia nera per non chiedere la classe come parametro
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		selectAll = "SELECT * FROM " + this.tableName + ";";
		selectById = name("SELECT * FROM [TABLENAME] WHERE id = ?;");
	}

	private String name(String sql) {
		return sql.replace("[TABLENAME]", tableName);
	}
	
	public List<T> getAll() {
		List<T> ris = new ArrayList<>();

		List<Map<String, String>> maps = super.getAll(selectAll);

		for (Map<String, String> map : maps) {
			ris.add(IMappable.fromMap(type, map));
		}

		return ris;
	}

	public T getById(int id) {
		return IMappable.fromMap(type, super.getOne(selectById, id));
	}

}
