package com.noobMusic.apirest.repository;

import com.noobMusic.apirest.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlbumRepository  extends JpaRepository<Album,Integer> {
    Album findByTitle(String title);
}
