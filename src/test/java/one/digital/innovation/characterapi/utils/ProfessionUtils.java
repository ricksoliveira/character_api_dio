package one.digital.innovation.characterapi.utils;

import one.digital.innovation.characterapi.dto.request.ProfessionDTO;
import one.digital.innovation.characterapi.entity.Profession;

public class ProfessionUtils {

    private static final long PHONE_ID = 1L;
    private static final String NAME = "Cooking";

    public static ProfessionDTO createFakeDTO() {
        return ProfessionDTO.builder()
                .name(NAME)
                .build();
    }

    public static Profession createFakeEntity() {
        return Profession.builder()
                .id(PHONE_ID)
                .name(NAME)
                .build();
    }

}
