package spring_deneme_001.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring_deneme_001.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByFirstname(String firstname);

	User findByLastname(String lastname);

	List<User> findAll();

}
