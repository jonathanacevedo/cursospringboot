package comjonathan.curso.cursospringboot.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controlador que puede manejar peticiones REST

@RestController
public class GrettingController {
	
	//Necesita 2 cosas: Método y URL
	
	@RequestMapping(method = RequestMethod.GET, path = "/gretting")
	public String greet() {
		return "Hola como estas";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/gretting-bean")
	public GrettingBean greetBean() {
		return new GrettingBean("Hola este es un bean", "Jonathan");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/person/{idPerson}")
	public GrettingBean getPersonById(@PathVariable String idPerson) {
		return new GrettingBean(String.format("Hi, how are you %s?", idPerson), "Jonathan");
	}

}
