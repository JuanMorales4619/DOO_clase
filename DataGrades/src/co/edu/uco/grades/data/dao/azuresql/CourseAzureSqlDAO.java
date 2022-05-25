package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.grades.data.dao.CourseDAO;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.CourseDTO;

public class CourseAzureSqlDAO extends ConnectionSQL implements CourseDAO{

	protected CourseAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public static CourseAzureSqlDAO build(Connection connection) {
		return new CourseAzureSqlDAO(connection);
	}

	@Override
	public void open(CourseDTO course) {
		String sql = "INSERT INTO Course(subject, professor,initialDate,finalDate) VALUES (?,?,?,?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setObject(1, course.getSubject());
			preparedStatement.setObject(1, course.getProfesor());
			preparedStatement.setDate(1, course.getInitialDate());
			preparedStatement.setDate(1, course.getFinalDate());
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
	public void close(CourseDTO course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CourseDTO course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void find(CourseDTO course) {
		// TODO Auto-generated method stub
		
	}

}
