package database.cinema;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table (name = "SHOWING")
public class Showing implements Serializable {
	private static final long serialVersionUID = -7846215096792524127L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "ID")
	private long showingID;
	@Column (name = "TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	@ManyToOne
	@JoinColumn (name = "MOVIEID")
    private Movie movie;
	@ManyToOne
	@JoinColumn (name = "HALLID")
    private Hall hallshowing;
	@OneToMany(mappedBy = "showing")
	private List<Reservation> reservation;

	
    public Showing() {
    }

    public Showing(Date time, Movie movie, Hall hall) {
    	
    	this.time = time;
    	this.movie = movie;
    	this.hallshowing = hall;

    }

	public long getShowingID() {
		return showingID;
	}

	public void setShowingID(long showingID) {
		this.showingID = showingID;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Hall getHall() {
		return hallshowing;
	}

	public void setHall(Hall hall) {
		this.hallshowing = hall;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
