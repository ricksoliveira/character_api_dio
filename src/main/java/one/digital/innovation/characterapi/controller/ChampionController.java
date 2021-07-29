package one.digital.innovation.characterapi.controller;

import one.digital.innovation.characterapi.dto.MessageResponseDTO;
import one.digital.innovation.characterapi.entity.Champion;
import one.digital.innovation.characterapi.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/champion")
public class ChampionController {

    ChampionService championService;

    @Autowired
    public ChampionController(ChampionService championService) {
        this.championService = championService;
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public MessageResponseDTO createCharacter(@RequestBody Champion champion){
//        return championService.createCharacter(champion);
//    }

    @GetMapping
    public String textTest(){
        return "API TEST";
    }
}
