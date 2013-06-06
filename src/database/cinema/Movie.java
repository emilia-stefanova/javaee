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
@Table (name = "MOVIE")
public class Movie implements Serializable {
	private static final long serialVersionUID = -7846215096792524127L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "ID")
	private long movieID;
	@Column (name = "TITLE")
    private String movieTitle;
	@Column (name = "GENRE")
    private String movieGenre;
	@Column (name = "CAST")
    private String movieCast;
	@Column (name = "DIRECTOR")
    private String movieDirector;
	@Column (name = "YEAR")
    private int movieYear;
	@Column (name = "COUNTRY")
    private String movieCountry;
	@Column (name = "DURATION")
    private int movieDuration;
	@Column (name = "CATEGORY")
    private String movieCategory;
	@Column (name = "TRAILER")
    private String movieTrailer;
	@Column (name = "POSTER")
    private String moviePoster;
	@OneToMany(mappedBy = "movie")
	private Collection<Showing> showing;
	

    public Movie() {
    }

    public Movie(String movieTitle, String movieGenre, String movieCast, String movieDirector, int movieYear,
    		String movieCountry, int movieDuration, String movieCategory, String movieTrailer, String moviePoster) {
    	
    	this.movieTitle = movieTitle;
    	this.movieGenre = movieGenre;
    	this.movieCast = movieCast;
    	this.movieDirector = movieDirector;
    	this.movieYear = movieYear;
    	this.movieCountry = movieCountry;
    	this.movieDuration = movieDuration;
    	this.movieCategory = movieCategory;
    	this.movieTrailer = movieTrailer;
    	this.moviePoster = moviePoster;
    	
    }

	public long getMovieID() {
		return movieID;
	}

	public void setMovieID(long movieID) {
		this.movieID = movieID;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieCast() {
		return movieCast;
	}

	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public int getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}

	public String getMovieCountry() {
		return movieCountry;
	}

	public void setMovieCountry(String movieCountry) {
		this.movieCountry = movieCountry;
	}

	public int getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(int movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getMovieCategory() {
		return movieCategory;
	}

	public void setMovieCategory(String movieCategory) {
		this.movieCategory = movieCategory;
	}

	public String getMovieTrailer() {
		return movieTrailer;
	}

	public void setMovieTrailer(String movieTrailer) {
		this.movieTrailer = movieTrailer;
	}

	public String getMoviePoster() {
		return moviePoster;
	}

	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
