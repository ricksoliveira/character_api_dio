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

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SkillService {

    private final SkillMapper skillMapper = SkillMapper.INSTANCE;
    private SkillRepository skillRepository;

    public MessageResponseDTO createSkill(SkillDTO skillDTO){
        Skill skillToSave = skillMapper.toModel(skillDTO);
        Skill savedSkill = skillRepository.save(skillToSave);

        return this.createMessageResponse(savedSkill.getId(), "Created new Skill with ID: ");
    }

    public List<SkillDTO> listAllSkills() {
        List<Skill> allSkills = skillRepository.findAll();
        return allSkills.stream()
                .map(skillMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SkillDTO findSkillById(Long id) throws SkillNotFoundException {
        Skill skill = this.verifyExistence(id);
        return skillMapper.toDTO(skill);
    }

    public MessageResponseDTO updateSkillById(Long id, SkillDTO skillDTO) throws SkillNotFoundException {

        this.verifyExistence(id);

        Skill skillToUpdate = skillMapper.toModel(skillDTO);
        Skill updatedSkill = skillRepository.save(skillToUpdate);

        return this.createMessageResponse(updatedSkill.getId(), "Updated Skill with ID: ");
    }

    public void deleteSkill(Long id) throws SkillNotFoundException {
        this.verifyExistence(id);
        skillRepository.deleteById(id);
    }

    private Skill verifyExistence(Long id) throws SkillNotFoundException {
        return skillRepository.findById(id).orElseThrow(() -> new SkillNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }

}
