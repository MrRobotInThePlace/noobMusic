package com.noobMusic.apirest.service;

import com.noobMusic.apirest.model.Artist;
import com.noobMusic.apirest.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ArtistService {

    public static final Integer PAGE_SIZE_MIN = 10;
    public static final Integer PAGE_SIZE_MAX = 100;
    public static final Integer PAGE_MIN = 0;

    @Autowired
    private ArtistRepository artistRepository;

    public Long countArtist() {
        return artistRepository.count();
    }

    public Artist seeArtist (Integer id) {
        Artist a = artistRepository.findById(id);
        if (a == null) {
            throw new EntityNotFoundException("Impossible de trouver l'artiste n° : " + id);
        }
        return a;
    }

    public List<Artist> seeArtistName(String name) {
        List<Artist> artist = artistRepository.findByName(name);
        if (artist == null){
            throw new EntityNotFoundException("L'artiste de nom" + name + " n'a pas été trouvé");
        }
        return artist;
    }

    public Page<Artist> findAllArtist(Integer page, Integer size, String sortProperty, String sortDirection) {

        if (page == null) {
            page = PAGE_MIN;
        } else if(page < 0) {
            throw new IllegalArgumentException("Le numéro de page ne peut être inférieur à 0");
        }

        if (size == null) {
            size = PAGE_SIZE_MIN;
        } else if(size < 0 || size > PAGE_SIZE_MAX) {
            throw new IllegalArgumentException("La taille de la page doit être comprise entre 1 et " +  (countArtist() / (page+1)));
        } else if (page > countArtist()/size) {
            throw new IllegalArgumentException("Le numéro de page ne peut être sup à " + (countArtist() / size));
        }

        Sort sort = null;
        try {
            sort = new Sort(new Sort.Order(Sort.Direction.fromString(sortDirection),sortProperty));
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Le sens du tri peut valoir 'ASC' pour un tri ascendant ou 'DESC' pour un tri descendant (insensible à la casse");
        }
        Pageable pageable = new PageRequest(page,size,sort);
        Page<Artist> artists = artistRepository.findAll(pageable);
        if(page >= artists.getTotalPages()){
            throw new IllegalArgumentException("Le numéro de page ne peut être supérieur à " + artists.getTotalPages());
        } else if(artists.getTotalElements() == 0){
            throw new EntityNotFoundException("Il n'y a aucun artist dans la base de données");
        }

        return artistRepository.findAll(pageable);
    }
}
