package co.edu.uco.grades.businesslogic.impl;

import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.businesslogic.business.SessionBusiness;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.dto.SessionDTO;
import co.edu.uco.grdes.data.factory.DAOFactory;

public class SessionBusinessimpl implements SessionBusiness {
	private DAOFactory daoFactory;

	public SessionBusinessimpl() {
		if(UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicExeption("It's not possible create a SessionBusinessimpl when the DAOFactory is null");
		}
		
	}

	@Override
	public void start(SessionDTO session) {
		daoFactory.getSessionDAO().start(session);
		
	}

	@Override
	public void update(SessionDTO session) {
		daoFactory.getSessionDAO().update(session);
		
	}

	@Override
	public List<SessionDTO> find(SessionDTO session) {
		return daoFactory.getSessionDAO().find(session);
	}
	
}
