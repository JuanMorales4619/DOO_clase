package co.edu.uco.grades.crosscuting.exception;

import co.edu.uco.crosscuting.exeption.GeneralExeption;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.crosscuting.exeption.enumeration.ExceptionLocation;
import co.edu.uco.grades.crosscuting.exeption.enumeration.ExeptionType;

public class GradesException extends GeneralExeption{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7457237925352513736L;
	private ExeptionType type;
	private ExceptionLocation location;
	
	
	private GradesException(String userMessage, String tecnicalMessage, Exception rootExeption, ExeptionType type,
			ExceptionLocation location) {
		super(userMessage, tecnicalMessage, rootExeption);
		setType(type);
		setLocation(location);
	}
	
	public static GradesException build(String userMessage) {
		return new GradesException(userMessage, userMessage, null, null, null);
	}
	public static GradesException buildTechnicalExeption(String tecnicalMessage) {
		return new GradesException(null, tecnicalMessage, null, null, null);
	}
	
	public static GradesException build(String userMessage, String technicalMessage) {
		return new GradesException(userMessage, technicalMessage, null, null, null);
	}
	public static GradesException build(String userMessage, String tecnicalMessage, Exception rootExeption) {
		return new GradesException(userMessage, tecnicalMessage,rootExeption, null, null);
	}
	
	
	
	public ExeptionType getType() {
		return type;
	}
	public ExceptionLocation getLocation() {
		return location;
	}
	private void setType(ExeptionType type) {
		this.type = UtilObject.getUtilObject().getDefault(type, ExeptionType.GENERAL);
	}
	private void setLocation(ExceptionLocation location) {
		this.location  = UtilObject.getUtilObject().getDefault(location, ExceptionLocation.GENERAL);
	}
	

}
