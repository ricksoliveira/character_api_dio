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

@RestController
@RequestMapping("/api/v1/champion")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ChampionController {

    ChampionService championService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createChampion(@RequestBody @Valid ChampionDTO championDTO){
        return championService.createChampion(championDTO);
    }

    @GetMapping
    public List<ChampionDTO> listAllChampions(){
        return championService.listAllChampions();
    }

    @GetMapping("/{id}")
    public ChampionDTO findChampionById(@PathVariable Long id) throws ChampionNotFoundException {
        return championService.findChampionById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateChampionById(@PathVariable Long id, @RequestBody ChampionDTO championDTO) throws ChampionNotFoundException {
        return championService.updateChampionById(id, championDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteChampion(@PathVariable Long id) throws ChampionNotFoundException {
        championService.deleteChampion(id);
    }
}
