package co.edu.uco.grdes.data.factory.azuresql;

import java.sql.Connection;

import co.edu.uco.corsscuting.util.sql.UtilConnection;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.dto.Student_DTO;
import co.edu.uco.grdes.data.factory.DAOFactory;

public class AzuresqlDAOFactory extends DAOFactory {
	
	private Connection connection;
	
	private AzureSqlDAOFactory() {
		openConnection();
	}

	@Override
	public Student_DTO getStudent_DTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void openConnection() {
		if(!UtilObject.getUtilObject().isNull(connection)
			&& !UtilConnection.isClosed(connection)){
				//podemos abrir una conexion
			
				throw GradesException.buildTechnicalExeption("it's not possible open a connection because it's alredy is open");
			}
		
	}

	@Override
	public void cleseConection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getConection() {
		// TODO Auto-generated method stub
		
	}
}
