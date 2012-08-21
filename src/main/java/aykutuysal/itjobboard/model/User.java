package aykutuysal.itjobboard.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="Users")
public class User implements Serializable {

	private static final long serialVersionUID = 1078595589782369491L;

	@Id
    @GeneratedValue
	private Long id;
	
	@Column(unique=true)
	@NotEmpty
	@Pattern(regexp = ".+@.+\\.[a-z]+")
	private String email;

	private String password;
	
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
	private String role;
	private Boolean enabled = true;
	
	private Date registrationDate = new Date();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Application> applications;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<Resume> resumes;
	
	public User() {
		this.role = "ROLE_USER";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
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

	public List<Resume> getResumes() {
		return resumes;
	}

	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", title=" + title + ", phone=" + phone + ", countryId="
				+ countryId + ", role=" + role + ", enabled=" + enabled
				+ ", registrationDate=" + registrationDate + ", applications="
				+ applications + ", resumes=" + resumes + "]";
	}
	
	
}