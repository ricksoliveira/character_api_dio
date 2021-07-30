package one.digital.innovation.characterapi.mapper;

import one.digital.innovation.characterapi.dto.request.SkillDTO;
import one.digital.innovation.characterapi.entity.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SkillMapper {

    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);

    Skill toModel(SkillDTO skillDTO);

    SkillDTO toDTO(Skill skill);
}
