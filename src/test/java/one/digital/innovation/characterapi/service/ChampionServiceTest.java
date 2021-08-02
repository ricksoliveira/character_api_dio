package one.digital.innovation.characterapi.service;

import one.digital.innovation.characterapi.dto.request.ChampionDTO;
import one.digital.innovation.characterapi.dto.response.MessageResponseDTO;
import one.digital.innovation.characterapi.entity.Champion;
import one.digital.innovation.characterapi.repository.ChampionRepository;
import one.digital.innovation.characterapi.utils.ChampionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ChampionServiceTest {

    @Mock
    private ChampionRepository championRepository;

    @InjectMocks
    private ChampionService championService;

    @Test
    void testGivenChampionDTOThenReturnSavedMessage() {
        ChampionDTO championDTO = ChampionUtils.createFakeDTO();
        Champion expectedSavedChampion = ChampionUtils.createFakeEntity();

        Mockito.when(championRepository.save(any(Champion.class))).thenReturn(expectedSavedChampion);

        MessageResponseDTO expectedSuccessMessage =  MessageResponseDTO.builder()
                .message("Created new Champion with ID: " + expectedSavedChampion.getId())
                .build();

        MessageResponseDTO successMessage = championService.createChampion(championDTO);

        Assertions.assertEquals(expectedSuccessMessage, successMessage);
    }
}
