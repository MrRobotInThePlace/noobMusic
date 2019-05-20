package com.noobMusic.apirest.repository;

import com.noobMusic.apirest.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ArtistRepository extends JpaRepository<Artist,Integer> {
        List<Artist> findByName(String name);

    Page<Artist> findAll(Pageable pageable);

}
