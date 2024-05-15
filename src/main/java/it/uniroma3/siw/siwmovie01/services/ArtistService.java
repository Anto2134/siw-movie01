package it.uniroma3.siw.siwmovie01.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.siwmovie01.model.Artist;
import it.uniroma3.siw.siwmovie01.repository.ArtistRepository;

@Service
public class ArtistService {
    @Autowired 
    private ArtistRepository artistRepository;
    
    public Artist findById(Long id){
        return artistRepository.findById(id).get();
    }

    public Iterable<Artist> findAll(){
        return artistRepository.findAll();
    }

    @SuppressWarnings("null")
    public void save(Artist artist){
        artistRepository.save(artist);
    }
}
