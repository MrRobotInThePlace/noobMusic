package com.noobMusic.apirest.repository;

import com.noobMusic.apirest.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ArtistRepository extends JpaRepository <Artist, Integer>{
    Artist findById (Integer id);

    @Query(value = "SELECT * FROM artist WHERE Name LIKE :name%", nativeQuery = true)
    List<Artist> findByName(@Param("name") String name);

    //Artist findByName (String name);
}
