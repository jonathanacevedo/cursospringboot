package comjonathan.curso.cursospringboot.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	//Necesario el autowired para que se enlace con el @Component
	@Autowired    
	private UserDaoService service;
	
	//GET /users
	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public List<User> getAllUsers() {
		return service.findAll();
	}	
	
	//GET  users/{id}
	@RequestMapping(method = RequestMethod.GET, path = "users/{id}")
	public User getOneUser(@PathVariable int id) {
		
		User user = service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("Id: "+ id +" Not Found");			
		}
		return service.findOne(id);
	}
	
	//input : details of user
	//output : state created and the created URI
	@RequestMapping(method = RequestMethod.POST, path = "users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(savedUser.getId()).
				toUri();
		
		return ResponseEntity.created(location).build();
	}	
	
	@RequestMapping(method = RequestMethod.DELETE, path = "users/{id}")
	public void deleteUser(@PathVariable int id) {       //este tipo void tirá un 200 OK a menos que se corte con una excepción
		User userDeleted = service.deleteUser(id);
		
		if(userDeleted == null) 
			throw new UserDoesntExistException("Id: "+id+" doesn't exist");
		
	}
		
}
