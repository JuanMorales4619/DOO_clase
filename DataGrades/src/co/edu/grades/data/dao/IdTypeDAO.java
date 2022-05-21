package co.edu.grades.data.dao;

import java.util.List;

import co.edu.uco.grades.dto.IdTypeDTO;

public interface IdTypeDAO {
	void create(IdTypeDTO idTypeDAO);
	void update(IdTypeDTO idTypeDAO);
	void delete(int id);
	List<IdTypeDTO> find(IdTypeDTO idTypeDAO);
}
