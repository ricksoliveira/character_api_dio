package one.digital.innovation.characterapi.service;

import one.digital.innovation.characterapi.dto.request.ChampionDTO;
import one.digital.innovation.characterapi.dto.response.MessageResponseDTO;
import one.digital.innovation.characterapi.entity.Champion;
import one.digital.innovation.characterapi.mapper.ChampionMapper;
import one.digital.innovation.characterapi.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChampionService {

    private final ChampionMapper championMapper = ChampionMapper.INSTANCE;
    private ChampionRepository championRepository;

    @Autowired
    public ChampionService(ChampionRepository championRepository) {
        this.championRepository = championRepository;
    }

    public MessageResponseDTO createCharacter(ChampionDTO championDTO){
        Champion championToSave = championMapper.toModel(championDTO);
        Champion savedChampion = championRepository.save(championToSave);
        return MessageResponseDTO
                .builder()
                .message("New Champion created successfully!" + " Name: " + savedChampion.getName())
                .build();
    }
}
