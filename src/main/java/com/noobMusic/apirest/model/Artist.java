package com.noobMusic.apirest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Artist")
public class Artist {

    @OneToMany(mappedBy = "artist")
    @JsonBackReference
    @JsonIgnoreProperties("artist")
    private List<Album> discographie;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ArtistId")
    private Integer id;

    @Column (name = "Name")
    private String name;

    public Artist() {
    }

    public Artist(List<Album> discographie, Integer id, String name) {
        this.discographie = discographie;
        this.id = id;
        this.name = name;
    }

    public List<Album> getDiscographie() {
        return discographie;
    }

    public void setDiscographie(List<Album> discographie) {
        this.discographie = discographie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
