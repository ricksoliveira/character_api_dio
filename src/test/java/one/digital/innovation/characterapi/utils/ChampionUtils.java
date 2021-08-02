package one.digital.innovation.characterapi.utils;

import one.digital.innovation.characterapi.dto.request.ChampionDTO;
import one.digital.innovation.characterapi.entity.Champion;
import one.digital.innovation.characterapi.enums.Specialization;

import java.util.Collections;

public class ChampionUtils {

    private static final long CHAMPION_ID = 1L;
    private static final String NAME = "HenriqueTest";
    private static final long LEVEL = 1L;
    private static final Specialization CHAR_SPEC = Specialization.WARRIOR;

    public static ChampionDTO createFakeDTO() {
        return ChampionDTO.builder()
                .name(NAME)
                .level(LEVEL)
                .charSpec(CHAR_SPEC)
                .professions(Collections.singletonList(ProfessionUtils.createFakeDTO()))
                .skills(Collections.singletonList(SkillUtils.createFakeDTO()))
                .build();
    }

    public static Champion createFakeEntity() {
        return Champion.builder()
                .id(CHAMPION_ID)
                .name(NAME)
                .level(LEVEL)
                .charSpec(CHAR_SPEC)
                .professions(Collections.singletonList(ProfessionUtils.createFakeEntity()))
                .skills(Collections.singletonList(SkillUtils.createFakeEntity()))
                .build();
    }

}
