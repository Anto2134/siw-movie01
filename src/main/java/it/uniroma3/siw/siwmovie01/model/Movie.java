package it.uniroma3.siw.siwmovie01.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private Integer year;
    private String urlImage;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getYear() {
        return this.year;
    }

    public String getUrlImage() {
        return this.urlImage;
    }

    public boolean equals(Object o) {
        Movie movie = (Movie) o;
        return this.getYear() == movie.getYear() && this.getTitle().equals(movie.getTitle());
    }

    @Override
    public int hashCode() {
        return (int) (this.getYear() + this.getId() + this.getTitle().hashCode() + this.getUrlImage().hashCode());
    }

}
