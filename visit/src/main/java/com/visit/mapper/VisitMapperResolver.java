package com.visit.mapper;

import java.util.Optional;

import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.visit.entity.Visit;
import com.visit.dto.VisitDto;
import com.visit.repository.VisitRepository;

@Component
public class VisitMapperResolver {
	@Autowired
	private VisitRepository userRepository;
	
	@ObjectFactory
    public Optional<Visit> resolve(VisitDto dto, @TargetType Class<Visit> type) {
        return dto != null && dto.getId() != null ? userRepository.findById(dto.getId()) : Optional.empty();
    }
}
