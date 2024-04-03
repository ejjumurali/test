package com.visit.dao;

import java.util.List;

import com.visit.dto.VisitDto;
import com.visit.entity.Visit;

public interface VisitDao {

	List<Visit> getAllVisits();

	List<Visit> create(List<Visit> dto);

	Visit findById(Integer id);

	Visit update(Visit visit);
}
