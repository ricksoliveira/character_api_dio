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
@RestController
@RequestMapping("/api/v1/skill")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SkillController {

    SkillService skillService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createSkill(@RequestBody @Valid SkillDTO skillDTO){
        return skillService.createSkill(skillDTO);
    }

    @GetMapping
    public List<SkillDTO> listAllSkills(){
        return skillService.listAllSkills();
    }

    @GetMapping("/{id}")
    public SkillDTO findSkillById(@PathVariable Long id) throws SkillNotFoundException {
        return skillService.findSkillById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateSkillById(@PathVariable Long id, @RequestBody SkillDTO skillDTO) throws SkillNotFoundException {
        return skillService.updateSkillById(id, skillDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSkill(@PathVariable Long id) throws SkillNotFoundException {
        skillService.deleteSkill(id);
    }

}
