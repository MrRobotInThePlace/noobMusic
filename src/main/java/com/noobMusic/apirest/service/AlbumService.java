package com.noobMusic.apirest.service;

import com.noobMusic.apirest.model.Album;
import com.noobMusic.apirest.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    @Autowired
    AlbumRepository albumRepository;

    public Album saveAlbum(Album a) {
        return albumRepository.save(a);
    }

    public void deleteAlbum(Integer id) {
        albumRepository.delete(id);
    }
}

