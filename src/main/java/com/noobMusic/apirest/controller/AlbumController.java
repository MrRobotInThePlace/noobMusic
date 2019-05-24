package com.noobMusic.apirest.controller;

import com.noobMusic.apirest.exception.AlreadyExistException;
import com.noobMusic.apirest.model.Album;
import com.noobMusic.apirest.model.Artist;
import com.noobMusic.apirest.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

// Méthode pour ajouter un album à un artiste existant
@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    AlbumService albumService;

    // Ajouter un album (gestion d'erreur au cas où il existe déjà)
    @RequestMapping(
            method = RequestMethod.POST,
            value = ""
    )
    public Album SaveAlbum(
            @RequestBody Album a) throws AlreadyExistException
    {
        return albumService.saveAlbum(a);
    }

    //Mise à jour d'un album déjà existant
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{id}"
    )
    public Album AddAlbum(
            @PathVariable(value = "id")Integer id,
            @RequestBody Album a
    ) throws Exception
    {
        return albumService.updateAddAlbum(id, a);
    }

    //suppression d'album  (gestion du message d'affichage de validation ou d'erreur de la suppression)
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void albumDelete(@PathVariable(value = "id")Integer id) throws Exception {
        albumService.deleteAlbum(id);
    }
}
