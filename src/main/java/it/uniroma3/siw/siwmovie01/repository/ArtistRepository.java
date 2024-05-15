package it.uniroma3.siw.siwmovie01.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.siwmovie01.model.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
}