package one.digital.innovation.characterapi.service;

import one.digital.innovation.characterapi.dto.request.ChampionDTO;
import one.digital.innovation.characterapi.dto.response.MessageResponseDTO;
import one.digital.innovation.characterapi.entity.Champion;
import one.digital.innovation.characterapi.exception.ChampionNotFoundException;
import one.digital.innovation.characterapi.mapper.ChampionMapper;
import one.digital.innovation.characterapi.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChampionService {

    private final ChampionMapper championMapper = ChampionMapper.INSTANCE;
    private ChampionRepository championRepository;

    @Autowired
    public ChampionService(ChampionRepository championRepository) {
        this.championRepository = championRepository;
    }

    public Champion verifyExistence(Long id) throws ChampionNotFoundException {
        return championRepository.findById(id).orElseThrow(() -> new ChampionNotFoundException(id));
    }

    public MessageResponseDTO createCharacter(ChampionDTO championDTO){
        Champion championToSave = championMapper.toModel(championDTO);
        Champion savedChampion = championRepository.save(championToSave);
        return MessageResponseDTO
                .builder()
                .message("New Champion created successfully!" + " Name: " + savedChampion.getName())
                .build();
    }

    public List<ChampionDTO> listAllChampions() {
        List<Champion> allChampions = championRepository.findAll();
        return allChampions.stream()
                .map(championMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ChampionDTO findChampionById(Long id) throws ChampionNotFoundException {
        Champion champion = this.verifyExistence(id);
        return championMapper.toDTO(champion);
    }

    public void deleteChampion(Long id) throws ChampionNotFoundException {
       this.verifyExistence(id);
        championRepository.deleteById(id);
    }
}
