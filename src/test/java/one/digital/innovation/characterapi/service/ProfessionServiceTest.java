package one.digital.innovation.characterapi.service;

import one.digital.innovation.characterapi.dto.request.ProfessionDTO;
import one.digital.innovation.characterapi.dto.response.MessageResponseDTO;
import one.digital.innovation.characterapi.entity.Profession;
import one.digital.innovation.characterapi.repository.ProfessionRepository;
import one.digital.innovation.characterapi.utils.ProfessionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ProfessionServiceTest {

    @Mock
    private ProfessionRepository professionRepository;

    @InjectMocks
    private ProfessionService professionService;

    @Test
    void testGivenProfessionDTOThenReturnSavedMessage() {
        ProfessionDTO professionDTO = ProfessionUtils.createFakeDTO();
        Profession expectedSavedProfession = ProfessionUtils.createFakeEntity();

        Mockito.when(professionRepository.save(any(Profession.class))).thenReturn(expectedSavedProfession);

        MessageResponseDTO expectedSuccessMessage =  MessageResponseDTO.builder()
                .message("Created new Profession with ID: " + expectedSavedProfession.getId())
                .build();

        MessageResponseDTO successMessage = professionService.createProfession(professionDTO);

        Assertions.assertEquals(expectedSuccessMessage, successMessage);
    }

}
