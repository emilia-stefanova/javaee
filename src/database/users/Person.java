package database.users;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cinema.util.MD5Digest;
import database.cinema.Reservation;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {
	private static final long serialVersionUID = -7846215096792524127L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long personID;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DATEOFBIRTH")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "SECRETQUESTION")
	private String secretQuestion;
	@Column(name = "SECRETANSWER")
	private String secretAnswer;
	@Column(name = "ROLE")
	private String role;
	@OneToMany(mappedBy = "person")
	private List<Reservation> reservation;

	public Person() {
	}

	public Person(String username, String name, Date dateOfBirth, String email,
			String password, String secretQuestion, String secretAnswer,
			String role) {

		this.username = username;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		 this.password = MD5Digest.digestPassword(password);
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
		this.role = role;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getPersonID() {
		return personID;
	}

	public void setPersonID(long personID) {
		this.personID = personID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		 this.password = MD5Digest.digestPassword(password);
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
