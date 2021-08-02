package one.digital.innovation.characterapi.utils;

import one.digital.innovation.characterapi.dto.request.SkillDTO;
import one.digital.innovation.characterapi.entity.Skill;

public class SkillUtils {

    private static final long PHONE_ID = 1L;
    private static final String NAME = "Virar ovelha";

    public static SkillDTO createFakeDTO() {
        return SkillDTO.builder()
                .name(NAME)
                .build();
    }

    public static Skill createFakeEntity() {
        return Skill.builder()
                .id(PHONE_ID)
                .name(NAME)
                .build();
    }

}
