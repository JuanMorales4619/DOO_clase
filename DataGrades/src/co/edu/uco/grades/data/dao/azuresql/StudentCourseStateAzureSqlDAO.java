package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;

import co.edu.grades.data.dao.StudentCourseStateDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.StudentCourseStateDTO;

public class StudentCourseStateAzureSqlDAO extends ConnectionSQL implements StudentCourseStateDAO {

	protected StudentCourseStateAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public static StudentCourseStateAzureSqlDAO build(Connection connection) {
		return new StudentCourseStateAzureSqlDAO(connection);
	}

	@Override
	public void create(StudentCourseStateDTO state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(StudentCourseStateDTO state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(StudentCourseStateDTO state) {
		// TODO Auto-generated method stub
		
	}
	

}
