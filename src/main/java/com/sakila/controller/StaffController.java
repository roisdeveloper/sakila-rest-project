package com.sakila.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakila.entity.Staff;
import com.sakila.exception.EntityNotFoundException;
import com.sakila.service.StaffService;

@RestController
@RequestMapping(value="/api/staff/")
public class StaffController {
	private static Logger LOG=LoggerFactory.getLogger(StaffController.class);
	@Autowired
	private StaffService service;
	
	@GetMapping(value="/show",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Staff>> showAllStaff(Pageable pageable){
		Page<Staff> staffPage=service.showAllStaff(pageable);
		if(staffPage.isEmpty()) {
			LOG.info("NO CONTENT");
			return new ResponseEntity<Page<Staff>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Staff>>(staffPage,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value="/show/{staff_id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Staff> showByStaffId(@PathVariable(name="staff_id") Long staff_id){
		Staff staff=service.showStaffByStaffId(staff_id);
		if(staff == null) {	
			LOG.info("NO CONTENT");
			throw new EntityNotFoundException("ID "+staff_id+" not found.");
		}
		return new ResponseEntity<Staff>(staff,new HttpHeaders(),HttpStatus.OK);
	}
}
