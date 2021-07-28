package one.digital.innovation.characterapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Specialization {

    WARRIOR("Warrior"),
    PALADIN("Paladin"),
    HUNTER("Hunter"),
    MAGE("Mage"),
    PRIEST("Priest");

    private final String specialization;
}
