package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.grades.data.dao.IdTypeDTO;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;

public class IdTypeAzureSqlDAO extends ConnectionSQL implements IdTypeDAO {

	protected IdTypeAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public void create(IdTypeDTO idType) {
		String sql = "INSERT INTO IdType(name) VALUES(?)";

		try (PreparedStatement preparestatement = getConnection().preparestatement(sql)) {
			preparestatement.setString(1, idType.getName());
			preparestatement.executeUpdate();
		} catch (SQLException exeption) {
			throw GradesException.build("there was a problem trying to create the new IdType in SQL server", exeption);

		} catch (Exception exeption) {
			throw GradesException.build("an unexpected problem has ocurred trying to create the new IdType in SQL server", exeption);

		}

	}

}
