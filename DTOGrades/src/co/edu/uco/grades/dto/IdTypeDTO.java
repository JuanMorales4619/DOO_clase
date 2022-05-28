package co.edu.uco.grades.dto;


import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class IdTypeDTO {
	private int id;
	private String name;
	
	
	
	public IdTypeDTO(int id, String name) {
		super();
		setId(id);
		setName(name);
	}
	public IdTypeDTO() {
		super();
		setId(id);
		setName(UtilText.EMPTY);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = UtilText.getDefault(name);
	}
	
	public void validateName(List<String> validationMessage){
		validationMessage = UtilObject.getUtilObject().getDefault(validationMessage, new ArrayList<>());
		
		if(UtilText.isEmpty(getName())){
			validationMessage.add("Name of id type is requiered!!");
		}else if(UtilText.getDefault(getName()).length()> 50) {
			validationMessage.add("length of name of id type must be less or equals to 50 characcters!!!");
		}else if(!UtilText.getDefault(getName()).matches("^[a-zA-ZÒ—·¡È…ÌÕÛ”˙⁄ ]*$")){
			validationMessage.add("length of name of id type must be less or equals to 50 characcters!!!");
		}
	}
}
