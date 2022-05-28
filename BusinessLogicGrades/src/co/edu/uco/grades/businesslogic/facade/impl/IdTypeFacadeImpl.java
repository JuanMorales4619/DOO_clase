package co.edu.uco.grades.businesslogic.facade.impl;

import java.util.List;

import co.edu.uco.grades.businesslogic.business.IdTypeBusiness;
import co.edu.uco.grades.businesslogic.facade.IdTypeFacade;
import co.edu.uco.grades.businesslogic.impl.IdTypeBusinessimpl;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.dto.IdTypeDTO;
import co.edu.uco.grdes.data.factory.DAOFactory;

public class IdTypeFacadeImpl implements IdTypeFacade {

	@Override
	public void create(IdTypeDTO dto) {
		DAOFactory daoFactory = DAOFactory.getDaoFactory();
		try {

			daoFactory.initTransaction();
			// ejecutar el negocio
			IdTypeBusiness idTypeBusiness = new IdTypeBusinessimpl(daoFactory);
			idTypeBusiness.create(dto);
			daoFactory.commitTransaction();
		} catch (GradesException exception) {
			daoFactory.rollbackTransaction();
			throw exception;

		} catch (Exception exception) {
			// controlar excepcion
			daoFactory.rollbackTransaction();
			String var = "There was a problem  trying  to create the new IdType on create method in  IdTypeFacadeImpl";
			throw GradesException.buildTechnicalBusinessLogicExeption(var);
		}

		finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void update(IdTypeDTO dto) {
		DAOFactory daoFactory = DAOFactory.getDaoFactory();
		try {

			daoFactory.initTransaction();
			// ejecutar el negocio
			IdTypeBusiness idTypeBusiness = new IdTypeBusinessimpl(daoFactory);
			idTypeBusiness.update(dto);
			daoFactory.commitTransaction();
		} catch (GradesException exception) {
			daoFactory.rollbackTransaction();
			throw exception;

		} catch (Exception exception) {
			// controlar excepcion
			daoFactory.rollbackTransaction();
			String var = "There was a problem  trying  to create the new IdType on create method in  IdTypeFacadeImpl";
			throw GradesException.buildTechnicalBusinessLogicExeption(var);
		}

		finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void delete(int id) {
		DAOFactory daoFactory = DAOFactory.getDaoFactory();
		try {

			daoFactory.initTransaction();
			// ejecutar el negocio
			IdTypeBusiness idTypeBusiness = new IdTypeBusinessimpl(daoFactory);
			idTypeBusiness.delete(id);
			daoFactory.commitTransaction();
		} catch (GradesException exception) {
			daoFactory.rollbackTransaction();
			throw exception;

		} catch (Exception exception) {
			// controlar excepcion
			daoFactory.rollbackTransaction();
			String var = "There was a problem  trying  to create the new IdType on create method in  IdTypeFacadeImpl";
			throw GradesException.buildTechnicalBusinessLogicExeption(var);
		}

		finally {
			daoFactory.closeConection();
		}

	}

	@Override
	public List<IdTypeDTO> find(IdTypeDTO dto) {
		DAOFactory daoFactory = DAOFactory.getDaoFactory();
		try {

			daoFactory.initTransaction();
			IdTypeBusiness idTypeBusiness = new IdTypeBusinessimpl(daoFactory);
			return idTypeBusiness.find(dto);
		} catch (GradesException exception) {
			throw exception;

		} catch (Exception exception) {
			// controlar excepcion
			String var = "There was a problem  trying  to create the new IdType on create method in  IdTypeFacadeImpl";
			throw GradesException.buildTechnicalBusinessLogicExeption(var);
		}

		finally {
			daoFactory.closeConection();
		}
	}

}
