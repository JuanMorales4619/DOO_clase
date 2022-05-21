package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.grades.data.dao.IdTypeDAO;
import co.edu.uco.crosscutting.util.numeric.UtilNumeric;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.IdTypeDTO;

public class IdTypeAzureSqlDAO extends ConnectionSQL implements IdTypeDAO {

	protected IdTypeAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<IdTypeDTO> find(IdTypeDTO idType) {

		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		List<IdTypeDTO> results = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		sb.append("SELEC id, name").append(UtilText.SPACE);
		sb.append("FROM IdType").append(UtilText.SPACE);
		if (!UtilObject.getUtilObject().isNull(idType)) {
			if (UtilNumeric.getUtilObject().isGreatherThan(idType.getId(), 0)) {
				sb.append("WHERE").append(UtilText.SPACE);
				sb.append("id = ? ");
				parameters.add(idType.getName());
				setWhere = false;
			}
			if (!UtilText.isEmpty(idType.getName())) {
				sb.append(setWhere ? "WHERE " : "AND");
				sb.append("name = ? ");
				parameters.add(UtilText.trim(idType.getName()));
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
			throw GradesException.buildTechnicalDataExeption(
					"There was a problem trying to recover the IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to recover the IdType on Azure SQL Server", exception);
		}

		return results;

	}

	private List<IdTypeDTO> assembleResults(ResultSet resultSet) {
		List<IdTypeDTO> results = new ArrayList<>();

		try {
			while (resultSet.next()) {
				results.add(assembleDTO(resultSet));
			}

		} catch (GradesException exception) {
			throw exception;
		}

		catch (SQLException exception) {
			throw GradesException.buildTechnicalDataExeption(
					"There was a problem trying to recover the IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to recover the IdType on Azure SQL Server", exception);
		}

		return results;
	}

	private IdTypeDTO assembleDTO(ResultSet resultSet) {
		IdTypeDTO dto = new IdTypeDTO();
		try {
			dto.setId(resultSet.getInt("id"));
			dto.setName(resultSet.getString("name"));

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataExeption(
					"There was a problem trying to assamble the IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to assamble the IdType on Azure SQL Server", exception);
		}

		return dto;
	}

	private List<IdTypeDTO> executeQuery(PreparedStatement preparedStatement) {
		List<IdTypeDTO> results = new ArrayList<>();

		try (ResultSet resultset = preparedStatement.executeQuery()) {
			results = assembleResults(resultset);

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataExeption(
					"There was a problem trying to delete the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataExeption(
					"An unexpected has ocurred problem trying to delete the new IdType on Azure SQL Server", exception);
		}
		return results;

	}

	@Override
	public void create(IdTypeDTO idTypeDAO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(IdTypeDTO idTypeDAO) {
		// TODO Auto-generated method stub

	}

}
