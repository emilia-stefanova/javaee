/*
 * Copyright 2007 Sun Microsystems, Inc.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developer.sun.com/berkeley_license.html
 */

package cinema.listeners;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import users.UsersManagement;

import movies.ShowingsManagement;

import cinema.util.DatabaseInteractions;

public final class ContextListener implements ServletContextListener {

	private ServletContext context = null;

	public void contextInitialized(ServletContextEvent event) {
		try {
			context = event.getServletContext();
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("cinemaDatabase");
			EntityManager em = emf.createEntityManager();

			// CinemaDAO cinemaDBAO = new CinemaDAOImpl(em);
			DatabaseInteractions dbInteractions = new DatabaseInteractions(em);
			ShowingsManagement showingsInfo = new ShowingsManagement(em);
			UsersManagement usersInfo = new UsersManagement(em);

			// context.setAttribute("cinemaDBAO", cinemaDBAO);
			context.setAttribute("dbInteractions", dbInteractions);
			context.setAttribute("showingsInfo", showingsInfo);
			context.setAttribute("usersInfo", usersInfo);

		} catch (Exception ex) {
			System.err.println("Couldn't create bookstore database bean: " + ex.getMessage());
			ex.printStackTrace(System.err);
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
		context = event.getServletContext();
//		CinemaDAO cinemaDBAO = (CinemaDAOImpl) context.getAttribute("cinemaDBAO");
		UsersManagement usersInfo = (UsersManagement) context.getAttribute("usersInfo");
		ShowingsManagement showingsInfo = (ShowingsManagement) context.getAttribute("showingsInfo");
		
//		cinemaDBAO.destroy();
		usersInfo.destroy();
		showingsInfo.destroy();
		
//		context.removeAttribute("cinemaDBAO");
		context.removeAttribute("usersInfo");
		context.removeAttribute("showingsInfo");
	}

}
