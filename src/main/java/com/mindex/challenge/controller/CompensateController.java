package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.Compensate;
import com.mindex.challenge.service.CompensateService;

@RestController
public class CompensateController {
	private static final Logger LOG = LoggerFactory.getLogger(CompensateController.class);
	
	@Autowired
	private CompensateService compensateService;
	
	/**
	 * Post mapping for compensate creation.
	 * It takes compensate object from request body and 
	 * create through compensate service
	 * @param compensate
	 * @return
	 */
	@PostMapping("/compensate")
	public Compensate create(@RequestBody Compensate compensate) {
		LOG.debug("Received compensate create request for [{}]", compensate);
		
		return compensateService.create(compensate);
	}
	
	/**
	 * Get mapping for compensate read.
	 * It takes String id (Employee id) and read through 
	 * compensate service
	 * @param id
	 * @return
	 */
	@GetMapping("/compnesate/{id}")
	public Compensate read(@PathVariable String id) {
		LOG.debug("Received compensate read request for id [{}]", id);
		
		return compensateService.read(id);
	}
}
