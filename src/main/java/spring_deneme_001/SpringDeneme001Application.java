package spring_deneme_001;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring_deneme_001.model.Address;
import spring_deneme_001.model.PhoneNumber;
import spring_deneme_001.model.User;
import spring_deneme_001.repository.UserRepository;
import spring_deneme_001.service.UserService;

@SpringBootApplication
public class SpringDeneme001Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDeneme001Application.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		User user1 = new User("asdqwe", "asdqwe", "asdqwe");
		User user2 = new User("yakup", "yalcin", "ylcinyakup@gmail.com");
		Set adresler = new LinkedHashSet<Address>() {
			{
				add(new Address("adres1"));
				add(new Address("adres2"));
				add(new Address("adres3"));
			}
		};
		Set adresler2 = new LinkedHashSet<Address>() {
			{
				add(new Address("adrasd"));
				add(new Address("asd"));
				add(new Address("qwe"));
			}
		};
		user1.setAddresses(adresler);
		user2.setAddresses(adresler2);

		Set phoneNumbers = new LinkedHashSet<PhoneNumber>() {
			{
				add(new PhoneNumber("numara1"));
				add(new PhoneNumber("numara2"));
				add(new PhoneNumber("numara3"));
			}
		};
		Set phoneNumbers2 = new LinkedHashSet<PhoneNumber>() {
			{
				add(new PhoneNumber("123123"));
				add(new PhoneNumber("123123"));
				add(new PhoneNumber("1231"));
			}
		};
		user1.setPhoneNumbers(phoneNumbers);
		user2.setPhoneNumbers(phoneNumbers2);

		userService.save(user1);
		userService.save(user2);
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		System.out.println(userService.findAll());

		System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
		System.out.println(userService.findByFirstname("asdqwe"));

		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
		System.out.println(userService.findByLastname("yalcin")); // null dönücek çünkü 2. yi yukaruda sildik

		System.out.println(userRepository.exists(1l)); // true yazmalı

	}
}
