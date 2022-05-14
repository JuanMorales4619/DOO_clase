package co.edu.uco.grades.data.dao.azuresql;
import java.sql.Connection;

import co.edu.grades.data.dao.StudentDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.Student_DTO;

public class StudentAzureSqlDAO extends ConnectionSQL implements StudentDAO{

	private StudentAzureSqlDAO(Connection connection) {
		super(connection);
		
	}
	
	public static StudentDAO build(Connection connection) {
		return new StudentAzureSqlDAO(connection);
	}

	@Override
	public void create(Student_DTO student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Student_DTO student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(Student_DTO student) {
		// TODO Auto-generated method stub
		
	}

	
}

