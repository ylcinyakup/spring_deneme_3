package spring_deneme_001.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "phone_number")
public class PhoneNumber implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5671955647193022381L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String phoneNumber;

	@ManyToOne
	private User user;

	public PhoneNumber() {
	}

	public PhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneNumber(String phoneNumber, User user) {
		this.phoneNumber = phoneNumber;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", phoneNumber=" + phoneNumber + ", user=" + user + "]";
	}

}
