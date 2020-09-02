package com.mindex.challenge.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.CompensateRepository;
import com.mindex.challenge.data.Compensate;
import com.mindex.challenge.service.CompensateService;

@Service
public class CompensateServiceImpl implements CompensateService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompensateServiceImpl.class);
	
	@Autowired
	private CompensateRepository compensateRepository;

	@Override
	public Compensate read(String id) {
		LOG.debug("Reading Compensate");
		
		Compensate compensate = compensateRepository.findByEmployeeId(id);
		
		if (compensate == null) {
			throw new RuntimeException("Invalid employeeId: " + id);
		}
		
		return compensate;
	}

	@Override
	public Compensate create(Compensate compensate) {
		LOG.debug("Creating Compensate");
		compensateRepository.insert(compensate);
		return compensate;
	}

}
