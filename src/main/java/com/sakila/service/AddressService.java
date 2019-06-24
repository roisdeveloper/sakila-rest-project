package com.sakila.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sakila.entity.Address;;

public interface AddressService {
	public Page<Address> showAllAddress(Pageable pageable);
	public Address showAddressByAddressId(Long address_id);
}
