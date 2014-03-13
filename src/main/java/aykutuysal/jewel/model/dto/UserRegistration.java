package aykutuysal.jewel.model.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import aykutuysal.jewel.model.user.User;

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
	
	@Pattern(regexp = "[0-9]+")
	private String phone;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public User convertToUser() {
		User user = new User();
		user.setEmail(this.email);
		user.setFirstName(this.firstName);
		user.setLastName(this.lastName);
		user.setPassword(this.password);
		user.setPhone(this.phone);
		user.setRegistrationDate(new Date());
		return user;
	}

	@Override
	public String toString() {
		return "UserRegistration [email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phone=" + phone
				+ "]";
	}
	
}
