package database.cinema;

import java.io.Serializable;
import java.util.Collection;

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
@Table (name = "SEATS")
public class Seats implements Serializable {
	private static final long serialVersionUID = -7846215096792524127L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "ID")
	private long seatID;
	@Column (name = "SEATNUMBER")
    private int seatNumber;
	@Column (name = "ROWNUMBER")
    private int rowNumber;
	@Column (name = "ISOCCUPIED")
    private boolean isOccupied;
	@JoinColumn (name = "HALLID")
	@ManyToOne
    private Hall hallseats;
	@OneToMany(mappedBy = "seat")
	private Collection<Reservation> reservation;
	
    public Seats() {
    }

    public Seats(int seatNumber, int rowNumber, boolean isOccupied, Hall hall) {
    	
    	this.seatNumber = seatNumber;
    	this.rowNumber = rowNumber;
    	this.isOccupied = isOccupied;
    	this.hallseats = hall;
    	
    }
    
	public long getSeatID() {
		return seatID;
	}

	public void setSeatID(long seatID) {
		this.seatID = seatID;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public Hall getHall() {
		return hallseats;
	}

	public void setHall(Hall hall) {
		this.hallseats = hall;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
    
}
