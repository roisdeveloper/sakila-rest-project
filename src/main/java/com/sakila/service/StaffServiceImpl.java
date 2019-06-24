package com.sakila.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sakila.entity.Staff;
import com.sakila.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	private StaffRepository repository;
	
	@Override
	public Page<Staff> showAllStaff(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Staff showStaffByStaffId(Long staff_id) {
		Optional<Staff> optionalStaff=repository.findById(staff_id);		
		if(optionalStaff.isPresent()) {
			return optionalStaff.get();
		}
		return null;
	}
}
