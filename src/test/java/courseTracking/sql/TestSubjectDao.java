package courseTracking.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import courseTracking.model.Subject;
import courseTracking.model.SubjectState;

@ExtendWith(MockitoExtension.class)
class TestSubjectDao {

	@Mock
	Subject subject;
	SubjectDaoImpl dao = new SubjectDaoImpl();
	@Mock
	PreparedStatement stmt;
	@Mock
	ResultSet rs;
	@Mock
	Connection con;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		dao.con = con;
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test_insertion_to_database() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true);
		Mockito.when(rs.getInt(1)).thenReturn(1);
		Mockito.when(dao.con.prepareStatement(Mockito.anyString(), Mockito.anyInt())).thenReturn(stmt);
		Mockito.when(stmt.getGeneratedKeys()).thenReturn(rs);
		Subject test = dao.create(createTestSubject());
		Mockito.verify(dao.con).prepareStatement(Mockito.anyString(), Mockito.anyInt());
		Mockito.verify(stmt).getGeneratedKeys();
		Mockito.verify(rs, Mockito.times(1)).next();
		Mockito.verify(rs).getInt(1);
	}

	@Test
	void test_get_all_data() throws SQLException {
		Mockito.when(rs.next()).thenReturn(true).thenReturn(true).thenReturn(false);
		Mockito.when(rs.getInt("id")).thenReturn(1).thenReturn(2);
		Mockito.when(rs.getString("name")).thenReturn("Angular").thenReturn("React");
		Mockito.when(rs.getString("state")).thenReturn("REVISION_NEEDED").thenReturn("TOTALLY_NEW");
		Mockito.when(rs.getString("description")).thenReturn("Cours Angular").thenReturn("Cours React");
		LocalDate date = LocalDate.of(2021, 2, 8);
		LocalDate date2 = LocalDate.of(2021, 1, 8);
		Mockito.when(rs.getDate("dateLearned")).thenReturn(Date.valueOf(date2)).thenReturn(Date.valueOf(date));
		Mockito.when(dao.con.prepareStatement(Mockito.anyString())).thenReturn(stmt);
		Mockito.when(stmt.executeQuery()).thenReturn(rs);
		dao.getAll();
		Mockito.verify(dao.con).prepareStatement(Mockito.anyString());
		Mockito.verify(stmt, Mockito.times(1)).executeQuery();
		Mockito.verify(rs, Mockito.times(3)).next();
		Mockito.verify(rs, Mockito.times(2)).getInt("id");
		Mockito.verify(rs, Mockito.times(2)).getString("name");
		Mockito.verify(rs, Mockito.times(2)).getString("state");
		Mockito.verify(rs, Mockito.times(2)).getString("description");
		Mockito.verify(rs, Mockito.times(2)).getDate("dateLearned");
	}

	private Subject createTestSubject() {
		subject = new Subject().setId(1).setName("Angular").setDescription("Cours Angular")
				.setState(SubjectState.REVISION_NEEDED).setDateLearned(LocalDate.now());
		return subject;
	}

}
