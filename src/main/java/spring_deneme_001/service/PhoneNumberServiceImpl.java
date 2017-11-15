package spring_deneme_001.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_deneme_001.model.PhoneNumber;
import spring_deneme_001.model.User;
import spring_deneme_001.repository.PhoneNumberRepository;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

	@Autowired
	private PhoneNumberRepository phoneNumberRepository;

	@Override
	public List<PhoneNumber> findAll() {
		return phoneNumberRepository.findAll();
	}

	@Override
	public void save(PhoneNumber phoneNumber) {
		phoneNumberRepository.save(phoneNumber);
	}

	@Override
	public List<PhoneNumber> findByUser(User user) {
		return phoneNumberRepository.findByUser(user);
	}

	@Override
	public PhoneNumber findOne(Long id) {
		return phoneNumberRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		phoneNumberRepository.delete(id);
	}

	@Override
	public void deleteAll() {
		phoneNumberRepository.deleteAll();
	}

}
