package com.github.carloscontrerasruiz.Repository.repository.simpsons;

import com.github.carloscontrerasruiz.Repository.entity.CharacterEntity;
import com.github.carloscontrerasruiz.Repository.repository.CharacterRepository;
import com.github.carloscontrerasruiz.Repository.repository.simpsons.dto.SimpsonsCharacter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SimpsonsRepository implements CharacterRepository {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public CharacterEntity getCharacter(@NonNull String characterName) {


        try {
            SimpsonsCharacter[] response = restTemplate.getForObject("https://api.sampleapis.com/simpsons/characters",
                    SimpsonsCharacter[].class);
            List<SimpsonsCharacter> characters = Arrays.stream(response).filter(c -> {
                var fullName = c.getName();
                return fullName.toLowerCase().contains(characterName.toLowerCase());
            }).collect(Collectors.toList());

            if (characters.isEmpty()) {
                throw new IllegalArgumentException("No existe ese personaje");
            }

            return simpsonsResponseToEntity(characters.get(0));
        } catch (RestClientException ex) {
            System.out.println(ex.getMessage());
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    private CharacterEntity simpsonsResponseToEntity(SimpsonsCharacter character) {
        return CharacterEntity.builder()
                .fullName(character.getName())
                .description("")
                .show("SIMPSONS")
                .imageUrl("")
                .build();
    }
}
