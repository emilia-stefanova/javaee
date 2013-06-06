package database.cinema;

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


import database.users.Person;


@Entity
@Table (name = "RESERVATION")
public class Reservation implements Serializable {
	private static final long serialVersionUID = -7846215096792524127L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "ID")
	private long reservationID;
	@ManyToOne
	@JoinColumn (name = "PERSONID")
    private Person person;
	@ManyToOne
	@JoinColumn (name = "SEATID")
    private Seats seat;
	@ManyToOne
	@JoinColumn (name = "SHOWINGID")
    private Showing showing;
	@Column (name = "ISPAID")
	private boolean isPaid;
	@Column (name = "ISUSED")
	private boolean isUsed;

	
    public Reservation() {
    }

    public Reservation(Person person, Showing showing, Seats seat) {
    	
    	this.person = person;
    	this.showing = showing;
    	this.seat = seat;

    }
    
    public Seats getSeat() {
		return seat;
	}

	public void setSeat(Seats seat) {
		this.seat = seat;
	}

	public long getReservationID() {
		return reservationID;
	}

	public void setReservationID(long reservationID) {
		this.reservationID = reservationID;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Showing getShowing() {
		return showing;
	}

	public void setShowing(Showing showing) {
		this.showing = showing;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public boolean getIsPaid() {
		return isPaid;
	}
	
	public void setIsUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public boolean getIsUsed() {
		return isUsed;
	}
    
    

}
