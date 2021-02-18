
package courseTracking.model;

import java.time.LocalDate;

public class Subject {
	private int id;
	private String name;
	private String description;
	private SubjectState state;
	private LocalDate dateLearned;

	public Subject(String name, String description, SubjectState state, LocalDate dateLearned) {
		this.setName(name);
		this.setDescription(description);
		this.state = state;
		this.dateLearned = dateLearned;
	}

	public Subject() {
	}

	public SubjectState getState() {
		return state;
	}

	public Subject setState(SubjectState state) {
		this.state = state;
		return this;
	}

	public LocalDate getDateLearned() {
		return dateLearned;
	}

	public Subject setDateLearned(LocalDate dateLearned) {
		this.dateLearned = dateLearned;
		return this;
	}

	public String getName() {
		return name;
	}

	public Subject setName(String name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Subject setDescription(String description) {
		this.description = description;
		return this;
	}

	public int getId() {
		return id;
	}

	public Subject setId(int id) {
		this.id = id;
		return this;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", description=" + description + ", state=" + state
				+ ", dateLearned=" + dateLearned + "]";
	}

}
