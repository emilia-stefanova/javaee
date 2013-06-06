package users;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import database.cinema.Reservation;

public class UsersManagement {

	EntityManager em =null;
	
	public UsersManagement(EntityManager em) {
		this.em = em;
	}

	public List<Reservation> getReservationsForUser(String username) {
		TypedQuery<Reservation> selectQuery = em.createQuery("SELECT r FROM Reservation r WHERE r.person.username = :param1", Reservation.class);
		selectQuery.setParameter("param1", username);
		List<Reservation> allReservations = selectQuery.getResultList();
		return allReservations;
	}
	
	public List<Reservation> getCurrentReservationsForUser(String username, String movieTitle){
		TypedQuery<Reservation> selectQuery = em.createQuery("SELECT r FROM Reservation r WHERE r.person.username = :param1 and r.showing.movie.movieTitle = :param2", Reservation.class);
		selectQuery.setParameter("param1", username);
		selectQuery.setParameter("param2", movieTitle);
		List<Reservation> allReservations = selectQuery.getResultList();
		return allReservations;
	}
	
	public String getRoleForPerson(String username) {
		TypedQuery<String> selectQuery = em.createQuery("SELECT m.role FROM UserRoles m WHERE m.username=:param1", String.class);
		selectQuery.setParameter("param1", username);
		String role = selectQuery.getSingleResult();
		return role;		
	}

	public void destroy() {
		throw new NotImplementedException();
	}
	
}
