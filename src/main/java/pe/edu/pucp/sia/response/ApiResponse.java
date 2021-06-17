package pe.edu.pucp.sia.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class ApiResponse {
	private Object response;
	private int status;
	private String error;
	
	public ApiResponse(Object response, int status) {
		this.response = response;
		this.status = status;
	}
	
	public ApiResponse(int status, String error) {
		this.error = error;
		this.status = status;
	}
}
