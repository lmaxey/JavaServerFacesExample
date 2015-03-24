package net.raescott.person.bo.impl;

import net.raescott.person.bo.PersonBo;
import net.raescott.person.dao.PersonDao;
import net.raescott.person.model.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "personBo")
public class PersonBoImpl implements PersonBo {
	@Autowired PersonDao personDao;

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
 
	public void addPerson(Person person){
		personDao.addPerson(person);
	}
 
	public List<Person> findAllPerson(){
		return personDao.findAllPerson();
	}
}