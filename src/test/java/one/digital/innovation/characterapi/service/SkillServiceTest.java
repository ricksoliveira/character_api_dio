package one.digital.innovation.characterapi.service;

import one.digital.innovation.characterapi.dto.request.SkillDTO;
import one.digital.innovation.characterapi.dto.response.MessageResponseDTO;
import one.digital.innovation.characterapi.entity.Skill;
import one.digital.innovation.characterapi.repository.SkillRepository;
import one.digital.innovation.characterapi.utils.SkillUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class SkillServiceTest {

    @Mock
    private SkillRepository skillRepository;

    @InjectMocks
    private SkillService skillService;

    @Test
    void testGivenSkillDTOThenReturnSavedMessage() {
        SkillDTO skillDTO = SkillUtils.createFakeDTO();
        Skill expectedSavedSkill = SkillUtils.createFakeEntity();

        Mockito.when(skillRepository.save(any(Skill.class))).thenReturn(expectedSavedSkill);

        MessageResponseDTO expectedSuccessMessage =  MessageResponseDTO.builder()
                .message("Created new Skill with ID: " + expectedSavedSkill.getId())
                .build();

        MessageResponseDTO successMessage = skillService.createSkill(skillDTO);

        Assertions.assertEquals(expectedSuccessMessage, successMessage);
    }

}
