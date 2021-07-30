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

@RestController
@RequestMapping("/api/v1/profession")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfessionController {

    ProfessionService professionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createProfession(@RequestBody @Valid ProfessionDTO professionDTO){
        return professionService.createProfession(professionDTO);
    }

    @GetMapping
    public List<ProfessionDTO> listAllProfessions(){
        return professionService.listAllProfessions();
    }

    @GetMapping("/{id}")
    public ProfessionDTO findProfessionById(@PathVariable Long id) throws ProfessionNotFoundException {
        return professionService.findProfessionById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateProfessionById(@PathVariable Long id, @RequestBody ProfessionDTO professionDTO) throws ProfessionNotFoundException {
        return professionService.updateProfessionById(id, professionDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfession(@PathVariable Long id) throws ProfessionNotFoundException {
        professionService.deleteProfession(id);
    }

}
