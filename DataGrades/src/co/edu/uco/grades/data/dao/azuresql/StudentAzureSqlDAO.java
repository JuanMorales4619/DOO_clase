package co.edu.uco.grades.data.dao.azuresql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.grades.data.dao.StudentDAO;
import co.edu.uco.crosscutting.util.numeric.UtilNumeric;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.StudentDTO;

public class StudentAzureSqlDAO extends ConnectionSQL implements StudentDAO{

	private StudentAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static StudentDAO build(Connection connection) {
		return new StudentAzureSqlDAO(connection);
	}

	@Override
	public void create(StudentDTO student) {
		String sql = "INSERT INTO Student(idNumber,idType,name,email) VALUES (?,?,?,?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, student.getIdNumber());
			preparedStatement.setInt(1, student.getIdType().getId());
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(1, student.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new Student on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new Student on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void update(StudentDTO student) {
		String sql = "UPDATE Student SET idNumber = ?, idType = ?, name = ?, email = ?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, student.getIdNumber());
			preparedStatement.setInt(1, student.getIdType().getId());
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(1, student.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new Student on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new Student on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Student WHERE id = ?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new Student on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new Student on Azure SQL Server", exception);
		}
		
	}

	@Override
	public List<StudentDTO> find(StudentDTO student) {
		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		List<StudentDTO> results = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		sb.append("SELEC id, name").append(UtilText.SPACE);
		sb.append("FROM IdType").append(UtilText.SPACE);
		if (!UtilObject.getUtilObject().isNull(student)) {
			if (UtilNumeric.getUtilObject().isGreatherThan(student.getId(), 0)) {
				sb.append("WHERE").append(UtilText.SPACE);
				sb.append("id = ? ");
				parameters.add(student.getName());
				setWhere = false;
			}
			if (!UtilText.isEmpty(student.getName())) {
				sb.append(setWhere ? "WHERE " : "AND");
				sb.append("name = ? ");
				parameters.add(UtilText.trim(student.getName()));
			}
		}

		sb.append("ORDER BY name ASC").append(UtilText.SPACE);
		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sb.toString())) {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
			results = executeQuery(preparedStatement);

		} catch (GradesException exception) {
			throw exception;
		}

		catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to recover the student on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to recover the student on Azure SQL Server", exception);
		}

		return results;
		
	}
	private List<StudentDTO> assembleResults(ResultSet resultSet) {
		List<StudentDTO> results = new ArrayList<>();

		try {
			while (resultSet.next()) {
				results.add(assembleDTO(resultSet));
			}

		} catch (GradesException exception) {
			throw exception;
		}

		catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to recover the student on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to recover the student on Azure SQL Server", exception);
		}

		return results;
	}

	private StudentDTO assembleDTO(ResultSet resultSet) {
		StudentDTO dto = new StudentDTO();
		try {
			dto.setId(resultSet.getInt("id"));
			dto.setName(resultSet.getString("name"));
			

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to assamble the student on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to assamble the student on Azure SQL Server", exception);
		}

		return dto;
	}

	private List<StudentDTO> executeQuery(PreparedStatement preparedStatement) {
		List<StudentDTO> results = new ArrayList<>();

		try (ResultSet resultset = preparedStatement.executeQuery()) {
			results = assembleResults(resultset);

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to delete the new student on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to delete the new student on Azure SQL Server", exception);
		}
		return results;

	}

	
}

