package one.digital.innovation.characterapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digital.innovation.characterapi.entity.Profession;
import one.digital.innovation.characterapi.entity.Skill;
import one.digital.innovation.characterapi.enums.Specialization;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChampionDTO {

    private Long id;

    @NotEmpty
    @Size(min = 5, max = 12)
    private String name;

    @NotEmpty
    private Long level;

    @Enumerated(EnumType.STRING)
    private Specialization charSpec;

    private List<Profession> professions;
    private List<Skill> skills;

}
