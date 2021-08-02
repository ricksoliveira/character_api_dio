package one.digital.innovation.characterapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>The DTO class stands for Data Transfer Object</p>
 * <p>and it is responsible for transferring data between the Controller and Service layers.</p>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionDTO {

    private Long id;
    private String name;

}
