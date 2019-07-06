package comjonathan.curso.cursospringboot.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserDoesntExistException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDoesntExistException() {
		super();
	}
	
	public UserDoesntExistException(String message) {
		super(message);
	}
	
	

}
