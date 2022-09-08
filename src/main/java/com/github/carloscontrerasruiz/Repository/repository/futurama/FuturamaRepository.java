package com.github.carloscontrerasruiz.Repository.repository.futurama;

import com.github.carloscontrerasruiz.Repository.entity.CharacterEntity;
import com.github.carloscontrerasruiz.Repository.repository.CharacterRepository;
import com.github.carloscontrerasruiz.Repository.repository.futurama.dto.FuturamaCharater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FuturamaRepository implements CharacterRepository {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public CharacterEntity getCharacter(String characterName) {
        try {
            FuturamaCharater[] response = restTemplate.getForObject("https://api.sampleapis.com/futurama/characters",
                    FuturamaCharater[].class);
            List<FuturamaCharater> characters = Arrays.stream(response).filter(c -> {
                var fullName = c.getName().getFirst() + c.getName().getMiddle() + c.getName().getLast();
                return fullName.toLowerCase().contains(characterName.toLowerCase());
            }).collect(Collectors.toList());
            if (characters.isEmpty()) {
                throw new IllegalArgumentException("No existe ese personaje");
            }
            return futuramaResponseToEntity(characters.get(0));
        } catch (RestClientException ex) {
            System.out.println(ex.getMessage());
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    private CharacterEntity futuramaResponseToEntity(FuturamaCharater futuramaCharater) {
        var name = futuramaCharater.getName();
        var fullName = name.getFirst() + " " + name.getMiddle() + " " + name.getLast();
        return CharacterEntity.builder()
                .fullName(fullName)
                .description(futuramaCharater.getOccupation())
                .show("FUTURAMA")
                .imageUrl(futuramaCharater.getImages().getMain())
                .build();
    }
}
