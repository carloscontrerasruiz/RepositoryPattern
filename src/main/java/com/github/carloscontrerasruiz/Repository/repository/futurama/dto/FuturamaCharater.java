package com.github.carloscontrerasruiz.Repository.repository.futurama.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FuturamaCharater {
    private Name name;
    private CharacterImage images;
    private String gender;
    private String species;
    private String homePlanet;
    private String occupation;
    private String[] sayings;
    private Long id;
    private String age;
}

