package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.StatusMain;
import com.demo.repositories.StatusMainRepository;

@Service("statusMainService")
public class StatusMainServiceImpl implements StatusMainService {

	@Autowired
	private StatusMainRepository statusMainRepository;
	
	@Override
	public StatusMain findById(Integer statusId) {
		return statusMainRepository.findById(statusId).get();
	}

}