package spring_deneme_001.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring_deneme_001.model.Address;
import spring_deneme_001.model.User;
import spring_deneme_001.service.AddressService;
import spring_deneme_001.service.UserService;

@RestController
@RequestMapping(value = "/users/{userId}/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;

	// users/1/addresses 1. userın adreslerini dönderir...
	@GetMapping
	public List<Address> userAddresses(@PathVariable Long userId) {
		return addressService.findByUser(userService.findOne(userId));
	}
	
	@PostMapping
	public void createAddress(@PathVariable Long userId, @RequestBody Address address) {
		address.setUser(userService.findOne(userId));
		addressService.save(address);
	}

	// users/1/addresses/1 1.. userın 1.adresini geriye gönderir
	@GetMapping(value = "/{adrsId}")
	public Address userAddress(@PathVariable Long userId, @PathVariable Long adrsId) {
		return addressService.findOne(adrsId);
	}

}
