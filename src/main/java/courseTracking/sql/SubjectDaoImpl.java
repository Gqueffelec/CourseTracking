package courseTracking.sql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import courseTracking.model.Subject;
import courseTracking.sql.dao.ISubjectDao;

public class SubjectDaoImpl implements ISubjectDao {

	@Override
	public Subject create(Subject subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(String field, String value, Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Subject getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subject> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Subject> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
