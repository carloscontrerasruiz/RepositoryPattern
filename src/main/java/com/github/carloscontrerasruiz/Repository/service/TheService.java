package com.github.carloscontrerasruiz.Repository.service;

import com.github.carloscontrerasruiz.Repository.entity.CharacterEntity;
import com.github.carloscontrerasruiz.Repository.factory.TheFactory;
import com.github.carloscontrerasruiz.Repository.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheService {

    @Autowired
    private TheFactory factory;

    public CharacterEntity getCharacterInfo(String characterName, String identifier) {
        CharacterRepository characterRepo = factory.getRightRepo(identifier);
        CharacterEntity character = characterRepo.getCharacter(characterName);
        return character;
    }
}
