package com.github.carloscontrerasruiz.Repository.repository;

import com.github.carloscontrerasruiz.Repository.entity.CharacterEntity;

public interface CharacterRepository {
    CharacterEntity getCharacter(String characterName);
}
