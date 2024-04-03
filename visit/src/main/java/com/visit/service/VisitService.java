package com.visit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import com.visit.dao.VisitDao;
import com.visit.dto.VisitDto;
import com.visit.entity.Visit;
import com.visit.mapper.VisitMapper;
import com.visit.mapper.VisitMapperResolver;

import jakarta.validation.Valid;

/**
 * Visitservice which handles creating and getting v
 */
@Service
public class VisitService {

	@Autowired
	public VisitDao dao;

	@Autowired
	private VisitMapper visitMapper;

	/**
	 * create Visit
	 * @return Visit Entity
	 * @Request Visit Dto
	 */
	public ResponseEntity<List<VisitDto>> create(@Valid @ModelAttribute @RequestBody List<VisitDto> dto) {
		List<Visit> savedVisits = dao.create(visitMapper.convertToEntity(dto));
		List<VisitDto> visitDto = visitMapper.convertToDto(savedVisits);
		return new ResponseEntity<List<VisitDto>>(visitDto, HttpStatus.CREATED);
	}

	/**
	 * method will fetch list of all Visits
	 * 
	 * @return List of Visits
	 */
	public ResponseEntity<List<VisitDto>> getAll() {
		List<Visit> allVisits = dao.getAllVisits();
		List<VisitDto> patlist = visitMapper.convertToDto(allVisits);
		return new ResponseEntity<List<VisitDto>>(patlist, HttpStatus.OK);
	}

	/**
	 * method will fetch VISIT information using Id
	 * 
	 * @return Visit
	 */
	public ResponseEntity<VisitDto> getById(Integer id) {
		Visit visit = dao.findById(id);
		VisitDto visitDto = visitMapper.convertToDto(visit);
		return new ResponseEntity<>(visitDto, HttpStatus.OK);
	}

	public ResponseEntity<VisitDto> update(@Valid VisitDto dto) {
		Visit mapedVisit = visitMapper.map(dto);
		VisitDto visitDTO = visitMapper.convertToDto(dao.update(mapedVisit));
		return new ResponseEntity<>(visitDTO, HttpStatus.OK);
	}

}
