package it.uniroma3.siw.siwmovie01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.siwmovie01.model.Artist;
import it.uniroma3.siw.siwmovie01.services.ArtistService;

@Controller
public class ArtistController {
    @Autowired
    ArtistService artistService;

    @GetMapping("/artist/{id}")
    public String getArtist(@PathVariable("id") Long id, Model model) {
        model.addAttribute("artist", this.artistService.findById(id));
        return "artist.html";
    }

    @GetMapping("/artist")
    public String showArtists(Model model) {
        model.addAttribute("artists", this.artistService.findAll());
        return "artists.html";
    }

    @GetMapping("/formNewArtist")
    public String formNewArtist(Model model){
        model.addAttribute("artist", new Artist());
        return "formNewArtist.html";
    }

    @PostMapping("/artist")
    public String newArtist(@ModelAttribute("artist") Artist artist, Model model){
        artistService.save(artist);
        model.addAttribute("artist", model);
        return "redirect:artist/" + artist.getId();
    }
}
