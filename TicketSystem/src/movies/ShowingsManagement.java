package movies;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import database.cinema.Movie;
import database.cinema.Showing;

public class ShowingsManagement {

	public EntityManager em = null;

	public ShowingsManagement(EntityManager em) {
		this.em = em;
	}

	public List<Showing> getShowingForMovie(String movieTitle) {
		TypedQuery<Showing> selectQuery = em.createQuery(
				"SELECT s FROM Showing s WHERE s.movie.movieTitle = :param1",
				Showing.class);
		selectQuery.setParameter("param1", movieTitle);
		List<Showing> allShowings = selectQuery.getResultList();
		return allShowings;
	}

	public List<Showing> getShowings() {
		TypedQuery<Showing> selectQuery = em.createQuery(
				"SELECT s FROM Showing s", Showing.class);
		List<Showing> allShowings = selectQuery.getResultList();
		return allShowings;
	}
	public List<Movie> getMovies() {
		TypedQuery<Movie> selectQuery = em.createQuery("SELECT m FROM Movie m", Movie.class);
		List<Movie> allMovies = selectQuery.getResultList();
		return allMovies;
	}
	
	public Showing getShowing(long showingId) {
		return em.find(Showing.class, showingId);
	}

	public void destroy() {
		throw new NotImplementedException();
	}
	
}
