package one.digital.innovation.characterapi.service;

import lombok.AllArgsConstructor;
import one.digital.innovation.characterapi.dto.request.SkillDTO;
import one.digital.innovation.characterapi.dto.response.MessageResponseDTO;
import one.digital.innovation.characterapi.entity.Skill;
import one.digital.innovation.characterapi.exception.SkillNotFoundException;
import one.digital.innovation.characterapi.mapper.SkillMapper;
import one.digital.innovation.characterapi.repository.SkillRepository;
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
public class SkillService {

    private final SkillMapper skillMapper = SkillMapper.INSTANCE;
    private SkillRepository skillRepository;

    /**
     * <p>The method createSkill() below creates a new Skill in the database.</p>
     * <p>It requires a DTO from parameter which is converted to a model using toModel method in the Mapper class.</p>
     * <p>The object converted to model is saved using the repository interface method save().</p>
     * <p>It then returns a message DTO with the new Skill ID.</p>
     */
    public MessageResponseDTO createSkill(SkillDTO skillDTO){
        Skill skillToSave = skillMapper.toModel(skillDTO);
        Skill savedSkill = skillRepository.save(skillToSave);
        return this.createMessageResponse(savedSkill.getId(), "Created new Skill with ID: ");
    }

    /**
     * <p>The method listAllSkills() lists all Skills from the database.</p>
     * <p>The method findAll() from the repository interface returns a list of all instances.</p>
     * <p>which then are added to a list and converted in a for each for DTO.</p>
     */
    public List<SkillDTO> listAllSkills() {
        List<Skill> allSkills = skillRepository.findAll();
        return allSkills.stream()
                .map(skillMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * <p>The method findSkillById() returns the instance with that Id.</p>
     * <p>Using the private method from this class verifyExistence().</p>
     */
    public SkillDTO findSkillById(Long id) throws SkillNotFoundException {
        Skill skill = this.verifyExistence(id);
        return skillMapper.toDTO(skill);
    }

    /**
     * <p>This method updates an instance from the database if found any with that Id.</p>
     * <p>If existence is verified, the process is the same for creating a new Skill.</p>
     */
    public MessageResponseDTO updateSkillById(Long id, SkillDTO skillDTO) throws SkillNotFoundException {
        this.verifyExistence(id);
        Skill skillToUpdate = skillMapper.toModel(skillDTO);
        Skill updatedSkill = skillRepository.save(skillToUpdate);
        return this.createMessageResponse(updatedSkill.getId(), "Updated Skill with ID: ");
    }

    /**
     * <p>This method deletes an instance from the database if found any with that Id.</p>
     * <p>If existence is verified, that Skill is deleted.</p>
     */
    public void deleteSkill(Long id) throws SkillNotFoundException {
        this.verifyExistence(id);
        skillRepository.deleteById(id);
    }

    /**
     * <h1>Below are the private methods used within this class only.</h>
     * <br><br>
     *
     *
     *
     * <p>This method verify if there is a Profession with that specific Id passed on parameter.</p>
     */
    private Skill verifyExistence(Long id) throws SkillNotFoundException {
        return skillRepository.findById(id).orElseThrow(() -> new SkillNotFoundException(id));
    }

    /**
     * <p>This method creates the message when creating, updating or deleting a Skill.</p>
     */
    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }

}
