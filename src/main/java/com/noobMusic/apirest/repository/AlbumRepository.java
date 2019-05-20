package com.noobMusic.apirest.repository;

import com.noobMusic.apirest.model.Album;
import com.noobMusic.apirest.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository  extends JpaRepository<Album,Integer> {

}
