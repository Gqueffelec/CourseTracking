package courseTracking.sql.dao;

import java.util.List;

public interface GenericDao<T,U,V,W> {
	T create(T o);
	boolean update(V field,W value, U id);
	boolean deleteById(U id);
	T getById(U id);
	List<T> getAll();

}
