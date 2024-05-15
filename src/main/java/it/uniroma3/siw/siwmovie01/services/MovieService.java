package it.uniroma3.siw.siwmovie01.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.siwmovie01.model.Movie;
import it.uniroma3.siw.siwmovie01.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public Movie findById(Long id) {
		return movieRepository.findById(id).get();
	}

	public Iterable<Movie> findAll() {
		return movieRepository.findAll();
	}

	@SuppressWarnings("null")
	public boolean save(Movie movie) {
		if (!movieRepository.existsByTitleAndYear(movie.getTitle(), movie.getYear())) {
			movieRepository.save(movie);
			return true;
		}
		return false;
	}

	public List<Movie> findByYear(Integer year) {
		return movieRepository.findByYear(year);
	}

}
