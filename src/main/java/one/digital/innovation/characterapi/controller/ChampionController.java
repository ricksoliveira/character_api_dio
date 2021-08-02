package one.digital.innovation.characterapi.controller;

import lombok.AllArgsConstructor;
import one.digital.innovation.characterapi.dto.request.ChampionDTO;
import one.digital.innovation.characterapi.dto.response.MessageResponseDTO;
import one.digital.innovation.characterapi.exception.ChampionNotFoundException;
import one.digital.innovation.characterapi.service.ChampionService;
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
@RequestMapping("/api/v1/champion")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ChampionController {

    ChampionService championService;

    /**
     * <p>Method that creates a new Champion calling the Service class</p>
     * <p>and returns a Message Response.</p>
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createChampion(@RequestBody @Valid ChampionDTO championDTO){
        return championService.createChampion(championDTO);
    }

    /**
     * <p>Method that lists all existing Champions</p>
     * <p>and returns a list of all Champions in the database.</p>
     */
    @GetMapping
    public List<ChampionDTO> listAllChampions(){
        return championService.listAllChampions();
    }

    /**
     * <p>Method that a Champion by its Id</p>
     * <p>and if no Champion is found, throws an exception within the ChampionNotFound class.</p>
     */
    @GetMapping("/{id}")
    public ChampionDTO findChampionById(@PathVariable Long id) throws ChampionNotFoundException {
        return championService.findChampionById(id);
    }

    /**
     * <p>Method that updates the fields of a Champion by its Id</p>
     * <p>and if no Champion is found, throws an exception within the ChampionNotFound class.</p>
     */
    @PutMapping("/{id}")
    public MessageResponseDTO updateChampionById(@PathVariable Long id, @RequestBody ChampionDTO championDTO) throws ChampionNotFoundException {
        return championService.updateChampionById(id, championDTO);
    }

    /**
     * <p>Method that deletes a Champion by its Id</p>
     * <p>and if no Champion is found, throws an exception within the ChampionNotFound class.</p>
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteChampion(@PathVariable Long id) throws ChampionNotFoundException {
        championService.deleteChampion(id);
    }
}
