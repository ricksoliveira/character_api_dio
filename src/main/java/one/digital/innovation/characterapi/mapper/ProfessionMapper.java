package one.digital.innovation.characterapi.mapper;

import one.digital.innovation.characterapi.dto.request.ProfessionDTO;
import one.digital.innovation.characterapi.entity.Profession;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessionMapper {

    ProfessionMapper INSTANCE = Mappers.getMapper(ProfessionMapper.class);

    Profession toModel(ProfessionDTO professionDTO);

    ProfessionDTO toDTO(Profession profession);
}
