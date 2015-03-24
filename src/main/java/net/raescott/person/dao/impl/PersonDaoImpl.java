package net.raescott.person.dao.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import net.raescott.person.dao.PersonDao;
import net.raescott.person.model.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "personDao")
public class PersonDaoImpl implements PersonDao {
	private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);
	@PersistenceContext(unitName = "h2PersistenceUnit")
	EntityManager em;

	@Transactional(value = "h2")
	public void addPerson(Person person){
		person.setCreatedDate(new Date());
 		em.persist(person);
	}

	@Transactional(value = "h2")
	public List<Person> findAllPerson(){
		List<Person> personList = new LinkedList<Person>(); // Null Object Pattern
		try {
			personList = (List<Person>) em.createNamedQuery("Person.findAll")
					.getResultList();
		} catch (NoResultException nre) {
			// This is okay, it means the database was empty.
		}
		return personList;
	}

	@Transactional(value = "h2")
	public List<Person> findAllNamedQuery() {
		List<Person> personList = new LinkedList<Person>(); // Null Object Pattern
		try {
			personList = (List<Person>) em.createNamedQuery("Person.findAll")
					.getResultList();
		} catch (NoResultException nre) {
			// This is okay, it means the database was empty.
		}
		return personList;
	}

	@Transactional(value = "h2")
	public List<Person> findAllCriteriaQuery() {
		List<Person> personList = new LinkedList<Person>(); // Null Object Pattern
		try {
			CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Person> personCriteriaQuery = criteriaBuilder.createQuery(Person.class);
			Root<Person> personRoot = personCriteriaQuery.from(Person.class);
			personCriteriaQuery.select(personRoot);
			TypedQuery<Person> personTypedQuery = em.createQuery(personCriteriaQuery);
			personList = personTypedQuery.getResultList();
		} catch (NoResultException nre) {
			// This is okay, it means the database was empty.
		}
		return personList;
	}

	@Transactional(value = "h2")
	public void persist(Person person) {
		em.persist(person);
	}

	@Transactional(value = "h2")
	public Person merge(Person person) {
		em.merge(person);
		return person;
	}
}