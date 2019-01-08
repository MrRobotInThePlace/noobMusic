package com.noobMusic.apirest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;

@Entity
@Table(name="Album")
public class Album {

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "ArtistId")
    private Artist artist;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AlbumId")
    private Integer id;

    @Column (name = "Title")
    private String title;

    public Album(Artist artist, Integer id, String title) {
        this.artist = artist;
        this.id = id;
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
