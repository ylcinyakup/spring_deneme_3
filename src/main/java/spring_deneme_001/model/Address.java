package spring_deneme_001.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5671955647193022381L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String address;

	@ManyToOne
	private User user;

	public Address() {
	}

	public Address(String address) {
		this.address = address;
	}

	public Address(String address, User user) {
		this.address = address;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", user=" + user + "]";
	}

}
