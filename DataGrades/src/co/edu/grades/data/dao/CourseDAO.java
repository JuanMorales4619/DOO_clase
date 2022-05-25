package co.edu.grades.data.dao;

import co.edu.uco.grades.dto.CourseDTO;

public interface CourseDAO {
	void open(CourseDTO course);
	void close(CourseDTO course);
	void update(CourseDTO course);
	void find(CourseDTO course);
}
