package spring_deneme_001.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring_deneme_001.model.PhoneNumber;
import spring_deneme_001.service.PhoneNumberService;
import spring_deneme_001.service.UserService;

@RestController
@RequestMapping(value = "/users/{userId}/phoneNumbers", produces = MediaType.APPLICATION_JSON_VALUE)
public class PhoneNumberController {

	@Autowired
	private UserService userService;

	@Autowired
	private PhoneNumberService phoneNumberService;

	// users/1/phoneNumbers 1. userın telefon numaralarını gönderir...
	@GetMapping
	public List<PhoneNumber> userPhoneNumbers(@PathVariable Long userId) {
		return phoneNumberService.findByUser(userService.findOne(userId));
	}

	// users/1/phoneNumbers/1 1.. userın 1.telefon numarasını geriye gönderir
	@GetMapping(value = "/{phnId}")
	public PhoneNumber userPhoneNumber(@PathVariable Long userId, @PathVariable Long phnId) {
		return phoneNumberService.findOne(phnId);
	}

}
