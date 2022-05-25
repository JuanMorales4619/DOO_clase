package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.grades.data.dao.AttendanceDAO;
import co.edu.uco.crosscutting.util.numeric.UtilNumeric;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.AttendanceDTO;
import co.edu.uco.grades.dto.IdTypeDTO;

public class AttendanceAzureSqlDAO extends ConnectionSQL implements AttendanceDAO {

	protected AttendanceAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	
	public static AttendanceAzureSqlDAO build(Connection connection) {
		return new AttendanceAzureSqlDAO(connection);
	}
	
	@Override
	public void create(AttendanceDTO attendance) {
		String sql = "INSERT INTO Attendace(studentCourse,session,attended) VALUES (?,?,?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setObject(1, attendance.getStudenCourseDTO());
			preparedStatement.setObject(1, attendance.getSessionDTO());
			preparedStatement.setByte(1, attendance.getAttended());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void update(AttendanceDTO attendance) {
		String sql = "UPDATE IdType SET studentCourse = ? ,  session= ? , attended= ?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, attendance.getStudenCourseDTO().getId());
			preparedStatement.setInt(1, attendance.getSessionDTO().getId());
			preparedStatement.setByte(1, attendance.getAttended());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new Attendeance on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new Attendeance on Azure SQL Server", exception);
		}
		
	}

	@Override
	public List<AttendanceDTO> find(AttendanceDTO attendance) {

		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		List<AttendanceDTO> results = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		sb.append("SELEC id, studentCourse, session, attended").append(UtilText.SPACE);
		sb.append("FROM IdType").append(UtilText.SPACE);
		if (!UtilObject.getUtilObject().isNull(attendance)) {
			if (UtilNumeric.getUtilObject().isGreatherThan(attendance.getId(), 0)) {
				sb.append("WHERE").append(UtilText.SPACE);
				sb.append("id = ? ");
				parameters.add(attendance.getAttended());
				setWhere = false;
			}
			if () {
				sb.append(setWhere ? "WHERE " : "AND");
				sb.append("name = ? ");
				parameters.add(UtilText.trim(attendance.getAttended()));
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
					"There was a problem trying to recover the IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to recover the IdType on Azure SQL Server", exception);
		}

		return results;

	}

	private List<AttendanceDTO> assembleResults(ResultSet resultSet) {
		List<AttendanceDTO> results = new ArrayList<>();

		try {
			while (resultSet.next()) {
				results.add(assembleDTO(resultSet));
			}

		} catch (GradesException exception) {
			throw exception;
		}

		catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to recover the IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to recover the IdType on Azure SQL Server", exception);
		}

		return results;
	}

	private AttendanceDTO assembleDTO(ResultSet resultSet) {
		AttendanceDTO dto = new AttendanceDTO();
		try {
			dto.setId(resultSet.getInt("id"));

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to assamble the IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to assamble the IdType on Azure SQL Server", exception);
		}

		return dto;
	}

	private List<AttendanceDTO> executeQuery(PreparedStatement preparedStatement) {
		List<AttendanceDTO> results = new ArrayList<>();

		try (ResultSet resultset = preparedStatement.executeQuery()) {
			results = assembleResults(resultset);

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to delete the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to delete the new IdType on Azure SQL Server", exception);
		}
		return results;

	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
