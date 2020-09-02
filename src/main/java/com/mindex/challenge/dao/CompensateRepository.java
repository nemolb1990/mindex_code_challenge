package com.mindex.challenge.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mindex.challenge.data.Compensate;

@Repository
public interface CompensateRepository extends MongoRepository<Compensate, String> {
	Compensate findByEmployeeId(String employeeId);

}
