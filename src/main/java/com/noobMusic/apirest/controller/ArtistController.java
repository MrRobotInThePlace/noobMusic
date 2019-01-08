package com.noobMusic.apirest.controller;

import com.noobMusic.apirest.model.Artist;
import com.noobMusic.apirest.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}")
    public Artist seeArtist(
        @PathVariable Integer id){
        return this.artistService.seeArtist(id);
    }

}
