package com.github.carloscontrerasruiz.Repository.factory;

import com.github.carloscontrerasruiz.Repository.properties.RepositoriesProperties;
import com.github.carloscontrerasruiz.Repository.properties.ShowsProperties;
import com.github.carloscontrerasruiz.Repository.repository.CharacterRepository;
import com.github.carloscontrerasruiz.Repository.repository.futurama.FuturamaRepository;
import com.github.carloscontrerasruiz.Repository.repository.pokemon.PokemonRepo;
import com.github.carloscontrerasruiz.Repository.repository.rick_morty.RickMortyRepo;
import com.github.carloscontrerasruiz.Repository.repository.simpsons.SimpsonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TheFactory {

    @Autowired
    private SimpsonsRepository simpsonsRepository;

    @Autowired
    private RickMortyRepo rickMortyRepo;

    @Autowired
    private FuturamaRepository futuramaRepository;

    @Autowired
    private PokemonRepo pokemonRepo;

    @Autowired
    private RepositoriesProperties repositoriesProperties;

    public CharacterRepository getRightRepo(String identifier) {
        Map<String, ShowsProperties> shows = repositoriesProperties.getShows();
        if (!shows.containsKey(identifier) || !shows.get(identifier).isActive()) {
            throw new IllegalArgumentException("Repository is not configured");
        }

        switch (identifier) {
            case "simpson":
                return simpsonsRepository;
            case "rick":
                return rickMortyRepo;
            case "pokemon":
                return pokemonRepo;
            case "futurama":
                return futuramaRepository;
            default:
                throw new IllegalArgumentException("Repository not found");
        }
    }
}
