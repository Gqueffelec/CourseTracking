package courseTracking.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import courseTracking.model.Subject;
import courseTracking.model.SubjectState;
import courseTracking.sql.dao.ISubjectDao;

public class SubjectDaoImpl implements ISubjectDao {
	Connection con;
	
	public SubjectDaoImpl() {
		con = SQLConnection.con;
	}
	
	@Override
	public Subject create(Subject subject) {
		try {
			PreparedStatement ps = con.prepareStatement(
					"insert into subject (name,description,state, dateLearned)values (?,?,?,?); ",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, subject.getName());
			ps.setString(2, subject.getDescription());
			ps.setString(3, subject.getState().name());
			ps.setDate(4, Date.valueOf(subject.getDateLearned()));
			ps.executeUpdate();
			ResultSet resultat = ps.getGeneratedKeys();
			if (resultat.next()) {
				subject.setId(resultat.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subject;
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
		List<Subject> allData = new LinkedList<Subject>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from subject");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				SubjectState state = null;
				switch (rs.getString("state")) {
				case "TOTALLY_NEW":
					state = SubjectState.TOTALLY_NEW;
					break;
				case "REVISION_NEEDED":
					state = SubjectState.REVISION_NEEDED;
					break;
				case "DEEP_LEARN":
					state = SubjectState.DEEP_LEARN;
					break;
				}
				allData.add(
						new Subject().setId(rs.getInt("id")).setName(rs.getString("name")).setDescription(rs.getString("description"))
								.setState(state).setDateLearned(rs.getDate("dateLearned").toLocalDate()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allData;
	}

	@Override
	public Optional<Subject> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
