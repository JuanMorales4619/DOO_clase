package co.edu.uco.grdes.data.factory.azuresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.grades.data.dao.IdTypeDAO;
import co.edu.grades.data.dao.StudentDAO;
import co.edu.uco.corsscuting.util.sql.UtilConnection;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.crosscuting.exeption.enumeration.ExceptionLocation;
import co.edu.uco.grades.data.dao.azuresql.IdTypeAzureSqlDAO;
import co.edu.uco.grades.data.dao.azuresql.StudentAzureSqlDAO;
import co.edu.uco.grdes.data.factory.DAOFactory;

public class AzuresqlDAOFactory extends DAOFactory {

	private Connection connection;

	private AzuresqlDAOFactory() {
		openConnection();
	}
	public static AzuresqlDAOFactory create() {
		return  new AzuresqlDAOFactory();
	}

	@Override
	protected void openConnection() {
		
		String stringConnection = "jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser;password=4c4d3m1cDmlUs3r;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		try {
			connection = DriverManager.getConnection(stringConnection);
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalExeption(
					"There was a problem trying to get the connection whit sql server jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser;",
					exception, ExceptionLocation.DATA);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalExeption(
					"An unexpected problem has ocurred trying to get the connection whit sql server jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser;",
					exception, ExceptionLocation.DATA);

		}
	}


	@Override
	public Connection getConection() {
		return connection;

	}

	@Override
	public StudentDAO getStudentDAO(){
		return StudentAzureSqlDAO.build(getConection());
	}

	@Override
	public void commitTransaction() {
		if (UtilConnection.isClosed(connection)) {
			throw GradesException.buildTechnicalExeption(
					"it's not possible to commit the transaction because it's closed");
		}
		try {
			if (getConection().getAutoCommit()) {
				throw GradesException.buildTechnicalExeption(
						"it's not possible to commit the transaction because data base is managin the trnasaction");
				}
		
			
			getConection().commit();
		} catch(GradesException exception) { throw exception;}
		
		catch (SQLException exception) {
			throw GradesException.buildTechnicalExeption(
					"There was a problem trying to commit whit sql server jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser;",
					exception, ExceptionLocation.DATA);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalExeption(
					"An unexpected problem has ocurred trying to commit whit sql server jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser;",
					exception, ExceptionLocation.DATA);
		}

	}

	@Override
	public void rollbackTransaction() {
		if (UtilConnection.isClosed(connection)) {
			throw GradesException.buildTechnicalExeption(
					"it's not possible to rolback the transaction because it's closed");
		}
		try {
			if (getConection().getAutoCommit()) {
				throw GradesException.buildTechnicalExeption(
						"it's not possible to rollback the transaction because data base is managin the transaction");
				}
			
			
			
			getConection().rollback();
		} catch(GradesException exception) { throw exception;}
		
		catch (SQLException exception) {
			throw GradesException.buildTechnicalExeption(
					"There was a problem trying to do a rollback whit sql server jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser;",
					exception, ExceptionLocation.DATA);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalExeption(
					"An unexpected problem has ocurred trying to do a rollback whit sql server jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser;",
					exception, ExceptionLocation.DATA);

		}

	}



	@Override
	public void closeConection() {
		if (UtilConnection.isClosed(connection)) {
			throw GradesException.buildTechnicalExeption(
					"it's not possible close a connection because it's alredy closed or is null");
		}
		try {
			getConection().close();
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalExeption(
					"There was a problem trying to close the connection whit sql server jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser;",
					exception, ExceptionLocation.DATA);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalExeption(
					"An unexpected problem has ocurred trying to close the connection whit sql server jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser;",
					exception, ExceptionLocation.DATA);

		}

	}
	
	public void initTransaction() {
		if (UtilConnection.isClosed(connection)) {
			throw GradesException.buildTechnicalExeption(
					"it's not possible to init the transaction because it's closed");
		}
		try {
			if (!getConection().getAutoCommit()) {
				throw GradesException.buildTechnicalExeption(
						"it's not possible to init the transaction because it was already initiated");
				}
			
			
			getConection().setAutoCommit(false);
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalExeption(
					"There was a problem trying to init the transaction whit sql server jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser;",
					exception, ExceptionLocation.DATA);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalExeption(
					"An unexpected problem has ocurred trying to init the transaction whit sql server jdbc:sqlserver://academic-database-server.database.windows.net:1433;database=academic-db;user=academicDmlUser;",
					exception, ExceptionLocation.DATA);

		}

	}

	@Override
	public IdTypeDAO getIdTypeDAO() {
		return IdTypeAzureSqlDAO.build(getConection());
	}

	
}
