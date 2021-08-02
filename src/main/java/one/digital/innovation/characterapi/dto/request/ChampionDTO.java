package one.digital.innovation.characterapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digital.innovation.characterapi.enums.Specialization;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * <p>The DTO class stands for Data Transfer Object</p>
 * <p>and it is responsible for transferring data between the Controller and Service layers</p>
 * <p>as well as having some validations.</p>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChampionDTO {

    private Long id;

    /**
     * <p>The name of each Champion must be between 5 and 12 characters long.</p>
     */
    @NotEmpty
    @Size(min = 5, max = 12)
    private String name;

    @NotEmpty
    private Long level;

    @Enumerated(EnumType.STRING)
    private Specialization charSpec;

    private List<ProfessionDTO> professions;
    private List<SkillDTO> skills;

}
