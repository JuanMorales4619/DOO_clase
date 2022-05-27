package co.edu.uco.businesslogic.impl;

import java.util.List;

import co.edu.uco.businesslogic.business.StudentCourseStateBusiness;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.dto.StudentCourseStateDTO;
import co.edu.uco.grdes.data.factory.DAOFactory;

public class StudentCourseStateBusinessimpl implements StudentCourseStateBusiness {
	private DAOFactory daoFactory;
	public StudentCourseStateBusinessimpl() {
		if(UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicExeption("It's not possible create a StudentBusinessimpl when the DAOFactory is null");
		}
		
	}
	@Override
	public void create(StudentCourseStateDTO state) {
		daoFactory.getStudentCourseStateDAO().create(state);
		
	}
	@Override
	public void update(StudentCourseStateDTO state) {
		daoFactory.getStudentCourseStateDAO().update(state);
		
	}
	@Override
	public void delete(int id) {
		daoFactory.getStudentCourseStateDAO().delete(id);
		
	}
	@Override
	public List<StudentCourseStateDTO> find(StudentCourseStateDTO state) {
		
		return daoFactory.getStudentCourseStateDAO().find(state);
	}
	

}
