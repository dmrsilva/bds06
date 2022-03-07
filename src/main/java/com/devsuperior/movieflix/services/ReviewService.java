package com.devsuperior.movieflix.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieReviewsDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public MovieReviewsDTO insert(MovieReviewsDTO dto, String username) {
		try {
			Movie movie = movieRepository.getOne(dto.getMovieId());
			User user = userRepository.findByEmail(username); 
			Review review = new Review();
			review.setText(dto.getText());
			review.setMovie(movie);
			review.setUser(user);
			review = repository.save(review);
			return new MovieReviewsDTO(review);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity not found");
		}
	}
	
}
