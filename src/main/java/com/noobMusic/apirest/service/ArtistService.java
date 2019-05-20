package com.noobMusic.apirest.service;

import com.noobMusic.apirest.exception.AlreadyExistException;
import com.noobMusic.apirest.model.Artist;
import com.noobMusic.apirest.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ArtistService {
    @Autowired
    ArtistRepository artistRepository;

    public Artist seeArtist (Integer id) {
        Artist a = artistRepository.findOne(id);
        if(a == null){
            throw new EntityNotFoundException("L'artiste avec l'id numéro " + id + " n'existe pas" );
        }
        return a;
    }

    public List<Artist> seeArtistName(String name){
        List<Artist> a = artistRepository.findByName(name);
        if(a == null){
            throw new EntityNotFoundException("La liste d'artistes est vide" );
        }
        return a;
    }

    public Page<Artist> findAllArtist(Integer page, Integer size, String sortDirection, String sortProperty){
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.fromString(sortDirection),sortProperty);
        return artistRepository.findAll(pageRequest);
    }

    public Artist saveArtist(Artist a) {
        if(artistRepository.findByName(a.getName()).size()==0) {
            return artistRepository.save(a);
        }else{
            throw new AlreadyExistException("l'artist : " + a.getName() + " existe deja.");
        }
    }

    public Artist updateAddArtist(Integer id, Artist a) throws Exception {
        return artistRepository.save(a);

    }

    public void deleteArtist(Integer id){
        artistRepository.delete(id);
    }
}
