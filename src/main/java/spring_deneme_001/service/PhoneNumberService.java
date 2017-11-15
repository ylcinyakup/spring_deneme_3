package spring_deneme_001.service;

import java.util.List;

import spring_deneme_001.model.PhoneNumber;
import spring_deneme_001.model.User;

public interface PhoneNumberService {

	List<PhoneNumber> findAll();

	void save(PhoneNumber phoneNumber);

	List<PhoneNumber> findByUser(User user);

	PhoneNumber findOne(Long id);

	void delete(Long id);

	void deleteAll();

}
