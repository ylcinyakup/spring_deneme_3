package spring_deneme_001.service;

import java.util.List;

import spring_deneme_001.model.Address;
import spring_deneme_001.model.User;

public interface AddressService {
	
	List<Address> findAll();
	
	void save(Address address);
		
	List<Address> findByUser(User user);
	
	Address findOne(Long id);

	void delete(Long id);
	
	void deleteAll();
}
