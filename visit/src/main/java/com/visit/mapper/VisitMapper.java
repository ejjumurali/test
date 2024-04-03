package com.visit.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.visit.dto.VisitDto;
import com.visit.entity.Visit;

@Mapper(componentModel = "spring", uses = { VisitMapperResolver.class })
public interface VisitMapper {

	List<Visit> convertToEntity(List<VisitDto> dto);

	VisitDto convertToDto(Visit visit);

	List<VisitDto> convertToDto(List<Visit> visits);

	Visit map(VisitDto visitDto);
}
