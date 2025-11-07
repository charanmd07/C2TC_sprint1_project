package com.tnsif.shopownerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tnsif.shopownerservice.entity.ShopOwner;
import com.tnsif.shopownerservice.service.ShopOwnerService;

import jakarta.persistence.NoResultException;

@RestController
public class ShopOwnerController {
	
	@Autowired
	private ShopOwnerService S;
	
	@GetMapping("/shopownerservice")
	public List<ShopOwner> listAll(){
		return S.listAll();
	}
	
	@PostMapping("/shopownerservice")
	public void add(@RequestBody ShopOwner S1) {
		S.save(S1);
	}
	
	@GetMapping("/shopownerservice/{id}")
	public ResponseEntity<ShopOwner> get(@PathVariable Integer id){
		try {
			ShopOwner S2 = S.get(id);
			return new ResponseEntity<ShopOwner>(S2, HttpStatus.OK);
		} catch (NoResultException e) {
			return new ResponseEntity<ShopOwner>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/shopownerservice/{id}")
	public void delete(@PathVariable Integer id) {
		S.delete(id);
	}
	
	@PutMapping("/shopownerservice/{id}")
	public ResponseEntity<ShopOwner> update(@PathVariable Integer id, @RequestBody ShopOwner update_S){
		try {
			ShopOwner exist_S = S.get(id);
			exist_S.setOwnerName(update_S.getOwnerName());
			exist_S.setShopName(update_S.getShopName());
			exist_S.setEmailId(update_S.getEmailId());
			exist_S.setPhoneNumber(update_S.getPhoneNumber());
			exist_S.setUserName(update_S.getUserName());
			exist_S.setPassword(update_S.getPassword());
			S.update(exist_S);
			return new ResponseEntity<ShopOwner>(exist_S, HttpStatus.OK);
		} catch (NoResultException e) {
			return new ResponseEntity<ShopOwner>(HttpStatus.NOT_FOUND);
		}
	}
	
}
