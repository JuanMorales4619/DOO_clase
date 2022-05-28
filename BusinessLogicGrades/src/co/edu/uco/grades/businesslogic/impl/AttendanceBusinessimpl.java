package co.edu.uco.grades.businesslogic.impl;

import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.businesslogic.business.AttendanceBusiness;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.dto.AttendanceDTO;
import co.edu.uco.grdes.data.factory.DAOFactory;

public class AttendanceBusinessimpl implements AttendanceBusiness {
	
	private DAOFactory daoFactory;
	
	public AttendanceBusinessimpl() {
		if(UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicExeption("It's not possible create a AttendanceBusinessimpl when the DAOFactory is null");
		}
		
	}
	@Override
	public void create(AttendanceDTO attendance) {
		daoFactory.getAttendanceDAO().create(attendance);
		
	}

	@Override
	public void update(AttendanceDTO attendance) {
		daoFactory.getAttendanceDAO().update(attendance);
		
	}

	@Override
	public void delete(int id) {
		daoFactory.getAttendanceDAO().delete(id);
		
	}

	@Override
	public List<AttendanceDTO> find(AttendanceDTO attendance) {
		return daoFactory.getAttendanceDAO().find(attendance);
	}
	
}
