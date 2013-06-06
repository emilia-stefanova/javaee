package cinema.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cinema.util.FillInTestData;

public class InitDB {
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static void main(String[] args) {

		emf = Persistence.createEntityManagerFactory("cinemaDatabase");
		em = emf.createEntityManager();
//		CinemaDAOImpl dao = new CinemaDAOImpl(em);
//		dao.fillTestData();
		FillInTestData f = new FillInTestData();
		f.initiateCinema();
		if (em != null)
			em.close();
		if (emf != null)
			emf.close();
	}

}