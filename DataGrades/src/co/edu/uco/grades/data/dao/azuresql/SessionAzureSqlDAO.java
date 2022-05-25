package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;

import co.edu.grades.data.dao.SessionDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.SessionDTO;

public class SessionAzureSqlDAO extends ConnectionSQL implements SessionDAO {

	protected SessionAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public static SessionAzureSqlDAO build(Connection connection) {
		return new SessionAzureSqlDAO(connection);
	}

	@Override
	public void open(SessionDTO session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close(SessionDTO session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(SessionDTO session) {
		// TODO Auto-generated method stub
		
	}

}
