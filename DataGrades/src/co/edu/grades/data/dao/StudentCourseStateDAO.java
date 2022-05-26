package co.edu.grades.data.dao;

import java.util.List;

import co.edu.uco.grades.dto.StudentCourseStateDTO;

public interface StudentCourseStateDAO {
	void create(StudentCourseStateDTO state);
	void update(StudentCourseStateDTO state);
	void delete(int id);
	List<StudentCourseStateDTO> find(StudentCourseStateDTO state);

}
