package net.raescott.person.bo;
 
import net.raescott.person.model.Person;

import java.util.List;
 
public interface PersonBo {
	void addPerson(Person person);
	List<Person> findAllPerson();
 
}