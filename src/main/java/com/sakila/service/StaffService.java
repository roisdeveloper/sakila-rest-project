package com.sakila.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sakila.entity.Staff;

public interface StaffService {
	public Page<Staff> showAllStaff(Pageable pageable);
	public Staff showStaffByStaffId(Long staff_id);
}
