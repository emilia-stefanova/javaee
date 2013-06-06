package database.cinema;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table (name = "CINEMA")
public class Cinema implements Serializable {
	private static final long serialVersionUID = -7846215096792524127L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "ID")
	private long cinemaID;
	@Column (name = "NAME")
    private String cinemaName;
	@Column (name = "ADDRESS")
    private String cinemaAddress;
	@Column (name = "PHONE")
    private long cinemaPhone;
	@OneToMany(mappedBy = "cinema")
	private Collection<Hall> hall;

	
    public Cinema() {
    }

    public Cinema(String cinemaName, String cinemaAddress, long cinemaPhone) {
    	
    	this.cinemaName = cinemaName;
    	this.cinemaAddress = cinemaAddress;
    	this.cinemaPhone = cinemaPhone;
    	
    }

	public long getCinemaID() {
		return cinemaID;
	}

	public void setCinemaID(long cinemaID) {
		this.cinemaID = cinemaID;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getCinemaAddress() {
		return cinemaAddress;
	}

	public void setCinemaAddress(String cinemaAddress) {
		this.cinemaAddress = cinemaAddress;
	}

	public long getCinemaPhone() {
		return cinemaPhone;
	}

	public void setCinemaPhone(long cinemaPhone) {
		this.cinemaPhone = cinemaPhone;
	}

	public Collection<Hall> getHall() {
		return hall;
	}

	public void setHall(Collection<Hall> hall) {
		this.hall = hall;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
    
}
