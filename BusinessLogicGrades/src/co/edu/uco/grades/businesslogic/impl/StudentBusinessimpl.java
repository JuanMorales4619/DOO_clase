package co.edu.uco.grades.businesslogic.impl;

import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.businesslogic.business.StudentBusiness;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.dto.StudentDTO;
import co.edu.uco.grdes.data.factory.DAOFactory;

public class StudentBusinessimpl implements StudentBusiness {
	private DAOFactory daoFactory;
	public StudentBusinessimpl() {
		if(UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicExeption("It's not possible create a StudentBusinessimpl when the DAOFactory is null");
		}
		
	}
	@Override
	public void create(StudentDTO student) {
		daoFactory.getStudentDAO().create(student);
		
	}
	@Override
	public void update(StudentDTO student) {
		daoFactory.getStudentDAO().update(student);
		
	}
	@Override
	public void delete(int id) {
		daoFactory.getStudentDAO().delete(id);
		
	}
	@Override
	public List<StudentDTO> find(StudentDTO student) {
		return daoFactory.getStudentDAO().find(student);
	}
	
	
}
