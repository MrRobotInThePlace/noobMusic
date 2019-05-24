package com.noobMusic.apirest.service;

import com.noobMusic.apirest.exception.AlreadyExistException;
import com.noobMusic.apirest.model.Album;
import com.noobMusic.apirest.model.Artist;
import com.noobMusic.apirest.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;

    //sauvegarde de l'album et gestion message d'erreur
    public Album saveAlbum(Album a) {
        if(albumRepository.findByTitle(a.getTitle()) !=null) {
            throw new AlreadyExistException("l'album : " + a.getTitle() + " existe déjà.");
        }
            return albumRepository.save(a);
    }

    //sauvegarde de la mise à jour d'un album déjà existant
    public Album updateAddAlbum(Integer id, Album a) throws Exception {
        return albumRepository.save(a);
    }

    //sauvegarde de la suppression d'un album
    public void deleteAlbum(Integer id) {
        albumRepository.delete(id);
    }
}

