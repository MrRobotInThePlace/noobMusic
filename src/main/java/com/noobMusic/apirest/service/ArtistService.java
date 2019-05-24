package com.noobMusic.apirest.service;

import com.noobMusic.apirest.exception.AlreadyExistException;
import com.noobMusic.apirest.model.Artist;
import com.noobMusic.apirest.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ArtistService {
    @Autowired
    ArtistRepository artistRepository;

    // affichage d'un artiste en fonction de son Id (affiche message d'erreur si non existant)
    public Artist seeArtist (Integer id) {
        Artist a = artistRepository.findOne(id);
        if(a == null){
            throw new EntityNotFoundException("L'artiste avec l'id numéro " + id + " n'existe pas" );
        }
        return a;
    }

    // affichage des artistes par nom (affiche message d'erreur si aucun n'artiste n'est trouvé)
    public List<Artist> seeArtistName(String name){
        List<Artist> a = artistRepository.findByName(name);
        if(a == null){
            throw new EntityNotFoundException("La liste d'artistes est vide" );
        }
        return a;
    }

    // affichage de tous les artistes dans l'ordre alphabéthique descendant
    public Page<Artist> findAllArtist(Integer page, Integer size, String sortDirection, String sortProperty){
        PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.fromString(sortDirection),sortProperty);
        return artistRepository.findAll(pageRequest);
    }

    //sauvegarde de l'artiste ajouté et gestion du message d'erreur au cas où l'artiste est déjà existant
    public Artist saveArtist(Artist a) {
        if(artistRepository.findByName(a.getName()).size()==0) {
            return artistRepository.save(a);
        }else{
            throw new AlreadyExistException("l'artist : " + a.getName() + " existe déjà.");
        }
    }

    //sauvegarde de la mise à jour de l'artiste
    public Artist updateAddArtist(Integer id, Artist a) throws Exception {
        return artistRepository.save(a);

    }

    //sauvegarde de la suppression de l'artiste
    public void deleteArtist(Integer id){
        artistRepository.delete(id);
    }
}
