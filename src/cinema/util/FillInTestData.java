package cinema.util;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import database.cinema.Cinema;
import database.cinema.Hall;
import database.cinema.Movie;
import database.cinema.Reservation;
import database.cinema.Seats;
import database.cinema.Showing;
import database.users.Person;
import database.users.UserRoles;

public class FillInTestData {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemaDatabase");
	EntityManager em = emf.createEntityManager();
	DatabaseInteractions dbInteraction = new DatabaseInteractions(em);

	public void initiateCinema() {

		Cinema cinema = new Cinema("Movie Theater", "2 Arsenalski Blvd., floor 3",
				3592123456l);
		dbInteraction.insertEntity(cinema);

		Person user1 = new Person("user1", "Emilia", new Date(1989, 1, 1),
				"emilia@gmail.com", "secret", "secret", "secret", "user");
		dbInteraction.insertEntity(user1);
		Person admin1 = new Person("admin1", "Deyan",
				new Date(1989, 5, 5), "deyan@gmail.com", "secret",
				"secret", "secret", "admin");
		dbInteraction.insertEntity(admin1);

		Movie movie1 = new Movie("The Hangover Part III ", "comedy",
				"Bradley Cooper, Ed Helms, Zach Galifianakis", "Todd Phillips",
				2013, "USA", 100 , "C", "link", "../images/posters/hangover.jpg");
		dbInteraction.insertEntity(movie1);
		Movie movie2 = new Movie("Fast & Furious 6",
				"action", " Vin Diesel, Paul Walker, Dwayne Johnson",
				"Justin Lin", 2013, "USA", 130 , "C", "link", "../images/posters/fast&furious.jpg");
		dbInteraction.insertEntity(movie2);
		Movie movie3 = new Movie("Iron Man 3", "action",
				" Robert Downey Jr., Gwyneth Paltrow, Don Cheadle",
				"Shane Black", 2013, "USA", 132, "B", "http://www.youtube.com/watch?v=2CzoSeClcw0", "../images/posters/ironman.jpg");
		dbInteraction.insertEntity(movie3);
		
		Hall hall1 = new Hall(1, 10, 2, cinema);
		dbInteraction.insertEntity(hall1);
		Hall hall2 = new Hall(2, 15, 3, cinema);
		dbInteraction.insertEntity(hall2);
		Hall hall3 = new Hall(3, 15, 3, cinema);
		dbInteraction.insertEntity(hall3);
		Hall hall4 = new Hall(4, 15, 3, cinema);
		dbInteraction.insertEntity(hall4);
		Hall hall5 = new Hall(5, 15, 3, cinema);
		dbInteraction.insertEntity(hall5);

		Showing showing1 = new Showing(new java.util.Date(2013, 1, 30, 10, 10),
				movie1, hall1);
		dbInteraction.insertEntity(showing1);
		Showing showing2 = new Showing(new java.util.Date(2013, 1, 30, 11, 10),
				movie2, hall2);
		dbInteraction.insertEntity(showing2);
		Showing showing3 = new Showing(new java.util.Date(2013, 1, 30, 12, 10),
				movie3, hall3);
		dbInteraction.insertEntity(showing3);


		Seats seat1 = new Seats(1, 1, false, hall1);
		dbInteraction.insertEntity(seat1);
		Seats seat2 = new Seats(2, 1, false, hall1);
		dbInteraction.insertEntity(seat2);
		Seats seat3 = new Seats(3, 1, false, hall1);
		dbInteraction.insertEntity(seat3);
		Seats seat4 = new Seats(4, 1, false, hall1);
		dbInteraction.insertEntity(seat4);
		Seats seat5 = new Seats(5, 1, false, hall1);
		dbInteraction.insertEntity(seat5);
		Seats seat6 = new Seats(1, 2, false, hall1);
		dbInteraction.insertEntity(seat6);
		Seats seat7 = new Seats(2, 2, false, hall1);
		dbInteraction.insertEntity(seat7);
		Seats seat8 = new Seats(3, 2, false, hall1);
		dbInteraction.insertEntity(seat8);
		Seats seat9 = new Seats(4, 2, true, hall1);
		dbInteraction.insertEntity(seat9);
		Seats seat10 = new Seats(5, 2, false, hall1);
		dbInteraction.insertEntity(seat10);

		Reservation reservation1 = new Reservation(user1, showing1, seat1);
		dbInteraction.insertEntity(reservation1);
		
		UserRoles role1 = new UserRoles("user1", "user");
		dbInteraction.insertEntity(role1);
		UserRoles role2 = new UserRoles("admin1", "admin");
		dbInteraction.insertEntity(role2);
	}
	
}
