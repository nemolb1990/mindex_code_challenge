package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensate;

public interface CompensateService {
	Compensate read(String id);
	Compensate create(Compensate compensate);

}
