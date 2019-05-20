package com.noobMusic.apirest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AlbumId")
    private Integer id;

    private String Title;

    @ManyToOne
    @JoinColumn( name = "ArtistId" )
    @JsonBackReference
    private Artist artist;

    public Album() {
    }

    public Artist getArtist() {

        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album(String title, Artist artist) {
        Title = title;
        this.artist = artist;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {

        return Title;
    }

    public void setTitle(String title) {

        Title = title;
    }
}
