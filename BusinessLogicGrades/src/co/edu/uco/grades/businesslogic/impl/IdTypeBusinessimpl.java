package co.edu.uco.grades.businesslogic.impl;

import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import co.edu.uco.grades.businesslogic.business.IdTypeBusiness;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.dto.IdTypeDTO;
import co.edu.uco.grades.dto.ProfessorDTO;
import co.edu.uco.grades.dto.StudentDTO;
import co.edu.uco.grdes.data.factory.DAOFactory;

public class IdTypeBusinessimpl implements IdTypeBusiness {
	
	private DAOFactory daoFactory;
	
	public IdTypeBusinessimpl(DAOFactory daoFactory) {
		if(UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicExeption("It's not possible create a IdTypeBusinessimpl when the DAOFactory is null");
		}
		this.daoFactory = daoFactory;
	}

	@Override
	public void create(IdTypeDTO dto) {
		
		validateIfIdTypeDoesNotExceistWhitSameName(dto);
		daoFactory.getIdTypeDAO().create(dto);
		
	}
	
	private void validateIfIdTypeDoesNotExceistWhitSameName(IdTypeDTO dto) {
		IdTypeDTO dtoValidator = new IdTypeDTO();
		dtoValidator.setName(dto.getName());
		List<IdTypeDTO> list = daoFactory.getIdTypeDAO().find(dtoValidator);
		if(!list.isEmpty()) {
			var message ="An id Type whit the same name arlredy exists";
			throw GradesException.buildTBusinessLogicExeption(message);
				
			}
			
	}
	

	@Override
	public void update(IdTypeDTO dto) {
		//validateIfIdTypeDoesNotExceistWhitSameName(dto);
		daoFactory.getIdTypeDAO().update(dto);
	}

	@Override
	public void delete(int id) {
		//IdTypeExists(id);
		//ValidateIfIdTypeIsInUse(id);
		daoFactory.getIdTypeDAO().delete(id);
		
	}
	
	private void IdTypeExists(int id) {
		IdTypeDTO dto = new IdTypeDTO(id," ");
		List<IdTypeDTO> list = daoFactory.getIdTypeDAO().find(dto);
		if(list.isEmpty()) {
			var message ="the id type you are trying to modify does't exist";
			throw GradesException.buildTBusinessLogicExeption(message);
		}
		
	}
	private void ValidateIfIdTypeIsInUse( int id) {
		
		StudentDTO dtoValidatorStudent = new StudentDTO();
		dtoValidatorStudent.setIdType(new  IdTypeDTO(id,UtilText.EMPTY));
		List<StudentDTO> students = daoFactory.getStudentDAO().find(dtoValidatorStudent);
		
		ProfessorDTO dtoValidatorProffessor = new ProfessorDTO();
		dtoValidatorProffessor.setIdType(new  IdTypeDTO(id,UtilText.EMPTY));
		List<ProfessorDTO> Proffessor = daoFactory.getProfessorDAO().find(dtoValidatorProffessor);
		
		if(!students.isEmpty() || !Proffessor.isEmpty()) {
			var message ="it's impossible to delete a id type in use";
			throw GradesException.buildTBusinessLogicExeption(message);
		}
	}

	@Override
	public List<IdTypeDTO> find(IdTypeDTO dto) {
		return daoFactory.getIdTypeDAO().find(dto);
	}

}
