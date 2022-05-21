package co.edu.grades.data.dao;

import co.edu.uco.grades.dto.StudentDTO;

public interface StudentDAO {
	void create(StudentDTO student);
	void update(StudentDTO student);
	void delete(int id);
	void find(StudentDTO student);
}
