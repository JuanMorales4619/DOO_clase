package co.edu.uco.grdes.data.factory;

import co.edu.uco.grades.dto.Student_DTO;

public abstract class DAOFactory {
	
	public static DAOFactory getDaoFactory(){
		return null;
	}
	
	public abstract Student_DTO getStudent_DTO(){
	}
	public abstract void commit();
	public abstract void rollback();
	protected abstract void openConnection();
	public abstract void cleseConection();
	public abstract void getConection();

}
