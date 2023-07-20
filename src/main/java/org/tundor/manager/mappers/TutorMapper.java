package org.tundor.manager.mappers;

import org.domain.models.userRoles.Tutor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.tundor.data.DTOs.user_roles.TutorDTO;

@Mapper
public interface TutorMapper {
    TutorMapper INSTANCE = Mappers.getMapper(TutorMapper.class);

    @Mapping(target = "info", source = "info")
    Tutor toDomain(TutorDTO tutor);

    @Mapping(target = "info", source = "info")
    TutorDTO toDTO(Tutor tutor);

}
