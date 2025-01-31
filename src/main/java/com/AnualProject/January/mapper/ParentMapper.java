package com.AnualProject.January.mapper;


import com.AnualProject.January.dto.ParentDto;
import com.AnualProject.January.model.Parent;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ParentMapper {
    Parent toEntity(ParentDto parentDto);
    ParentDto toDto(Parent parent);
    void toUpdateEntity(ParentDto parentDto,@MappingTarget Parent parent);

}
