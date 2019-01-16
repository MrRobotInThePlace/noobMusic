package com.noobMusic.apirest.controller;

import com.noobMusic.apirest.model.Artist;
import com.noobMusic.apirest.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(
            method = RequestMethod.GET,
            params = "name")
    public List<Artist> seeArtistName(
            @RequestParam ("name") String name){
        return this.artistService.seeArtistName(name);
    }


    @RequestMapping
    public Page<Artist> findAllArtist
            (@RequestParam(value="page") Integer page,
             @RequestParam(value="size") Integer size,
             @RequestParam(value="sortProperty") String sortProperty,
             @RequestParam(value="sortDirection") String sortDirection) {
        return artistService.findAllArtist(page, size, sortProperty, sortDirection);
    }

}
