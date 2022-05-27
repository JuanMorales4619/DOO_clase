package co.edu.uco.businesslogic.impl;

import java.util.List;

import co.edu.uco.businesslogic.business.CourseBusiness;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.dto.CourseDTO;
import co.edu.uco.grdes.data.factory.DAOFactory;

public class CourseBusinessimpl implements CourseBusiness {
	private DAOFactory daoFactory;

	public CourseBusinessimpl() {
		if(UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicExeption("It's not possible create a CourseBusinessimpl when the DAOFactory is null");
		}
		
	}

	@Override
	public void open(CourseDTO course) {
		daoFactory.getCourseDAO().open(course);

	}

	@Override
	public List<CourseDTO> find(CourseDTO course) {
		return daoFactory.getCourseDAO().find(course);
	}

}
