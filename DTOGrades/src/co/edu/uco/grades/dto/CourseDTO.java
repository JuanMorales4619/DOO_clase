package co.edu.uco.grades.dto;

import java.sql.Date;

import co.edu.uco.crosscutting.util.numeric.UtilNumeric;

public class CourseDTO {
	private int id;
	private SubjectDTO subject;
	private ProfessorDTO profesor;
	private Date initialDate;
	private Date finalDate;
	
	public CourseDTO(int id, SubjectDTO subject, ProfessorDTO profesor, Date initialDate, Date finalDate) {
		super();
		setId(id);
		setSubject(subject);
		setProfesor(profesor);
		setInitialDate(initialDate);
		setFinalDate(finalDate);
	}
	
	public CourseDTO() {
		super();
		setSubject(new SubjectDTO());
		setProfesor(new ProfessorDTO());
		setInitialDate(new java.sql.Date(UtilNumeric.ZERO));
		setFinalDate(new java.sql.Date(UtilNumeric.ZERO));
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SubjectDTO getSubject() {
		return subject;
	}
	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}
	public ProfessorDTO getProfesor() {
		return profesor;
	}
	public void setProfesor(ProfessorDTO profesor) {
		this.profesor = profesor;
	}
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	
}
