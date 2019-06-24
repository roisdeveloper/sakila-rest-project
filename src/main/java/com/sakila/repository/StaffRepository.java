package com.sakila.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sakila.entity.Staff;

@Repository
public interface StaffRepository extends PagingAndSortingRepository<Staff,Long>{

}
