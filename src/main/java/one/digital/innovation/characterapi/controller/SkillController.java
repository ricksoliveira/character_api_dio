package one.digital.innovation.characterapi.controller;

import lombok.AllArgsConstructor;
import one.digital.innovation.characterapi.dto.request.SkillDTO;
import one.digital.innovation.characterapi.dto.response.MessageResponseDTO;
import one.digital.innovation.characterapi.exception.SkillNotFoundException;
import one.digital.innovation.characterapi.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>The controller class is responsible for mapping the endpoints and requests types</p>
 * <p>Each of them uses an instance of this class equivalent of the Service class, which</p>
 * <p>communicates directly with its Repository responsible for calling the desired methods.</p>
 */
@RestController
@RequestMapping("/api/v1/skill")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SkillController {

    SkillService skillService;

    /**
     * <p>Method that creates a new Skill calling the Service class</p>
     * <p>and returns a Message Response.</p>
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createSkill(@RequestBody @Valid SkillDTO skillDTO){
        return skillService.createSkill(skillDTO);
    }

    /**
     * <p>Method that lists all existing Skills</p>
     * <p>and returns a list of all Skills in the database.</p>
     */
    @GetMapping
    public List<SkillDTO> listAllSkills(){
        return skillService.listAllSkills();
    }

    /**
     * <p>Method that a Skill by its Id</p>
     * <p>and if no Skill is found, throws an exception within the SkillNotFound class.</p>
     */
    @GetMapping("/{id}")
    public SkillDTO findSkillById(@PathVariable Long id) throws SkillNotFoundException {
        return skillService.findSkillById(id);
    }

    /**
     * <p>Method that updates the fields of a Skill by its Id</p>
     * <p>and if no Skill is found, throws an exception within the SkillNotFound class.</p>
     */
    @PutMapping("/{id}")
    public MessageResponseDTO updateSkillById(@PathVariable Long id, @RequestBody SkillDTO skillDTO) throws SkillNotFoundException {
        return skillService.updateSkillById(id, skillDTO);
    }

    /**
     * <p>Method that deletes a Skill by its Id</p>
     * <p>and if no Skill is found, throws an exception within the SkillNotFound class.</p>
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSkill(@PathVariable Long id) throws SkillNotFoundException {
        skillService.deleteSkill(id);
    }

}
