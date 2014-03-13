package aykutuysal.itjobboard.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import aykutuysal.itjobboard.model.User;

public class UserRegistration {
	
	@NotEmpty
	@Email
	//@Pattern(regexp = ".+@.+\\.[a-z]+")
	private String email;

	@Size(min=6)
	
	private String password;
	
	@Size(min=6)
	private String confirmPassword;
	
	@NotNull
	@NotEmpty
	private String firstName;
	
	@NotNull
	@NotEmpty
	private String lastName;
	
	@NotNull
	@NotEmpty
	private String title;
	
	@Pattern(regexp = "[0-9]+")
	private String phone;
	
	private String countryId;
	
	private Boolean subscribe;
	
	@NotNull
	private CommonsMultipartFile resume;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public Boolean getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Boolean subscribe) {
		this.subscribe = subscribe;
	}

	public CommonsMultipartFile getResume() {
		return resume;
	}

	public void setResume(CommonsMultipartFile resume) {
		this.resume = resume;
	}
	
	public User getUser() {
		User u = new User();
		u.setCountryId(this.countryId);
		u.setEmail(this.email);
		u.setFirstName(this.firstName);
		u.setLastName(this.lastName);
		u.setPassword(this.password);
		u.setPhone(this.phone);
		u.setTitle(this.title);
		return u;
	}
	
}
