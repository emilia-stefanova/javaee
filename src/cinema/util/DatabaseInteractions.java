package cinema.util;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import database.cinema.Cinema;
import database.cinema.Hall;
import database.cinema.Movie;
import database.cinema.Reservation;
import database.cinema.Seats;
import database.cinema.Showing;
import database.users.Person;
import database.users.UserRoles;

public class DatabaseInteractions {

	public EntityManager em = null;

	public DatabaseInteractions(EntityManager em) {
		this.em = em;
	}

	public Showing getShowing(long showingId) {
		return em.find(Showing.class, showingId);
	}
	
	public void createReservation(Reservation newReservation) {
		insertEntity(newReservation);
	}
	
	
	public Person getPerson(long personId) {
		return em.find(Person.class, personId);
	}
	
	public Person getPerson(String username) {
		TypedQuery<Person> selectQuery = em.createQuery("SELECT p FROM Person p WHERE p.username = :param1", Person.class);
		selectQuery.setParameter("param1", username);
		Person person = selectQuery.getSingleResult();
		return person;
	}
	
	public void deletePerson(long personId) {
		Person person = getPerson(personId);
		removeEntity(person);
	}

	public void updatePerson(Person personToUpdate) {
		em.merge(personToUpdate);
	}

	public void createPerson(Person newPerson) {
		Person test = getPerson(newPerson.getPersonID());
		insertEntity(newPerson);
	}
	
	public void createRoleForPerson(UserRoles role){
		insertEntity(role);
	}

	synchronized public boolean reserveSeats(long[] seatIDs, Showing showing, String username){
		
		if(!checkSeats(seatIDs))
		{
			return false;
		}
		
		for(int i = 0; i < seatIDs.length; i++)
		{
			Seats seat = getSeats(seatIDs[i]);
			Person person = getPerson(username);
			Reservation reservation = new Reservation(person, showing, seat);
			reservation.setIsPaid(true);
			createReservation(reservation);
			seat.setOccupied(true);		
		}
		
		return true;
	}
	
	private boolean checkSeats(long[] seatIDs)
	{
		for(int i = 0; i < seatIDs.length; i++)
		{
			if(getSeats(seatIDs[i]).isOccupied())
			{
				return false;
			}
		}
		return true;
	}

	public Seats getSeats(long seatsId) {
		return em.find(Seats.class, seatsId);
	}
	
	protected void insertEntity(Object entity) {
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(entity);
			transaction.commit();
		} catch (PersistenceException exc) {
			System.out.println(exc.getMessage());
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}

	protected void removeEntity(Object entity) {
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(entity);
			transaction.commit();
		} catch (PersistenceException exc) {
			System.out.println(exc.getMessage());
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}

	public void destroy() {
		throw new NotImplementedException();
	}


	
}
