package it.uniroma3.siw.siwmovie01.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.siwmovie01.model.Movie;
import java.util.List;


public interface MovieRepository extends CrudRepository<Movie, Long> {
    public List<Movie> findByYear(Integer year);
    public boolean existsByTitleAndYear(String title, Integer year);
    // public boolean existByTitleAndYear(String title, Integer year);
}
