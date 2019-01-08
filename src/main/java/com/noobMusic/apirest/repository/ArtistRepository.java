package com.noobMusic.apirest.repository;

import com.noobMusic.apirest.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArtistRepository extends JpaRepository <Artist, Integer>{
    Artist findById (Integer id);
}
