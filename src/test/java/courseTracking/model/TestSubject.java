package courseTracking.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSubject {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test_create_with_all_parameter() {
		Subject subject = new Subject("Angular", "Cours d'introduction à Angular", SubjectState.REVISION_NEEDED,
				LocalDate.now());
		assertNotNull(subject);
	}

	@Test
	void test_create_with_building_design_pattern(){
		LocalDate date = LocalDate.now();
		Subject subject = new Subject().setId(1).setName("Angular").setDescription("Cours d'initiation à Angular").setState(SubjectState.TOTALLY_NEW).setDateLearned(date);
		assertEquals(1, subject.getId());
		assertEquals(SubjectState.TOTALLY_NEW, subject.getState());
		assertEquals(date, subject.getDateLearned());
		assertEquals("Angular", subject.getName());
		assertEquals("Cours d'initiation à Angular", subject.getDescription());
	}
	
	@Test
	void test_create_each_Enum() {
		Subject subjectTest1 = new Subject().setState(SubjectState.TOTALLY_NEW);
		Subject subjectTest2 = new Subject().setState(SubjectState.REVISION_NEEDED);
		Subject subjectTest3 = new Subject().setState(SubjectState.DEEP_LEARN);
		assertEquals(SubjectState.TOTALLY_NEW, subjectTest1.getState());
		assertEquals(SubjectState.REVISION_NEEDED, subjectTest2.getState());
		assertEquals(SubjectState.DEEP_LEARN, subjectTest3.getState());
	}

}
