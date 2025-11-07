package com.tnsif.shopownerservice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.shopownerservice.entity.ShopOwner;
import com.tnsif.shopownerservice.repository.ShopOwnerRepository;

@Service
public class ShopOwnerService {
	@Autowired
	private ShopOwnerRepository repo;
	
	public List<ShopOwner> listAll(){
		return repo.findAll();
	}
	
	public void save(ShopOwner S) {
		repo.save(S);
	}
	
	public ShopOwner get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public void update(ShopOwner S) {
		repo.save(S);
	}
	
}
