package it.uniroma3.siw.siwmovie01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.siwmovie01.model.Movie;
import it.uniroma3.siw.siwmovie01.services.MovieService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/movie/{id}")
    public String getMovie(@PathVariable("id") Long id, Model model) {
        model.addAttribute("movie", this.movieService.findById(id));
        return "movie.html";
    }

    @GetMapping("/movie")
    public String showMovies(Model model) {
        model.addAttribute("movies", this.movieService.findAll());
        return "movies.html";
    }

    @GetMapping("/formNewMovie")
    public String formNewMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "formNewMovie.html";
    }

    @PostMapping("/movie")
    public String newMovie(@ModelAttribute("movie") Movie movie, Model model) {
        if (this.movieService.save(movie)) {
            model.addAttribute("movie", movie);
            return "redirect:movie/" + movie.getId();
        }
        return "paginaErrore.html";
    }

    @GetMapping("/formSearchMovies")
    public String formSearchMovies(Integer year) {
        return "formSearchMovies.html";
    }

    @GetMapping("/cerca")
    public String getMethodName(@RequestParam("year") Integer year, Model model) {
        List<Movie> film = this.movieService.findByYear(year);
        model.addAttribute("film", film);
        return "risultati.html";
    }

}
