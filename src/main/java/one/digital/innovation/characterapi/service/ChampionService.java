package one.digital.innovation.characterapi.service;

import one.digital.innovation.characterapi.dto.MessageResponseDTO;
import one.digital.innovation.characterapi.entity.Champion;
import one.digital.innovation.characterapi.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChampionService {

    private ChampionRepository championRepository;

    @Autowired
    public ChampionService(ChampionRepository championRepository) {
        this.championRepository = championRepository;
    }

    public MessageResponseDTO createCharacter(Champion champion){
        Champion savedChampion = championRepository.save(champion);
        return MessageResponseDTO
                .builder()
                .message("New Champion created successfully! " + "Name: " + savedChampion.getName())
                .build();
    }
}
