package co.edu.grades.data.dao;

import co.edu.uco.grades.dto.SessionDTO;

public interface SessionDAO {
	void open(SessionDTO session);
	void close(SessionDTO session);
	void find(SessionDTO session);
}
