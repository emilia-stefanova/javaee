package cinema.database;

import java.io.Serializable;
import java.util.Collection;
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


@Entity
@Table (name = "HALL")
public class Hall implements Serializable {
	private static final long serialVersionUID = -7846215096792524127L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "ID")
	private long hallID;
	@Column (name = "NUMBER")
    private int hallNumber;
	@Column (name = "SEATSCOUNT")
    private int seatsCount;
	@Column (name = "ROWSCOUNT")
    private int rowsCount;
	@JoinColumn (name = "CINEMAREF")
	@ManyToOne
    private Cinema cinema;
	@OneToMany(mappedBy = "hallshowing")
    private List<Showing> showing;
	@OneToMany(mappedBy = "hallseats")
    private List<Seats> seats;
	
    public Hall() {
    }

    public Hall(int hallNumber, int seatsCount, int rowsCount, Cinema cinema) {
    	
    	this.hallNumber = hallNumber;
    	this.seatsCount = seatsCount;
    	this.rowsCount = rowsCount;
    	this.cinema = cinema;
    	
    }

	public long getHallID() {
		return hallID;
	}

	public void setHallID(long hallID) {
		this.hallID = hallID;
	}

	public int getHallNumber() {
		return hallNumber;
	}

	public void setHallNumber(int hallNumber) {
		this.hallNumber = hallNumber;
	}

	public int getSeatsCount() {
		return seatsCount;
	}

	public void setSeatsCount(int seatsCount) {
		this.seatsCount = seatsCount;
	}
	
	public int getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Collection<Showing> getShowing() {
		return showing;
	}

	public void setShowing(List<Showing> showing) {
		this.showing = showing;
	}

	public List<Seats> getSeats() {
		return seats;
	}

	public void setSeats(List<Seats> seats) {
		this.seats = seats;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
    
}
