package co.edu.grades.data.dao;

import co.edu.uco.grades.dto.StudentCourseStateDTO;

public interface StudentCourseStateDAO {
	void create(StudentCourseStateDTO state);
	void update(StudentCourseStateDTO state);
	void delete(int id);
	void find(StudentCourseStateDTO state);

}
