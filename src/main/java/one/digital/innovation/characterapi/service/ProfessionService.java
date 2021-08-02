package one.digital.innovation.characterapi.service;

import lombok.AllArgsConstructor;
import one.digital.innovation.characterapi.dto.request.ProfessionDTO;
import one.digital.innovation.characterapi.dto.response.MessageResponseDTO;
import one.digital.innovation.characterapi.entity.Profession;
import one.digital.innovation.characterapi.exception.ProfessionNotFoundException;
import one.digital.innovation.characterapi.mapper.ProfessionMapper;
import one.digital.innovation.characterapi.repository.ProfessionRepository;
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
public class ProfessionService {

    private final ProfessionMapper professionMapper = ProfessionMapper.INSTANCE;
    private ProfessionRepository professionRepository;

    /**
     * <p>The method createProfession() below creates a new Skill in the database.</p>
     * <p>It requires a DTO from parameter which is converted to a model using toModel method in the Mapper class.</p>
     * <p>The object converted to model is saved using the repository interface method save().</p>
     * <p>It then returns a message DTO with the new Profession ID.</p>
     */
    public MessageResponseDTO createProfession(ProfessionDTO professionDTO){
        Profession professionToSave = professionMapper.toModel(professionDTO);
        Profession savedProfession = professionRepository.save(professionToSave);
        return this.createMessageResponse(savedProfession.getId(), "Created new Profession with ID: ");
    }

    /**
     * <p>The method listAllProfessions() lists all Professions from the database.</p>
     * <p>The method findAll() from the repository interface returns a list of all instances.</p>
     * <p>which then are added to a list and converted in a for each for DTO.</p>
     */
    public List<ProfessionDTO> listAllProfessions() {
        List<Profession> allProfessions = professionRepository.findAll();
        return allProfessions.stream()
                .map(professionMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * <p>The method findProfessionById() returns the instance with that Id.</p>
     * <p>Using the private method from this class verifyExistence().</p>
     */
    public ProfessionDTO findProfessionById(Long id) throws ProfessionNotFoundException {
        Profession profession = this.verifyExistence(id);
        return professionMapper.toDTO(profession);
    }

    /**
     * <p>This method updates an instance from the database if found any with that Id.</p>
     * <p>If existence is verified, the process is the same for creating a new Profession.</p>
     */
    public MessageResponseDTO updateProfessionById(Long id, ProfessionDTO professionDTO) throws ProfessionNotFoundException {
        this.verifyExistence(id);
        Profession professionToUpdate = professionMapper.toModel(professionDTO);
        Profession updatedProfession = professionRepository.save(professionToUpdate);
        return this.createMessageResponse(updatedProfession.getId(), "Updated Profession with ID: ");
    }

    /**
     * <p>This method deletes an instance from the database if found any with that Id.</p>
     * <p>If existence is verified, that Profession is deleted.</p>
     */
    public void deleteProfession(Long id) throws ProfessionNotFoundException {
        this.verifyExistence(id);
        professionRepository.deleteById(id);
    }

    /**
     * <h1>Below are the private methods used within this class only.</h>
     * <br><br>
     *
     *
     *
     * <p>This method verify if there is a Profession with that specific Id passed on parameter.</p>
     */
    private Profession verifyExistence(Long id) throws ProfessionNotFoundException {
        return professionRepository.findById(id).orElseThrow(() -> new ProfessionNotFoundException(id));
    }

    /**
     * <p>This method creates the message when creating, updating or deleting a Profession.</p>
     */
    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }

}
