package co.edu.uco.grades.api.controller.validator.idtype;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.api.controller.validator.Validator;
import co.edu.uco.grades.dto.IdTypeDTO;

public class CreateIdTypeValidator implements Validator<IdTypeDTO> {
	
	private List<String> validationMessage = new ArrayList<>();
	
	@Override
	public List<String> validate(IdTypeDTO dto) {
		if(UtilObject.getUtilObject().isNull(dto)) {
			validationMessage.add("It's not posibble validate Id Type data");
		}
		
		dto.validateName(validationMessage);
		return validationMessage;
	}
	
}
