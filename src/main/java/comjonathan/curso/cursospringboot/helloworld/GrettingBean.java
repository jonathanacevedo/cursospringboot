package comjonathan.curso.cursospringboot.helloworld;

public class GrettingBean {
	
	private String message;
	private String name;
	
	public GrettingBean(String message, String name) {
		super();
		this.message = message;
		this.name = name;
	}

	public String getProbando() {
		return message;
	}

	public void setTesting(String testing) {
		this.message = testing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GrettingBean [message=" + message + ", name=" + name + "]";
	}

}
