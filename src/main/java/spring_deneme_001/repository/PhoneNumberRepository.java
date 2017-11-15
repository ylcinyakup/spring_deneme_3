package spring_deneme_001.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring_deneme_001.model.PhoneNumber;
import spring_deneme_001.model.User;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {

	PhoneNumber findByPhoneNumber(String phoneNumber);

	List<PhoneNumber> findAll();

	List<PhoneNumber> findByUser(User user);

	PhoneNumber findOne(Long id);

	void delete(Long id);

	void deleteAll();
}
