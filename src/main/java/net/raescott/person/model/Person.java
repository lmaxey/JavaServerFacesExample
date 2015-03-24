package net.raescott.person.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@NamedQueries({
		// Person.findAll does not conform to proper naming so it does not override.
		@NamedQuery(name = "Person.findAll", query = "select p from Person p order by name"), // Never gets called, only the generated one is used.
		@NamedQuery(name = "Person.findById", query = "select p from Person p where p.id = :id"), // Only called because of the Repository Implementation
	/*
	 * Person.findByName is intentionally wrong to show that this does override by using the proper naming
	 */
		@NamedQuery(name = "Person.findByName", query = "select p from Person p where p.name != ?1") // Overrides the generated method
})
public class Person {

	@Id
	public long personId;
	public String name;
	public String address;
	public Date createdDate;
	
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}