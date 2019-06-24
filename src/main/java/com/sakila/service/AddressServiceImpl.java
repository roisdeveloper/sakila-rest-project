package com.sakila.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sakila.entity.Address;
import com.sakila.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository repository;
	@Override
	public Page<Address> showAllAddress(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Address showAddressByAddressId(Long address_id) {
		Optional<Address> optionalAddress=repository.findById(address_id);		
		if(optionalAddress.isPresent()) {
			return optionalAddress.get();
		}
		return null;
	}

}
