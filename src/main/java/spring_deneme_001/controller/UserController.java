package spring_deneme_001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import spring_deneme_001.model.Address;
import spring_deneme_001.model.PhoneNumber;
import spring_deneme_001.model.User;
import spring_deneme_001.service.AddressService;
import spring_deneme_001.service.PhoneNumberService;
import spring_deneme_001.service.UserService;

/**
 * 
 * @Or yakup
 *
 */

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private PhoneNumberService phoneNumberService;

	@Autowired
	private AddressService addressService;

	// /users yani bütün userları geriye döndericek.
	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}

	// /users yeni bir user kayıt ediyor.
	@PostMapping
	public ResponseEntity<List<User>> createUser(@RequestBody User user) {
		userService.save(user);
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.CREATED);
	}

	// /users/1 ==== user id si 1 olan kullanıcıyı getiriyor
	@GetMapping(value = "/{userId}")
	public User findUserById(@PathVariable Long userId) {
		return userService.findOne(userId);
	}

	// /users/1 ==== user id si 1 olan kullanıcıyı siliyor
	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<List<User>> deleteUserById(@PathVariable("userId") long userId) {
		userService.delete(userId);
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);

	}

	// /users/1 ==== user id si 1 olan kullanıcının bilgilerini güncelliyor
	@PutMapping(value = "/{userId}")
	public ResponseEntity<List<User>> updateUserById(@PathVariable("userId") long userId, @RequestBody User user) {
		User currentUser = userService.findOne(userId);
		currentUser.setFirstname(user.getFirstname());
		currentUser.setLastname(user.getLastname());
		currentUser.setEmail(user.getEmail());

		userService.save(currentUser);

		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}

}
