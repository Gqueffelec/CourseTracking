package courseTracking.sql.dao;

import java.util.Optional;

import courseTracking.model.Subject;

public interface ISubjectDao extends GenericDao<Subject, Integer, String, String> {
		Optional<Subject> findByName(String name);
}
