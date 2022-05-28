package co.edu.uco.grades.businesslogic.impl;

import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.businesslogic.business.StudentCourseBusiness;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.dto.StudentCourseDTO;
import co.edu.uco.grdes.data.factory.DAOFactory;

public class StudentCourseBusinessimpl implements StudentCourseBusiness {
	private DAOFactory daoFactory;
	public StudentCourseBusinessimpl() {
		if(UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicExeption("It's not possible create a StudentCourseBusinessimpl when the DAOFactory is null");
		}
		
	}
	@Override
	public void create(StudentCourseDTO studentCourse) {
		daoFactory.getStudentCourseDAO().create(studentCourse);
		
	}
	@Override
	public void update(StudentCourseDTO studentCourse) {
		daoFactory.getStudentCourseDAO().update(studentCourse);
		
	}
	@Override
	public void delete(int id) {
		daoFactory.getStudentCourseDAO().delete(id);
		
	}
	@Override
	public List<StudentCourseDTO> find(StudentCourseDTO studentCourse) {
		
		return daoFactory.getStudentCourseDAO().find(studentCourse);
	}
	
}
