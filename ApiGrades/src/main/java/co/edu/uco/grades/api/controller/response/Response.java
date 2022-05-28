package co.edu.uco.grades.api.controller.response;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;

public class Response<D> {
	private List<D> data;
	private List<String> message;
	
	
	public Response(List<D> data, List<String> message) {
		super();
		setData(data);
		setMessage(message);
	}
	public Response() {
		super();
		setData( new ArrayList<>());
		setMessage( new ArrayList<>());
	}
	
	
	public List<D> getData() {
		return data;
	}
	public void setData(List<D> data) {
		this.data = UtilObject.getUtilObject().getDefault(data, new ArrayList<>());
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = UtilObject.getUtilObject().getDefault(message, new ArrayList<>());;
	}
	
}
