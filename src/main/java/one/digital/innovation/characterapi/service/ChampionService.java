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

/**
 * <p>The Service class uses an instance of the Repository interface, it calls the method and</p>
 * <p>returns the result to the caller (Controller class) which can be shown, for instance, in a View.</p>
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ChampionService {

    private final ChampionMapper championMapper = ChampionMapper.INSTANCE;
    private ChampionRepository championRepository;

    /**
     * <p>The method createChampion() below creates a new Skill in the database.</p>
     * <p>It requires a DTO from parameter which is converted to a model using toModel method in the Mapper class.</p>
     * <p>The object converted to model is saved using the repository interface method save().</p>
     * <p>It then returns a message DTO with the new Champion ID.</p>
     */
    public MessageResponseDTO createChampion(ChampionDTO championDTO){
        Champion championToSave = championMapper.toModel(championDTO);
        Champion savedChampion = championRepository.save(championToSave);
        return this.createMessageResponse(savedChampion.getId(), "Created new Champion with ID: ");
    }

    /**
     * <p>The method listAllChampions() lists all Champions from the database.</p>
     * <p>The method findAll() from the repository interface returns a list of all instances.</p>
     * <p>which then are added to a list and converted in a for each for DTO.</p>
     */
    public List<ChampionDTO> listAllChampions() {
        List<Champion> allChampions = championRepository.findAll();
        return allChampions.stream()
                .map(championMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * <p>The method findChampionById() returns the instance with that Id.</p>
     * <p>Using the private method from this class verifyExistence().</p>
     */
    public ChampionDTO findChampionById(Long id) throws ChampionNotFoundException {
        Champion champion = this.verifyExistence(id);
        return championMapper.toDTO(champion);
    }

    /**
     * <p>This method updates an instance from the database if found any with that Id.</p>
     * <p>If existence is verified, the process is the same for creating a new Champion.</p>
     */
    public MessageResponseDTO updateChampionById(Long id, ChampionDTO championDTO) throws ChampionNotFoundException {
        this.verifyExistence(id);
        Champion championToUpdate = championMapper.toModel(championDTO);
        Champion updatedChampion = championRepository.save(championToUpdate);
        return this.createMessageResponse(updatedChampion.getId(), "Updated Champion with ID: ");
    }

    /**
     * <p>This method deletes an instance from the database if found any with that Id.</p>
     * <p>If existence is verified, that Champion is deleted.</p>
     */
    public void deleteChampion(Long id) throws ChampionNotFoundException {
        this.verifyExistence(id);
        championRepository.deleteById(id);
    }

    /**
     * <h1>Below are the private methods used within this class only.</h>
     * <br><br>
     *
     *
     *
     * <p>This method verify if there is a Champion with that specific Id passed on parameter.</p>
     */
    private Champion verifyExistence(Long id) throws ChampionNotFoundException {
        return championRepository.findById(id).orElseThrow(() -> new ChampionNotFoundException(id));
    }

    /**
     * <p>This method creates the message when creating, updating or deleting a Champion.</p>
     */
    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }

}
