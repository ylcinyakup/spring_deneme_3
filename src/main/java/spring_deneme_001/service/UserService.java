package spring_deneme_001.service;

import java.util.List;

import spring_deneme_001.model.User;

public interface UserService {

	User findByFirstname(String firstname);

	User findByLastname(String lastname);

	void deleteAll();

	void delete(Long id);

	User findOne(Long id);

	void save(User user);

	List<User> findAll();

}
