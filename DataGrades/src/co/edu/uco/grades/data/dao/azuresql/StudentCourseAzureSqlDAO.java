package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;

import co.edu.grades.data.dao.StudentCourseDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.StudentCourseDTO;

public class StudentCourseAzureSqlDAO extends ConnectionSQL implements StudentCourseDAO {

	protected StudentCourseAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public static StudentCourseAzureSqlDAO build(Connection connection) {
		return  new StudentCourseAzureSqlDAO(connection);
	}

	@Override
	public void create(StudentCourseDTO studentCourse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(StudentCourseDTO studentCourse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(StudentCourseDTO studentCourse) {
		// TODO Auto-generated method stub
		
	}

}
