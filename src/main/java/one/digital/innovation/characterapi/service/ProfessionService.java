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

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfessionService {

    private final ProfessionMapper professionMapper = ProfessionMapper.INSTANCE;
    private ProfessionRepository professionRepository;

    public MessageResponseDTO createProfession(ProfessionDTO professionDTO){
        Profession professionToSave = professionMapper.toModel(professionDTO);
        Profession savedProfession = professionRepository.save(professionToSave);

        return this.createMessageResponse(savedProfession.getId(), "Created new Profession with ID: ");
    }

    public List<ProfessionDTO> listAllProfessions() {
        List<Profession> allProfessions = professionRepository.findAll();
        return allProfessions.stream()
                .map(professionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProfessionDTO findProfessionById(Long id) throws ProfessionNotFoundException {
        Profession profession = this.verifyExistence(id);
        return professionMapper.toDTO(profession);
    }

    public MessageResponseDTO updateProfessionById(Long id, ProfessionDTO professionDTO) throws ProfessionNotFoundException {

        this.verifyExistence(id);

        Profession professionToUpdate = professionMapper.toModel(professionDTO);
        Profession updatedProfession = professionRepository.save(professionToUpdate);

        return this.createMessageResponse(updatedProfession.getId(), "Updated Profession with ID: ");
    }

    public void deleteProfession(Long id) throws ProfessionNotFoundException {
        this.verifyExistence(id);
        professionRepository.deleteById(id);
    }

    private Profession verifyExistence(Long id) throws ProfessionNotFoundException {
        return professionRepository.findById(id).orElseThrow(() -> new ProfessionNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }

}
