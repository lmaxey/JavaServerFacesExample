package net.raescott.person.dao;
 
import net.raescott.person.model.Person;

import java.util.List;

public interface PersonDao {
	void addPerson(Person person);
	List<Person> findAllPerson();
}