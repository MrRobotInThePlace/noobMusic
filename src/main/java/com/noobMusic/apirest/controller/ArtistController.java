package com.noobMusic.apirest.controller;

import com.noobMusic.apirest.model.Artist;
import com.noobMusic.apirest.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
            @PathVariable ("id") Integer id){
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
             @RequestParam(value="sortDirection") String sortDirection,
             @RequestParam(value="sortProperty") String sortProperty){
        return artistService.findAllArtist(page, size, sortDirection, sortProperty);
    }

    //ajouter un artiste à la DB2
    @RequestMapping(
            method = RequestMethod.POST,
            value = ""
    )
    public Artist AddArtist( @RequestBody Artist a){
        return artistService.saveArtist(a);
    }

    //Mise à jour d'un artiste déjà existant
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{id}"
    )
    public Artist AddArtist(
            @PathVariable(value = "id")Integer id,
            @RequestBody Artist a
    ) throws Exception
    {
        return artistService.updateAddArtist(id, a);
    }

    //supprimer un artiste (gestion du message d'affichage de validation ou d'erreur de la suppression)
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void artistDelete(
            @PathVariable(value = "id")Integer id) throws Exception {
        artistService.deleteArtist(id);
    }
}
