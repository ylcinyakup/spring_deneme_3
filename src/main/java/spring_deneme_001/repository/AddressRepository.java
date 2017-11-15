package spring_deneme_001.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring_deneme_001.model.Address;
import spring_deneme_001.model.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findAll();
	
	List<Address> findByUser(User user);
	
	Address findOne(Long id);

	void delete(Long id);
	
	void deleteAll();
	
}
