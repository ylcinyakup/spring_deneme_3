package spring_deneme_001.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_deneme_001.model.Address;
import spring_deneme_001.model.User;
import spring_deneme_001.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	@Override
	public void save(Address address) {
		addressRepository.save(address);
	}

	@Override
	public List<Address> findByUser(User user) {
		return addressRepository.findByUser(user);
	}

	@Override
	public Address findOne(Long id) {
		return addressRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		addressRepository.delete(id);
	}

	@Override
	public void deleteAll() {
		addressRepository.deleteAll();
	}

}
