package com.github.carloscontrerasruiz.Repository.repository.simpsons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpsonsCharacter {
    private Long id;
    private String name;
    private String normalizedName;
    private String gender;
}
