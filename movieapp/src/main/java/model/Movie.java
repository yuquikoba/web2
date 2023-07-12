package model;

import java.io.Serializable;

public class Movie implements Serializable{
	private String userName;
	private String movieTitle;
	private String comment;
	
	public Movie() {}
	
	public Movie(String userName,String movieTitle,String comment) {
		this.userName=userName;
		this.movieTitle=movieTitle;
		this.comment=comment;
	}

	public String getUserName() {
		return userName;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public String getComment() {
		return comment;
	}
	

}
