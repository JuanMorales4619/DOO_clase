package co.edu.uco.grades.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.api.controller.response.Response;
import co.edu.uco.grades.api.controller.validator.Validator;
import co.edu.uco.grades.api.controller.validator.idtype.CreateIdTypeValidator;
import co.edu.uco.grades.businesslogic.facade.IdTypeFacade;
import co.edu.uco.grades.businesslogic.facade.impl.IdTypeFacadeImpl;
import co.edu.uco.grades.crosscuting.exception.GradesException;
import co.edu.uco.grades.crosscuting.exeption.enumeration.ExeptionType;
import co.edu.uco.grades.dto.IdTypeDTO;

@RestController
@RequestMapping("/api/v1/idtype")
public class IdTypeController {

	@GetMapping("/dummy")
	public IdTypeDTO getDummy() {
		return new IdTypeDTO();
	}

	@PostMapping
	public ResponseEntity<Response<IdTypeDTO>> create(@RequestBody IdTypeDTO dto) {

		Validator<IdTypeDTO> validator = new CreateIdTypeValidator();

		List<String> messages = UtilObject.getUtilObject().getDefault(validator.validate(dto), new ArrayList<>());

		Response<IdTypeDTO> response = new Response<>();
		ResponseEntity<Response<IdTypeDTO>> responseEntity;
		HttpStatus statusCode = HttpStatus.BAD_REQUEST;

		if (messages.isEmpty()) {
			try {
				IdTypeFacade facade = new IdTypeFacadeImpl();
				facade.create(dto);
				statusCode = HttpStatus.OK;
			} catch (GradesException exception) {
				if (ExeptionType.TECHNICAL.equals(exception.getType())) {
					messages.add("There was a problem triyng to register the new id Type, try again...");
					System.out.println(exception.getLocalizedMessage());
					System.out.println(exception.getType());
					System.out.println(exception.getTecnicalMessage());
					exception.getRootExeption().printStackTrace();
				} else {
					messages.add(exception.getUserMessage());
					System.out.println(exception.getLocalizedMessage());
					System.out.println(exception.getType());
					System.out.println(exception.getUserMessage());
					exception.getRootExeption().printStackTrace();

				}
			} catch (Exception exception) {
				messages.add("There was an unexpected problem trying to register new id Type, try again...");
				exception.printStackTrace();
			}

		}
		response.setMessage(messages);
		responseEntity = new ResponseEntity<>(response, HttpStatus.OK);

		return responseEntity;
	}

	@PutMapping("/{id}")
	public void update(@PathVariable("id") int id, @RequestBody IdTypeDTO dto) {

		System.out.print("estoy en actualizar");
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {

		System.out.print("estoy en eliminar");
	}

	@DeleteMapping("/{id}")
	public void findById(@PathVariable("id") int id) {

		System.out.print("estoy en consultar por id");
	}

	@DeleteMapping
	public ResponseEntity<Response<IdTypeDTO>> find() {
		List<String> messages = new ArrayList<>();
		Response<IdTypeDTO> response = new Response<>();
		ResponseEntity<Response<IdTypeDTO>> responseEntity;
		HttpStatus statusCode = HttpStatus.BAD_REQUEST;

		try {
			IdTypeFacade facade = new IdTypeFacadeImpl();
			response.setData(facade.find(new IdTypeDTO()));
			messages.add("Id types were found succesfully");
			statusCode = HttpStatus.OK;
		} catch (GradesException exception) {
			if (ExeptionType.TECHNICAL.equals(exception.getType())) {
				messages.add("There was a problem triyng to find id Types, try again...");
				System.out.println(exception.getLocalizedMessage());
				System.out.println(exception.getType());
				System.out.println(exception.getTecnicalMessage());
				exception.getRootExeption().printStackTrace();
			} else {
				messages.add(exception.getUserMessage());
				System.out.println(exception.getLocalizedMessage());
				System.out.println(exception.getType());
				System.out.println(exception.getUserMessage());
				exception.getRootExeption().printStackTrace();

			}
		} catch (Exception exception) {
			messages.add("There was an unexpected problem trying to find id Type, try again...");
			exception.printStackTrace();
		}

		response.setMessage(messages);
		responseEntity = new ResponseEntity<>(response, HttpStatus.OK);

		return responseEntity;
	}

}
