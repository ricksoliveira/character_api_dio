package one.digital.innovation.characterapi.mapper;

import one.digital.innovation.characterapi.dto.request.ChampionDTO;
import one.digital.innovation.characterapi.entity.Champion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChampionMapper {

    ChampionMapper INSTANCE = Mappers.getMapper(ChampionMapper.class);

    Champion toModel(ChampionDTO championDTO);

    ChampionDTO toDTO(Champion champion);

}
