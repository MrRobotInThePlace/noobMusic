package com.noobMusic.apirest.service;

import com.noobMusic.apirest.model.Artist;
import com.noobMusic.apirest.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityNotFoundException;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public Artist seeArtist (Integer id) {
        Artist a = artistRepository.findById(id);
        if (a == null) {
            throw new EntityNotFoundException("Impossible de trouver l'artiste n° : " + id);
        }
        return a;
    }
}
