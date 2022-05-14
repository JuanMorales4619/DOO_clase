package co.edu.uco.grdes.data.factory;

import java.sql.Connection;

import co.edu.grades.data.dao.StudentDAO;

public abstract class DAOFactory {
	
	public static DAOFactory getDaoFactory(){
		return null;
	}
	
	public abstract StudentDAO getStudentDAO();
	public abstract void commitTransaction();
	public abstract void rollbackTransaction();
	protected abstract void openConnection();
	public abstract void closeConection();
	protected abstract Connection getConection();
	public abstract void initTransaction();

}
