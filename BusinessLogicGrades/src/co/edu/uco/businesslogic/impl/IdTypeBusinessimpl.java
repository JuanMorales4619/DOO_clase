package co.edu.uco.businesslogic.impl;

import java.util.List;

import co.edu.uco.businesslogic.business.IdTypeBusiness;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.dto.IdTypeDTO;
import co.edu.uco.grdes.data.factory.DAOFactory;

public class IdTypeBusinessimpl implements IdTypeBusiness {
	
	private DAOFactory daoFactory;
	public IdTypeBusinessimpl() {
		if(UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicExeption("It's not possible create a IdTypeBusinessimpl when the DAOFactory is null");
		}
		this.daoFactory = daoFactory;
	}

	@Override
	public void create(IdTypeDTO dto) {
		daoFactory.getIdTypeDAO().create(dto);
		
	}

	@Override
	public void update(IdTypeDTO dto) {
		daoFactory.getIdTypeDAO().update(dto);
		
	}

	@Override
	public void delete(int id) {
		daoFactory.getIdTypeDAO().delete(id);
		
	}

	@Override
	public List<IdTypeDTO> find(IdTypeDTO dto) {
		return daoFactory.getIdTypeDAO().find(dto);
	}

}
