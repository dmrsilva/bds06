package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;

public class MovieDetailsDTO extends MovieDTO{

	private String synopsis;
	private GenreDTO genre;
	
	public MovieDetailsDTO() {
	}
	
	public MovieDetailsDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis, GenreDTO genre) {
		super(id, title, subTitle, year, imgUrl);
		this.synopsis = synopsis;
		this.genre = genre;
	}
	
	public MovieDetailsDTO(Movie entity) {
		super(entity);
		synopsis = entity.getSynopsis();
		genre = new GenreDTO(entity.getGenre());
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public GenreDTO getGenre() {
		return genre;
	}

	public void setGenre(GenreDTO genre) {
		this.genre = genre;
	}
	
}
