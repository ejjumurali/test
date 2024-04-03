package com.visit.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.visit.dao.VisitDao;
import com.visit.entity.Visit;
import com.visit.repository.VisitRepository;

@Component
public class VisitDaoImpl implements VisitDao {

	@Autowired
	public VisitRepository visitRepository;


	@Override
	public List<Visit> getAllVisits() {
		return visitRepository.findAll();
	}

	@Override
	public List<Visit> create(List<Visit> dto) {
		List<Visit> visits = visitRepository.saveAll(dto);
		return visits;
	}

	@Override
	public Visit findById(Integer id) {
		Optional<Visit> visit = visitRepository.findById(id);
		if (visit.isPresent()) {
			return visit.get();
		} else {
			return null;
		}
	}

	@Override
	public Visit update(Visit visit) {
		return visitRepository.saveAndFlush(visit);
	}

}
