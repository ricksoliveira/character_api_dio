package one.digital.innovation.characterapi.service;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ChampionService {

    private final ChampionMapper championMapper = ChampionMapper.INSTANCE;
    private ChampionRepository championRepository;

    public MessageResponseDTO createChampion(ChampionDTO championDTO){
        Champion championToSave = championMapper.toModel(championDTO);
        Champion savedChampion = championRepository.save(championToSave);

        return this.createMessageResponse(savedChampion.getId(), "Created new Champion with ID: ");
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

    public MessageResponseDTO updateChampionById(Long id, ChampionDTO championDTO) throws ChampionNotFoundException {

        this.verifyExistence(id);

        Champion championToUpdate = championMapper.toModel(championDTO);
        Champion updatedChampion = championRepository.save(championToUpdate);

        return this.createMessageResponse(updatedChampion.getId(), "Updated Champion with ID: ");
    }

    public void deleteChampion(Long id) throws ChampionNotFoundException {
        this.verifyExistence(id);
        championRepository.deleteById(id);
    }

    private Champion verifyExistence(Long id) throws ChampionNotFoundException {
        return championRepository.findById(id).orElseThrow(() -> new ChampionNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }

}
