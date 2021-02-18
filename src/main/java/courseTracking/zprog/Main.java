package courseTracking.zprog;

import java.time.LocalDate;
import java.util.List;

import courseTracking.model.Subject;
import courseTracking.model.SubjectState;
import courseTracking.sql.SQLConnection;
import courseTracking.sql.SubjectDaoImpl;

public class Main {
	public static void main(String[] args) {
		SQLConnection.connect();
		SubjectDaoImpl dao = new SubjectDaoImpl();
		dao.create(new Subject("Angular","Cours introduction",SubjectState.TOTALLY_NEW,LocalDate.now()));
		List<Subject> list = dao.getAll();
		for (Subject subject : list) {
			System.out.println(subject);
		}
	}
	
}
