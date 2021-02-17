package courseTracking.model;

import java.time.LocalDate;

public class Subject {
	private enum SubjectState { TOTALLY_NEW,REVISION_NEEDED,DEEP_LEARN};
	private SubjectState state;
	private LocalDate dateOfCourse;
	
	
	public Subject(SubjectState state) {
		this.setState(state);
	}


	public SubjectState getState() {
		return state;
	}


	public void setState(SubjectState state) {
		this.state = state;
	}


	public LocalDate getDateOfCourse() {
		return dateOfCourse;
	}


	public void setDateOfCourse(LocalDate dateOfCourse) {
		this.dateOfCourse = dateOfCourse;
	}
	
	
}
