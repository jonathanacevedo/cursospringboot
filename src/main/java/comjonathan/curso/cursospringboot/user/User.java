package comjonathan.curso.cursospringboot.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	
	private Integer id;
	
	@Size(min = 2)
	private String name;
	private int age;
	
	@Past
	private Date birthDate;
	
	
	protected User() {
		
	}
	
	public User(Integer id, String name, int age, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", birthDate=" + birthDate + "]";
	}

}
