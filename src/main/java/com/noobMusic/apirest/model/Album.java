package com.noobMusic.apirest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AlbumId")
    private Integer id;

    @Column(name = "Title")
    private String title;

    @ManyToOne
    @JoinColumn( name = "ArtistId" )
    @JsonBackReference
    private Artist artist;

    public Album() {
    }

    public Album(String title, Integer id) {
        this.title = title;
        this.id = id;
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