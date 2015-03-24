package net.raescott;

import net.raescott.person.bo.PersonBo;
import net.raescott.person.model.Person;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "personBean")
public class PersonBean implements Serializable{
 
	@Autowired PersonBo personBo;
	
	public String name;
	public String address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPersonBo(PersonBo personBo) {
		this.personBo = personBo;
	}
 
	//get all person data from database
	public List<Person> getPersonList(){
		return personBo.findAllPerson();
	}
	
	//add a new person data into database
	public String addPerson(){
		
		Person person = new Person();
		person.setName(getName());
		person.setAddress(getAddress());
		
		personBo.addPerson(person);
		
		clearForm();
		
		return "";
	}
	
	//clear form values
	private void clearForm(){
		setName("");
		setAddress("");
	}
	
}
