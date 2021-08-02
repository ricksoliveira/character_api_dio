package one.digital.innovation.characterapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>This enum class is a list of options which an attribute can be.</p>
 * <p>In this case are the available options for the Character Specialization</p>
 * <p>of each Champion.</p>
 */
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
