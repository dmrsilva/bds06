package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;

public class MovieReviewsDTO {

	private Long id;
	private String text;
	private Long movieId;
	private UserDTO user;
	
	public MovieReviewsDTO() {
	}

	public MovieReviewsDTO(Long id, String text, Long movie, UserDTO user) {
		this.id = id;
		this.text = text;
		this.movieId = movie;
		this.user = user;
	}
	
	public MovieReviewsDTO(Review entity) {
		id = entity.getId();
		text = entity.getText();
		movieId = entity.getMovie().getId();
		user = new UserDTO(entity.getUser());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}	
	
}
