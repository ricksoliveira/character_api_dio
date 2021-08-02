package one.digital.innovation.characterapi.controller;

import lombok.AllArgsConstructor;
import one.digital.innovation.characterapi.dto.request.ProfessionDTO;
import one.digital.innovation.characterapi.dto.response.MessageResponseDTO;
import one.digital.innovation.characterapi.exception.ProfessionNotFoundException;
import one.digital.innovation.characterapi.service.ProfessionService;
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
@RequestMapping("/api/v1/profession")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfessionController {

    ProfessionService professionService;

    /**
     * <p>Method that creates a new Profession calling the Service class</p>
     * <p>and returns a Message Response.</p>
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createProfession(@RequestBody @Valid ProfessionDTO professionDTO){
        return professionService.createProfession(professionDTO);
    }

    /**
     * <p>Method that lists all existing Professions</p>
     * <p>and returns a list of all Professions in the database.</p>
     */
    @GetMapping
    public List<ProfessionDTO> listAllProfessions(){
        return professionService.listAllProfessions();
    }

    /**
     * <p>Method that a Profession by its Id</p>
     * <p>and if no Profession is found, throws an exception within the ProfessionNotFound class.</p>
     */
    @GetMapping("/{id}")
    public ProfessionDTO findProfessionById(@PathVariable Long id) throws ProfessionNotFoundException {
        return professionService.findProfessionById(id);
    }

    /**
     * <p>Method that updates the fields of a Profession by its Id</p>
     * <p>and if no Profession is found, throws an exception within the ProfessionNotFound class.</p>
     */
    @PutMapping("/{id}")
    public MessageResponseDTO updateProfessionById(@PathVariable Long id, @RequestBody ProfessionDTO professionDTO) throws ProfessionNotFoundException {
        return professionService.updateProfessionById(id, professionDTO);
    }

    /**
     * <p>Method that deletes a Profession by its Id</p>
     * <p>and if no Profession is found, throws an exception within the ProfessionNotFound class.</p>
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfession(@PathVariable Long id) throws ProfessionNotFoundException {
        professionService.deleteProfession(id);
    }

}
